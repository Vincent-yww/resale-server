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
public class School extends BaseEntity implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}