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
public class Items extends BaseEntity implements Serializable {
    public static final String COL_ID = "id";
    public static final String COL_CREATE_TIME = "create_time";
    public static final String COL_FLAG = "flag";
    public static final String COL_MODIFY_TIME = "modify_time";
    public static final String COL_VERSION = "version";
    public static final String COL_BUY_COUNT = "buy_count";
    public static final String COL_CITY = "city";
    public static final String COL_DISCOUNT = "discount";
    public static final String COL_IS_FREE_POST = "is_free_post";
    public static final String COL_NAME = "name";
    public static final String COL_NUMBER = "number";
    public static final String COL_PIC = "pic";
    public static final String COL_PRICE = "price";
    public static final String COL_PROPERTY = "property";
    public static final String COL_PROVINCE = "province";
    public static final String COL_SHOP_ID = "shop_id";
    public static final String COL_SHOP_NAME = "shop_name";
    public static final String COL_STATUS = "status";
    private Integer id;

    private Integer buyCount;

    private String city;

    private Double discount;

    private Boolean isFreePost;

    private String name;

    private Integer number;

    private String pic;

    private Integer price;

    private String property;

    private String province;

    private Integer shopId;

    private String shopName;

    private Integer status;

    private static final long serialVersionUID = 1L;
}