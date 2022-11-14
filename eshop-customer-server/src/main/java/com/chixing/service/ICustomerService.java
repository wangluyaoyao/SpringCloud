package com.chixing.service;

import com.chixing.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wang
 * @since 2022-10-14
 */
public interface ICustomerService extends IService<Customer> {

    Map<String,Object> selectById(Integer custId);
}
