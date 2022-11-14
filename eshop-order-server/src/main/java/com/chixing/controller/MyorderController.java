package com.chixing.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chixing.entity.Myorder;
import com.chixing.service.IMyorderService;
import com.chixing.service.MyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wang
 * @since 2022-10-14
 */
@RestController
public class MyorderController {

    @Autowired
    private MyOrder myOrder;

    @Value("{server.port}")
    private String serverPort;

    @GetMapping(value = "/order/{orderId}")
    public Map<String,Object> getById(@PathVariable("orderId") Integer orderId) {
        Map<String,Object> result = myOrder.getMyOrder(orderId);
        System.out.println("订单服务port="+serverPort +"上查询id="+orderId+"的订单信息：" + result);
        return result;
    }

    @GetMapping("saveOrder")
    // blockHandler: 负责处理 违背sentinel 中规则时候，执行兜底方法  QPS : 2
    // fallback :   负责处理 业务中出现异常时候，执行兜底方法
    @SentinelResource(value = "saveOrderHotKey",blockHandler = "handlerHotKey",fallback = "hanlderFallback")
    public String saveOrder(@RequestParam("custId") Integer custId,  @RequestParam("productId") Integer productId){
        System.out.println("下订单 custId:" + custId +",productId:" + productId  );
        int a = 10/0;
        return "saveOrder";
    }
    // 兜底方法 blockHandler:
    public  String handlerHotKey(Integer custId , Integer productId, BlockException exception){
        return "blockHandler:当前系统正忙，请稍后再试 ";
    }
    //兜底方法 fallback
    public String hanlderFallback(Integer custId,Integer productId){
        return "fallback:系统异常，稍后再试";
    }


}
