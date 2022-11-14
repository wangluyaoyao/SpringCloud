package com.chixing.service;



import com.chixing.entity.Myorder;

import java.util.Map;

public interface MyOrder {
    Map<String,Object> getMyOrder(Integer orderId);
    public boolean save(Myorder order);
}
