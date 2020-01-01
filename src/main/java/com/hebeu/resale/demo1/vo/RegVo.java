package com.hebeu.resale.demo1.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegVo {
    private String username;
    private String token;
    private String phone;
    private String password;
    private Integer school;
    private String verification;

}
