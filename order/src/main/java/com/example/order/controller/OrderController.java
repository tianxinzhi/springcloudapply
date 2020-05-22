package com.example.order.controller;

import com.example.order.feign.ProductClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xiaozhi
 * @Date: 2020/5/8 10:57
 * @Desc:
 */
@RestController
public class OrderController {

//    @Value("${name}")
    private String profiles;

    @Autowired
    private ProductClient productClient;

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public String order(@RequestBody String param) throws Exception{
//        restTemplate.ge
        String product = productClient.getProduct(param);
        return "order调用:"+product;
    }

    @RequestMapping(value = "/proper",method = RequestMethod.GET)
    @ResponseBody
    public String returnFormValue(){
        System.out.println("coming here!");
        return profiles.toString();
    }
}
