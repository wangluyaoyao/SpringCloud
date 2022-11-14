package com.chixing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chixing.entity.Customer;
import com.chixing.mapper.CustomerMapper;
import com.chixing.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wang
 * @since 2022-10-14
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Map<String,Object> selectById(Integer custId) {
        Map<String,Object> result = new HashMap<>();
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("cust_id","cust_name");
        queryWrapper.eq("cust_id",custId);

        Customer customer = customerMapper.selectOne(queryWrapper);
        result.put("custId",customer.getCustId());
        result.put("custName",customer.getCustName());

        return result;
    }
}
