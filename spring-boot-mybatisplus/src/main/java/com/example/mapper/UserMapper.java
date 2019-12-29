package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wangzefeng
 * @date 2019/12/21 11:49
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
