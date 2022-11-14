package com.chixing.service.impl;

import com.chixing.entity.Product;
import com.chixing.mapper.ProductMapper;
import com.chixing.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wang
 * @since 2022-10-14
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product selectById(Integer productId) {
        return productMapper.selectById(productId);
    }

    @Override
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }
}
