package com.chixing.service;

import com.chixing.entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "eshop-customer-server")
public interface CustomerClient {
    @GetMapping(value = "customer/{custId}")
    Map getById(@PathVariable("custId")Integer id);
}
