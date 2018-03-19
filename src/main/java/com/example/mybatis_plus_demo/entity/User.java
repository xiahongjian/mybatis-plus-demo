package com.example.mybatis_plus_demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.example.mybatis_plus_demo.entity.enums.UserStatus;

/**
 * <p>
 * 
 * </p>
 *
 * @author hongjian.xia
 * @since 2018-03-19
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer age;
    private String username;
    private String password;
    @TableField("regist_time")
    private LocalDateTime registTime;
    private UserStatus status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistTime() {
        return registTime;
    }

    public void setRegistTime(LocalDateTime registTime) {
        this.registTime = registTime;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
        ", id=" + id +
        ", age=" + age +
        ", username=" + username +
        ", password=" + password +
        ", registTime=" + registTime +
        ", status=" + status +
        "}";
    }
}
