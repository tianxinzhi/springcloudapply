package com.example.product.contoller;

import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xiaozhi
 * @Date: 2020/5/8 9:46
 * @Desc:
 */
@RestController
public class ProductController {

    @RequestMapping(value = "/product",method = RequestMethod.POST)
    public String getProduct(@RequestBody String param){
        System.out.println("param:"+param);
        try {
            if(param.contains("error")){
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date())+":调用product api成功!!!";
    }
}
