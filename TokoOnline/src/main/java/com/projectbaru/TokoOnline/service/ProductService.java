package com.projectbaru.TokoOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectbaru.TokoOnline.dto.ProductInterfaceDTO;
import com.projectbaru.TokoOnline.dto.ProductPostDTO;
import com.projectbaru.TokoOnline.entity.ProductEntity;
import com.projectbaru.TokoOnline.repository.ProductRepository;
import com.projectbaru.TokoOnline.utils.CustomException;

@Service
public class ProductService {
    @Autowired private ProductRepository pr;

    public List<ProductInterfaceDTO> getAllProduct(){
        return pr.getAllProduct();
    }

    // Insert Product
    public void insertProduct(ProductPostDTO product) throws CustomException {
        // Cek product name
        if (pr.isNameExsist(product.getProduct_name())) {
            throw new CustomException(452, "Product name already exists");
        }

        ProductEntity productEntity = new ProductEntity();
        productEntity.setProduct_name(product.getProduct_name());
        productEntity.setHarga(product.getHarga());
        productEntity.setDeskripsi(product.getDeskripsi());
        productEntity.setStok_quantity(product.getStok_quantity());        
        productEntity.setCategory_id(product.getCategory_id());

        pr.save(productEntity);
    }

    // Update Product
    public void updateProduct(ProductPostDTO product) throws CustomException {
        ProductEntity productEntity = pr.getReferenceById(product.getId());

        // Cek product name
        if (pr.isNameExsistUpdate(product.getProduct_name(), productEntity.getProduct_name())) {
            throw new CustomException(452, "Product name already exists");
        }

        if (pr.isNameExsist(product.getProduct_name())) {
            throw new CustomException(452, "Product name already exists");
        }

        productEntity.setProduct_id(product.getId());
        productEntity.setProduct_name(product.getProduct_name());
        productEntity.setHarga(product.getHarga());
        productEntity.setDeskripsi(product.getDeskripsi());
        productEntity.setStok_quantity(product.getStok_quantity());        
        productEntity.setCategory_id(product.getCategory_id());

        pr.save(productEntity);
    }

    // Soft Delete product
    public void deleteProduct(ProductPostDTO product){
        ProductEntity productEntity = pr.getReferenceById(product.getId());

        productEntity.setIs_delete(true);

        pr.save(productEntity);
    }
}
