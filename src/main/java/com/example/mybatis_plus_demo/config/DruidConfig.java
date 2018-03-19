/**
 * @author xiahongjian 
 * @time   Mar 16, 2018
 */
package com.example.mybatis_plus_demo.config;

import javax.sql.DataSource;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @author xiahongjian
 * @time 2018-03-16 16:04:50
 *
 */
//@Configuration
public class DruidConfig {
	// 配置数据源
	@Bean(initMethod = "init", destroyMethod = "close")
	public DataSource initDataSource() {
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName("com.mysql.jdbc.Driver");
		dds.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
		dds.setUsername("root");
		dds.setPassword("root");
		dds.setInitialSize(1);
		dds.setMinIdle(1);
		dds.setMaxActive(10);
		dds.setMaxWait(1000);
		dds.setTimeBetweenEvictionRunsMillis(60000);
		dds.setMinEvictableIdleTimeMillis(300000);
		dds.setValidationQuery("select 1");
		dds.setTestWhileIdle(true);
		dds.setTestOnBorrow(true);
		dds.setTestOnReturn(false);
		dds.setPoolPreparedStatements(true);
		dds.setMaxPoolPreparedStatementPerConnectionSize(20);
		try {
			dds.setFilters("stat");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dds;
	}

	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
				"/druid/*");
		// 设置登录查看信息的账号密码.
//		servletRegistrationBean.addInitParameter("loginUsername", loginUsername);
//		servletRegistrationBean.addInitParameter("loginPassword", loginPassword);
		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
