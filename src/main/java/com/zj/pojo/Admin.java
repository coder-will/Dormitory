package com.zj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 管理员类
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer a_id;
    private String a_username;
    private String a_password;
    private String a_name;
    private String a_phone;
    private Integer a_power;
    private String a_describe;
}
