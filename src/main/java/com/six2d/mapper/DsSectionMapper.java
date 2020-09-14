package com.six2d.mapper;

import com.six2d.entity.DsSection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DsSectionMapper {

    @Select("select * from ds_section")
    List<DsSection> getDsSection();
}
