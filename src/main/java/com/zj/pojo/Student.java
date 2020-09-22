package com.zj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * 学生类 存储学生信息
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private static final long serialVersionUID = 1L;
    private  Integer s_id;
    private  Integer s_studentid;
    private  String  s_name;
    private  String  s_sex;
    private  Integer s_age;
    private  String  s_phone;
    private  Integer s_classid;
    private  String  s_classname;
    private  Integer s_dormitoryid;
}
