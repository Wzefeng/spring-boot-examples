package com.example.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author wangzefeng
 * @date 2019/12/21 11:44
 */
public enum Education {

    /**
     * 本科
     */
    UNDERGRADUATE(0),

    /**
     * 硕士
     */
    MASTER(1),

    /**
     * 博士
     */
    DOCTOR(2);

    @Getter
    @EnumValue
    private final int value;

    Education(int value) {
        this.value = value;
    }
}
