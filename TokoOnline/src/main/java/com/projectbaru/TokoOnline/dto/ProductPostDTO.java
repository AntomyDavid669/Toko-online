package com.projectbaru.TokoOnline.dto;

public class ProductPostDTO {
    private Long id;
    private String product_name;
    private Double harga;
    private String deskripsi;
    private Long stok_quantity;
    private Long category_id;
    private String gambar_path;

    public String getGambar_path() {
        return this.gambar_path;
    }

    public void setGambar_path(String gambar_path) {
        this.gambar_path = gambar_path;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getHarga() {
        return this.harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return this.deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Long getStok_quantity() {
        return this.stok_quantity;
    }

    public void setStok_quantity(Long stok_quantity) {
        this.stok_quantity = stok_quantity;
    }

    public Long getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }




    
}
