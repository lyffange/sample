package com.exsample.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exsample.springboot.domain.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
