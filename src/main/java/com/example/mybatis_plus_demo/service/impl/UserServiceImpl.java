package com.example.mybatis_plus_demo.service.impl;

import com.example.mybatis_plus_demo.entity.User;
import com.example.mybatis_plus_demo.mapper.UserMapper;
import com.example.mybatis_plus_demo.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hongjian.xia
 * @since 2018-03-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Override
	public User selectByUsername(String username) {
		return baseMapper.selectByUsername(username);
	}
}
