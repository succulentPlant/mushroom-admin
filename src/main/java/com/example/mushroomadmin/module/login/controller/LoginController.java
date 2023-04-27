package com.example.mushroomadmin.module.login.controller;

import com.example.mushroomadmin.module.login.common.response.Result;
import com.example.mushroomadmin.module.login.common.response.ResultUtils;
import com.example.mushroomadmin.module.login.entity.dto.UserDto;
import com.example.mushroomadmin.module.login.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ting.xu
 * @date 2022-08-28 14:15
 */
@RestController
@RequestMapping(value = "/logjn")
public class LoginController {

    LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/in")
    public Result<String> login(@RequestBody UserDto userDto){
       String flag = loginService.login(userDto);
       return ResultUtils.success(flag);
    }

}
