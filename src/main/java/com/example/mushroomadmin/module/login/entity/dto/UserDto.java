package com.example.mushroomadmin.module.login.entity.dto;

import java.io.Serializable;

/**
 * @author ting.xu
 * @date 2023-04-21 13:29
 */
public class UserDto implements Serializable {
    /**
     * 账户
     */
    private String account;
    /**
     * 密码
     */
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
