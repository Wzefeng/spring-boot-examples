package com.java.bean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户实体类
 *
 * @author wangzefeng
 * @date 2019/11/3 23:25
 */
@Data
@ApiModel(value = "用户实体")
public class User {

    @ApiModelProperty(value = "ID", position = 0)
    private Long id;

    @ApiModelProperty(value = "用户名", position = 1)
    private String userName;

    @ApiModelProperty(value = "年龄", position = 2)
    private Integer age;

    @ApiModelProperty(value = "地址", position = 3)
    private String address;

    @ApiModelProperty(value = "邮箱", position = 4)
    private String email;
}


