package com.zj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    private  Integer c_id;
    private  Integer c_classid;
    private  String  c_classname;
    private  String  c_counsellor;
    //班级与学生为一对多关系，使用链表
    private List<Student> students;
}
