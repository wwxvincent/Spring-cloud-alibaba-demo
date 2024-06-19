package com.vincent.orderservice.feignClient;

import com.vincent.commonmodule.entity.OrderEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Vincent(Wenxuan) Wang
 * @Date: 6/19/24
 * @Description:
 */
@FeignClient(value = "point-service")// 这个就是各个服务在nacos中的注册名称
public interface PointServiceFeignClient {

    @PostMapping(value = "/point/add") // 设置被调用的接口: url 就是point-service对应的接口地址
    String addPoint(@RequestBody OrderEntity order);

    @PostMapping(value = "/point/add2") // 设置被调用的接口: url 就是point-service对应的接口地址
    String addPoint2(@RequestParam("productName") String productName);
}
