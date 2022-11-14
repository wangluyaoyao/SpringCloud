package com.chixing.controller;


import com.chixing.entity.Customer;
import com.chixing.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

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
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Value("{server.port}")
    private String serverPort;

    @GetMapping("/customer/{custId}")
    public Map<String,Object> getById(@PathVariable("custId")Integer custId){
        System.out.println("用户正在访问id:"+custId);
        return customerService.selectById(custId);
    }
}
