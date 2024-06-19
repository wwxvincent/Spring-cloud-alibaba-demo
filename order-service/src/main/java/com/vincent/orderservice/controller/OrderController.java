package com.vincent.orderservice.controller;

import com.vincent.commonmodule.entity.OrderEntity;
import com.vincent.orderservice.feignClient.PointServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Vincent(Wenxuan) Wang
 * @Date: 6/19/24
 * @Description:
 */
@RefreshScope
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Value("${config.info}")
    private String configInfo;

    @Autowired
    private PointServiceFeignClient pointServiceFeignClient;

    @GetMapping(value = "/test")
    public String test() {
        return "Love from order-service, bro!";
    }

    @GetMapping(value = "/test/getConfigInfo")
    public String testDynamicConfig() {
        return configInfo;
    }

    @PostMapping(value = "/add")
    public String addOrder(){
        OrderEntity order = new OrderEntity();
        order.setId("123");
        order.setProductName("键盘");
        String res = pointServiceFeignClient.addPoint(order);
        return res;
    }

    @PostMapping(value = "/add2")
    public String addOrder2(){
        String res = pointServiceFeignClient.addPoint2("鲜橙多");
        return res;
    }
}
