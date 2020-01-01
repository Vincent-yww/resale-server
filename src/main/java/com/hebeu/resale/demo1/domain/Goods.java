package com.hebeu.resale.demo1.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Goods extends BaseEntity implements Serializable {
    private Integer id;

    private BigDecimal price;

    private String name;

    private Integer category;

    private String desc;

    private Integer fromuser;

    private String pic;

    private String detail;

    private String detailimgs;

    private Date createtime;

    private Date updatetime;

    private Integer school;

    /**
     * 商品新旧程度
     */
    private String condition;

    private static final long serialVersionUID = 1L;
}