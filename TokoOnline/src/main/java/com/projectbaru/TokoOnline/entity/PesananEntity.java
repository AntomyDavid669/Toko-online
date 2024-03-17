package com.projectbaru.TokoOnline.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pesanan")
public class PesananEntity extends BaseProperties{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column private Long order_id;
    @Column private Long user_id;
    @Column private Date order_date;
    @Column private Double total_amount;
    

    public Long getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Date getOrder_date() {
        return this.order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Double getTotal_amount() {
        return this.total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }
    
}
