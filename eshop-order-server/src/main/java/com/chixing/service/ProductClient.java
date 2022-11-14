package com.chixing.service;

import com.chixing.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
@Service
@FeignClient(name = "eshop-product-server")
public interface ProductClient {
    @GetMapping(value = "product/{proId}")
    Map getById(@PathVariable("proId")Integer id);
}
