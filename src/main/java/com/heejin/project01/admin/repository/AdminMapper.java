package com.heejin.project01.admin.repository;

import com.heejin.project01.admin.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    boolean regist(Admin admin);

    void delete(Admin admin);

    boolean update(Admin admin);

    //회원검색
    Admin selectOne(String admin);

    List<Admin> selectAll(String admin);


}
