package com.six2d.service.impl;

import com.six2d.entity.DsAdmin;
import com.six2d.mapper.DsAdminMapper;
import com.six2d.service.DsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DsAdminServiceImpl implements DsAdminService {
    @Autowired
    private DsAdminMapper dsAdminMapper;

    @Override
    public DsAdmin getDsAdminByLogin(DsAdmin dsAdmin) {
        return dsAdminMapper.getDsAdminByLogin(dsAdmin);
    }
}
