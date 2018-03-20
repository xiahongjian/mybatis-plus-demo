/**
 * @author xiahongjian 
 * @time   Mar 19, 2018
 */
package com.example.mybatis_plus_demo;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.mybatis_plus_demo.entity.User;
import com.example.mybatis_plus_demo.entity.enums.UserStatus;
import com.example.mybatis_plus_demo.service.UserService;

/**
 * @author xiahongjian 
 * @time   2018-03-19 11:34:52
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testInsert() {
		User u = new User();
		u.setUsername("test");
		u.setPassword("test-pwd");
		u.setRegistTime(LocalDateTime.now());
		u.setAge(20);
		u.setStatus(UserStatus.FORBIDDEN);
		userService.insert(u);
		assertNotNull(u.getId());
	}
	
	@Test
	public void testSelect() {
		User u = userService.selectByUsername("test");
		assertNotNull(u);
	}
}
