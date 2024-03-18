package com.projectbaru.TokoOnline.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public void insertProduct(ProductPostDTO product, MultipartFile file ) throws CustomException, IOException {
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

        String path = new FileSystemResource("").getFile().getAbsolutePath();
        path += "\\uploads\\";

        String fileName = product.getProduct_name() + ".jpg";
        Path newPath = Paths.get(path+fileName);

        Files.copy(file.getInputStream(), newPath, StandardCopyOption.REPLACE_EXISTING);

        String hasilUpload = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(fileName).toUriString();

        productEntity.setGambar_path(hasilUpload);
        
        pr.save(productEntity);
    }

    // Update Product
    public void updateProduct(ProductPostDTO product, MultipartFile file) throws CustomException, IOException {
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

        String path = new FileSystemResource("").getFile().getAbsolutePath();
        path += "\\uploads\\";

        String fileName = product.getProduct_name() + ".jpg";
        Path newPath = Paths.get(path + fileName);

        Files.copy(file.getInputStream(), newPath, StandardCopyOption.REPLACE_EXISTING);

        String hasilUpload = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(fileName).toUriString();

        productEntity.setGambar_path(hasilUpload);

        pr.save(productEntity);
    }

    // Soft Delete product
    public void deleteProduct(ProductPostDTO product){
        ProductEntity productEntity = pr.getReferenceById(product.getId());

        productEntity.setIs_delete(true);

        pr.save(productEntity);
    }
}
