package com.example.order.feign;

import com.example.order.fallback.ProductFallBack;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: xiaozhi
 * @Date: 2020/5/8 10:14
 * @Desc:
 */
@FeignClient(value = "product",fallback = ProductFallBack.class)
public interface ProductClient {

//
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
//    })
    @RequestMapping(value = "/product",method = RequestMethod.POST)
    String getProduct(String param);
}
