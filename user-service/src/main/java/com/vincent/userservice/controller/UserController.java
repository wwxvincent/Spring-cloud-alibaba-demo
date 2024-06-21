package com.vincent.userservice.controller;

import com.vincent.commonmodule.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import static com.vincent.commonmodule.util.JwtUtil.TOKEN_TIME_OUT;

/**
 * @Author: Vincent(Wenxuan) Wang
 * @Date: 6/20/24
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Value("${config.redisTimeout}")
    private Long redisTimeout;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/login")
    public String login() {
        //1. 验证账号密码 to-do
        //2. 生成token
        String token = JwtUtil.getToken("123");
        //3. 将token存入redis
        // 先将 key 和 value的值都设置为token
//        redisTemplate.opsForValue().set(token,token,TOKEN_TIME_OUT, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(token,token,redisTimeout, TimeUnit.SECONDS);
        //4. 将token返回客户端
        return token;
    }
}
