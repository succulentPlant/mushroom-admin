package com.example.mushroomadmin.module.login.service;

import com.example.mushroomadmin.module.login.entity.dto.UserDto;

/**
 * @author ting.xu
 * @date 2023-04-21 13:56
 */
public interface LoginService {

    String login(UserDto userDto);
}
