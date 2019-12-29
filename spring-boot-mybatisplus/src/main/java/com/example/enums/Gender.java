package com.example.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

/**
 * @author Wzefeng
 * @date 2019/12/21 11:22
 */
public enum Gender implements IEnum<Integer> {

    /**
     * 女性
     */
    FEMALE(0),

    /**
     * 男性
     */
    MALE(1),

    /**
     * 其他
     */
    OTHER(2);

    private final int value;

    Gender(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
