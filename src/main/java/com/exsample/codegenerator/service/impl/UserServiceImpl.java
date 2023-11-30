package com.exsample.codegenerator.service.impl;

import com.exsample.codegenerator.entity.User;
import com.exsample.codegenerator.mapper.UserMapper;
import com.exsample.codegenerator.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 1111
 * @since 2023-11-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
