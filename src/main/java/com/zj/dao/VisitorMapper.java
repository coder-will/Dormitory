package com.zj.dao;


import com.zj.pojo.Visitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VisitorMapper {
    /**
     * 进行分页查询
     */

    //获取总条数
    public Integer totalCount(@Param("v_name") String v_name, @Param("v_phone") String v_phone);
    //获取用户列表
    public List<Visitor> getVisitorList(@Param("v_name") String v_name, @Param("v_phone") String v_phone, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int addVisitor(Visitor visitor);   //添加学生信息
    public List<Visitor> getAll();

}
