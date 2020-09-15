package com.six2d.service.impl;

import com.six2d.entity.DsSection;
import com.six2d.mapper.DsSectionMapper;
import com.six2d.service.DsSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DsSectionServiceImpl implements DsSectionService {

    @Autowired
    private DsSectionMapper dsSectionMapper;

    @Override
    public List<DsSection> getDsSection() {
        return dsSectionMapper.getDsSection();
    }

    @Override
    public DsSection getDsSectionById(Integer id) {
        return dsSectionMapper.getDsSectionById(id);
    }

    @Override
    public List<DsSection> getDsSectionByPid(Integer pId) {
        return dsSectionMapper.getDsSectionByPid(pId);
    }

    @Override
    public Integer setDsSectionById(DsSection dsSection) {
        return dsSectionMapper.setDsSectionById(dsSection);
    }
}
