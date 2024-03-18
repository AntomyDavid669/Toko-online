package com.projectbaru.TokoOnline.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseProperties{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column private Long product_id;
    @Column private String product_name;
    @Column private String deskripsi;
    @Column private Double harga;
    @Column private Long category_id;
    @Column private Long stok_quantity;
    @Column private String gambar_path;
    

    public Long getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDeskripsi() {
        return this.deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Double getHarga() {
        return this.harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Long getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getStok_quantity() {
        return this.stok_quantity;
    }

    public void setStok_quantity(Long stok_quantity) {
        this.stok_quantity = stok_quantity;
    }

    public String getGambar_path() {
        return this.gambar_path;
    }

    public void setGambar_path(String gambar_path) {
        this.gambar_path = gambar_path;
    }

}
