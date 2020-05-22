package com.example.order.fallback;

import com.example.order.feign.ProductClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

/**
 * @Author: xiaozhi
 * @Date: 2020/5/8 10:55
 * @Desc:
 */
@Component
public class ProductFallBack implements ProductClient {

    @Override
    public String getProduct(String param) {
        System.out.println("param:"+param);
        return "调用失败，product服务开小差了^-^!!";
    }
}
