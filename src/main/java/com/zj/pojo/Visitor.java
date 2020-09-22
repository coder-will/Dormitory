package com.zj.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Visitor {
    private Integer v_id;
    private String v_name;
    private String v_phone;
    private Integer v_dormitoryid;
    private String v_dormbuilding;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;
}

