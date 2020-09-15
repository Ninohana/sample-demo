package com.six2d.service;


import com.six2d.entity.DsSection;

import java.util.List;

public interface DsSectionService {

    List<DsSection> getDsSection();

    DsSection getDsSectionById(Integer id);

    List<DsSection> getDsSectionByPid(Integer pId);

    Integer setDsSectionById(DsSection dsSection);
}
