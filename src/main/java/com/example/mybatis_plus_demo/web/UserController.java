package com.example.mybatis_plus_demo.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.mybatis_plus_demo.entity.User;
import com.example.mybatis_plus_demo.service.UserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hongjian.xia
 * @since 2018-03-19
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@GetMapping("")
	public Page<User> findUsers() {
		return userService.selectPage(new Page<>(0, 10));
	}
}

