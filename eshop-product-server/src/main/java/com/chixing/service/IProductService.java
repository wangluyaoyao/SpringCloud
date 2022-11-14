package com.chixing.service;

import com.chixing.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chixing.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wang
 * @since 2022-10-14
 */

public interface IProductService extends IService<Product> {



    Product selectById(Integer productId);
    List<Product> selectAll();
}
