package com.example.mushroomadmin.module.login.service.impl;

import com.example.mushroomadmin.module.login.entity.dto.UserDto;
import com.example.mushroomadmin.module.login.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * @author ting.xu
 * @date 2023-04-21 14:00
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static Map<String, String> users = new HashMap<String,String>(){{
        put("张三","123");
        put("李四","456");
        put("王五","789");
    }};

    @Override
    public String login(UserDto userDto) {
        String password = users.get(userDto.getAccount());
        if(password == null){
            return "用户不存在";
        }else{
            if(!password.equals(userDto.getPassword())){
                return "密码不正确";
            }
        }
        return "登陆成功";
    }
}
