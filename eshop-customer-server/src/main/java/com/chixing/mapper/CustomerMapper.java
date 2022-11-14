package com.chixing.mapper;

import com.chixing.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wang
 * @since 2022-10-14
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

//    @Select("select * from customer where ")
//    String selectById();
}
