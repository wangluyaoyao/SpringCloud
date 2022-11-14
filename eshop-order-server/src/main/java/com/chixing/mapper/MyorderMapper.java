package com.chixing.mapper;

import com.chixing.entity.Myorder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

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
@Component
public interface MyorderMapper extends BaseMapper<Myorder> {
}
