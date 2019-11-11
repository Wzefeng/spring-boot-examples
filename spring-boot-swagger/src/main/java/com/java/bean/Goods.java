package com.java.bean;

import lombok.Data;

/**
 * 商品实体类
 *
 * @author wangzefeng
 * @date 2019/11/9 22:10
 */
@Data
public class Goods {

    private Long id;

    private String name;

    private Double price;
}
