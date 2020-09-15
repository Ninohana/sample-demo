package com.six2d.mapper;

import com.six2d.entity.DsSection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DsSectionMapper {

    @Select("select * from ds_section")
    List<DsSection> getDsSection();

    @Select("select * from ds_section where section_id = #{id}")
    DsSection getDsSectionById(Integer id);

    @Select("select * from ds_section where section_pId = #{pId}")
    List<DsSection> getDsSectionByPid(Integer pId);

    @Update("update ds_section set section_name=#{section_name},section_pId=#{section_pId} where section_id=#{section_id}")
    Integer setDsSectionById(DsSection dsSection);
}
