package com.six2d.mapper;

import com.six2d.entity.DsAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DsAdminMapper {

    @Select("select * from ds_admin where admin_account = #{admin_account}")
    DsAdmin getDsAdminByLogin(DsAdmin dsAdmin);

    @Select("select * from ds_admin where admin_account = #{admin_account}")
    DsAdmin getTest(String admin_account);
}
