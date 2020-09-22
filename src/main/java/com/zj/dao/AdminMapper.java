package com.zj.dao;

import com.zj.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*
* Dao层
* */
public interface AdminMapper {

    /*根据管理员的用户名和密码查询管理员*/
    Admin findAdmin(Admin admin);

    /*增加管理员*/
    int addAdmin(Admin admin);

    /*删除管理员*/
    int deleteAdmin(Integer a_id);

    /*修改管理员*/
    int updateAdmin(Admin admin);

    /*根据ID查询管理员*/
    public Admin findAdminById(Integer a_id);

    /*查询所有管理员*/
    public List<Admin> getAllAdmin();

    //获取总条数
    public Integer totalCount(@Param("a_username") String a_username, @Param("a_describe") String a_describe, @Param("a_id") Integer a_id);

    //获取用户列表 --- 执行分页查询
    public List<Admin> getAdminList(@Param("a_username") String a_username, @Param("a_describe") String a_describe,@Param("a_id") Integer a_id, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

}
