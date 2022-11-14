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

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cust_id", type = IdType.AUTO)
    private Integer custId;

    private String custName;

    private Integer custTelno;

    private String custEmail;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
    public Integer getCustTelno() {
        return custTelno;
    }

    public void setCustTelno(Integer custTelno) {
        this.custTelno = custTelno;
    }
    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "custId=" + custId +
            ", custName=" + custName +
            ", custTelno=" + custTelno +
            ", custEmail=" + custEmail +
        "}";
    }
}
