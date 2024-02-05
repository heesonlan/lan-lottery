package com.lan.lottery.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiUser implements Serializable {
    private String userName;
    private String realName;
    private String workNo;
}
