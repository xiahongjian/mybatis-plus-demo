/**
 * @author xiahongjian 
 * @time   Mar 16, 2018
 */
package com.example.mybatis_plus_demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;

/**
 * @author xiahongjian
 * @time 2018-03-16 14:35:05
 *
 */
@Configuration
@MapperScan("com.example.mybatis_plus_demo.mapper")
public class MybatisPlusConfig {
	@Bean
	public PerformanceInterceptor performanceInterceptor() {
		return new PerformanceInterceptor();
	}

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		paginationInterceptor.setLocalPage(true);
		return paginationInterceptor;
	}
}
