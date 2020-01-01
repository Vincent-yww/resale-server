package com.hebeu.resale.demo1.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseEntity implements Serializable {
    public static final String COL_UID = "uid";
    public static final String COL_CREATE_TIME = "create_time";
    public static final String COL_FLAG = "flag";
    public static final String COL_MODIFY_TIME = "modify_time";
    public static final String COL_VERSION = "version";
    public static final String COL_EMAIL = "email";
    public static final String COL_PASSWORD = "password";
    public static final String COL_PHONE = "phone";
    public static final String COL_USERNAME = "username";
    private Integer uid;

    private String email;

    private String password;

    private String phone;

    private String username;

    private String character;

    private Integer school;

    private static final long serialVersionUID = 1L;
}