/**
 * @author xiahongjian 
 * @time   Mar 19, 2018
 */
package com.example.mybatis_plus_demo.entity.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * @author xiahongjian 
 * @time   2018-03-19 15:18:41
 *
 */
public enum UserStatus implements IEnum {
	NORMAL(0, "正常"),
	FORBIDDEN(1, "禁用");

	private int value;
	private String desc;
	
	UserStatus(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	@Override
	public Serializable getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
}
