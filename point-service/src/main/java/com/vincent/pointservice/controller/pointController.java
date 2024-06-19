package com.vincent.pointservice.controller;

import com.vincent.commonmodule.entity.OrderEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Vincent(Wenxuan) Wang
 * @Date: 6/19/24
 * @Description:
 */
@RestController
@RequestMapping(value = "/point")
public class pointController {

    @GetMapping(value = "/test")
    public String test() {
        return "Love from point-service, my friend!";
    }

    @PostMapping(value = "/add")
    public String addPoint(@RequestBody OrderEntity order) {
        return "add point success! 商品名称: " + order.getProductName();
    }

    @PostMapping(value = "/add2")
    public String addPoint2(@RequestParam("productName") String productName) {
        return "add point success! 商品名称： " + productName;
    }
}
