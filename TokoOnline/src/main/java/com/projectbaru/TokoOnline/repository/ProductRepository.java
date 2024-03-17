package com.projectbaru.TokoOnline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projectbaru.TokoOnline.dto.ProductInterfaceDTO;
import com.projectbaru.TokoOnline.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    
    // Get All Products with Category Name
    @Query(nativeQuery = true, value = "SELECT product.product_id AS id,product.product_name,product.harga,product.deskripsi,product.stok_quantity,kategori.category_name AS kategori, kategori.category_id FROM product, kategori WHERE kategori.category_id = product.category_id AND product.is_delete = false ORDER BY id")
    List<ProductInterfaceDTO> getAllProduct();

    // Logic Insert
    // Cek product_name is exsist
    @Query(nativeQuery = true, value = "select exists (select * from product where product_name iLIKE :product_name AND is_delete = false)")
    public Boolean isNameExsist(@Param("product_name") String product_name);

    // Logic Update
    // Cek product_name is exsist and same
    @Query(nativeQuery = true, value = "select exists (select * from product where product_name iLIKE :product_name AND product_name iLIKE :oldProduct_name AND is_delete = false)")
    public Boolean isNameExsistUpdate(@Param("product_name") String product_name, @Param("oldProduct_name") String oldProduct_name);

}
