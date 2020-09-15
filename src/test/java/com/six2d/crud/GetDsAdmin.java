package com.six2d.crud;

import com.six2d.entity.DsAdmin;
import com.six2d.mapper.DsAdminMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetDsAdmin {

    @Autowired
    DsAdminMapper dsAdminMapper;

    @Test
    void get() {
        DsAdmin dsAdmin = new DsAdmin();
        dsAdmin.setAdmin_account("admin");
        DsAdmin user = dsAdminMapper.getTest("admin");
        System.out.println(user);
        //测试通过
    }
}
