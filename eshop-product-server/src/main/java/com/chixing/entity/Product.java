package com.chixing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author wang
 * @since 2022-10-14
 */

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pro_id", type = IdType.AUTO)
    private Integer proId;

    private String proName;

    private Float proPrice;


    private String proDesc;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
    public Float getProPrice() {
        return proPrice;
    }

    public void setProPrice(Float proPrice) {
        this.proPrice = proPrice;
    }
    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    @Override
    public String toString() {
        return "Product{" +
            "proId=" + proId +
            ", proName=" + proName +
            ", proPrice=" + proPrice +
            ", proDesc=" + proDesc +
        "}";
    }
}
