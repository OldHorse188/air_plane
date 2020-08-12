package com.neuedu.air_plane.model;

import lombok.Data;

import java.util.Date;

@Data
public class Manager {
    private Integer manAutoId; //id
    private String manAccount; // 账号
    private String manPwd;//密码
    private String manId;//身份证
    private String manSex;
    private String manTelNumber;
    private String manEmail;
    private Date manTime;
    private String flag; //逻辑删除标记

}
