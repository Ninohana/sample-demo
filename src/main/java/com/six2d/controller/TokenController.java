package com.six2d.controller;

import com.google.code.kaptcha.Constants;
import com.six2d.entity.DsAdmin;
import com.six2d.mapper.UserMapper;
import com.six2d.service.DsAdminService;
import com.six2d.util.DESUtil;
import com.six2d.util.Md5Util;
import com.six2d.vo.MsgData;
import com.six2d.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class TokenController {
    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    DsAdminService dsAdminService;

    @PostMapping("/token")
    @ResponseBody
    public MsgData token(@RequestParam("key") String key,
                         @RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("captcha") String captcha,
                         HttpSession session) throws Exception {
        // 验证码校验
        Object attribute = session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (attribute == null) {
            return MsgData.FAIL;
        }
        if (!attribute.toString().equalsIgnoreCase(captcha)) {
            return MsgData.FAIL;
        }

        // 密钥校验
        String serverKey = session.getAttribute("key").toString();
        if (!serverKey.equals(key)) {
            return MsgData.FAIL;
        }

        /**
         * 用户信息校验
         */
        // 解密账号
        username = DESUtil.decryption(username, serverKey);
        logger.info("{} | {}", username, serverKey);
        DsAdmin dsAdmin = new DsAdmin();
        dsAdmin.setAdmin_account(username);
        logger.info(dsAdmin.toString());
        dsAdmin = dsAdminService.getDsAdminByLogin(dsAdmin);
        //比对密码
        String salt = dsAdmin.getAdmin_salt();
        Md5Util md5Util = new Md5Util(salt, "MD5");
        password = md5Util.encode(password); // 新的md5密码
        if (password.equals(dsAdmin.getAdmin_password())) {
            return MsgData.SUCCESS;
        } else {
            return MsgData.FAIL;
        }
    }

    @GetMapping("/home")
    public String home() {
        return "department";
    }
}
