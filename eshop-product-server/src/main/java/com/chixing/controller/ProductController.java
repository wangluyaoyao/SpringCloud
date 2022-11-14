package com.chixing.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chixing.entity.Product;
import com.chixing.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wang
 * @since 2022-10-14
 */
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @Value("{server.port}")
    private String serverPort;

    @SentinelResource(value = "productIdHotKey",blockHandler = "handlerHotKey" )
    @GetMapping("/product/{productId}")
    public Product getCustomer(@PathVariable("productId")Integer productId){
        System.out.println("用户正在访问id:"+productId);
        return productService.getById(productId);
    }

    @SentinelResource(value = "selectAllHotKey",blockHandler = "handlerHotKey1",fallback = "handlerFallback" )
    @GetMapping("/selectAll")
    public List<Product> selectAll(){
        return productService.selectAll();
    }

    //兜底方法：blockHandler
    public String handlerHotKey(Integer productId, BlockException exception){
        return "blockHandler:目前用户请求所有商品访问量过大，请稍后访问";
    }

    public String handlerHotKey1(Integer productId, BlockException exception){
        return "blockHandler:目前用户访问商品详情流量过大，请稍后访问";
    }

    //兜底方法：fallback
    public String hanlderFallback(Integer productId){
        return "fallback:系统异常，请稍后再试"+productId;
    }
}


