package com.hebeu.resale.demo1.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVo {
    private Integer price;
    private String name;
    private Integer category;
    private String desc;
    private Integer fromuser;
    private String pic;
    private String detail;
    private String detailimgs;
    private Integer school;
    private String condition;
}
