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
public class Category extends BaseEntity implements Serializable {
    public static final String COL_C_ID = "c_id";
    public static final String COL_C_NAME = "c_name";
    private Integer cId;

    private String cName;

    private static final long serialVersionUID = 1L;
}