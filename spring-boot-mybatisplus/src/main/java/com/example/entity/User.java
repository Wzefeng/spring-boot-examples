package com.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.example.enums.Education;
import com.example.enums.Gender;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

/**
 * User BO
 *
 * @author wangzefeng
 * @date 2019/12/21 11:22
 */
@Data
@TableName("t_user")
public class User {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "name", jdbcType = JdbcType.VARCHAR)
    private String name;

    /**
     * 年龄
     */
    @TableField(value = "age", jdbcType = JdbcType.INTEGER)
    private Integer age;

    /**
     * 性别
     */
    @TableField(value = "gender", jdbcType = JdbcType.INTEGER)
    private Gender gender;

    /**
     * 学历
     */
    @TableField(value = "education", jdbcType = JdbcType.INTEGER)
    private Education education;

    /**
     * 生日
     */
    @TableField(value = "birthday", jdbcType = JdbcType.DATE)
    private Date birthday;
}
