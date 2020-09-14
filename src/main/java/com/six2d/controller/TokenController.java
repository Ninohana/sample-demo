package com.six2d.controller;

import com.google.code.kaptcha.Constants;
import com.six2d.mapper.UserMapper;
import com.six2d.entity.MsgData;
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
    UserMapper userMapper;

    @PostMapping("/token")
    @ResponseBody
    public MsgData token(@RequestParam("key") String key,
                         @RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("captcha") String captcha,
                         HttpSession session) {
        // 验证码校验
        if (!session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString().equalsIgnoreCase(captcha)) {
            return MsgData.FAIL;
        }

        // 密钥校验
        String serverKey = session.getAttribute("key").toString();
        if (!serverKey.equals(key)) {
            return MsgData.FAIL;
        }

        //用户信息校验
        User user = userMapper.getUserById(11);
        logger.info("{} {} {} {}", user.getId(), user.getName(), user.getNumber(), user.getPassword());
        if (user.getPassword().equals(password)) {
            session.setAttribute("token", "have");
            return MsgData.SUCCESS;
        }

        return MsgData.ERROR;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
