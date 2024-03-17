package com.projectbaru.TokoOnline.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "detail_pesanan")
public class DetailPesananEntity extends BaseProperties{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column private Long order_detail_id;
    @Column private Long order_id;
    @Column private Long product_id;
    @Column private Double quantity;
    @Column private Double subtotal;



    public Long getOrder_detail_id() {
        return this.order_detail_id;
    }

    public void setOrder_detail_id(Long order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public Long getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    

}
