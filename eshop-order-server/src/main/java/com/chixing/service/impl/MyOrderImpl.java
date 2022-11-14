package com.chixing.service.impl;

import com.chixing.entity.Customer;
import com.chixing.entity.Myorder;
import com.chixing.entity.Product;
import com.chixing.mapper.MyorderMapper;
import com.chixing.service.CustomerClient;
import com.chixing.service.IMyorderService;
import com.chixing.service.MyOrder;
import com.chixing.service.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MyOrderImpl implements MyOrder {
    @Autowired
    private MyorderMapper myorderMapper;

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private ProductClient productClient;


    @Override
    public boolean save(Myorder order) {
        int rows = myorderMapper.insert(order);
        if (rows > 0){
            System.out.println("订单添加成功");
            return true;
        }else {
            System.out.println("订单添加失败");
            return false;
        }

    }
    @Override
    public Map<String, Object> getMyOrder(Integer orderId) {
        Map<String,Object> map = new HashMap<>();

        Myorder myorder = myorderMapper.selectById(orderId);
        Map customer = customerClient.getById(myorder.getCustId());
        Map product = productClient.getById(myorder.getProId());

        map.put("myorder",myorder);
        map.putAll(customer);
        map.putAll(product);

        return map;
    }
}
