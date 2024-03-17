package com.projectbaru.TokoOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectbaru.TokoOnline.dto.CategoryInterfaceDTO;
import com.projectbaru.TokoOnline.dto.CategoryPostDTO;
import com.projectbaru.TokoOnline.entity.KategoriEntity;
import com.projectbaru.TokoOnline.repository.CategoryRepository;
import com.projectbaru.TokoOnline.utils.CustomException;

@Service
public class CategoryService {
    @Autowired CategoryRepository cr;
    
    public List<CategoryInterfaceDTO> getAllCategory(){
        return cr.getAllCategory();
    }

    // Insert Product
    public void insertCategory(CategoryPostDTO category) throws CustomException {
        // Cek product name
        if (cr.isNameExsist(category.getCategory_name())) {
            throw new CustomException(452, "Category name already exists");
        }

        KategoriEntity kategoriEntity = new KategoriEntity();
        kategoriEntity.setCategory_name(category.getCategory_name());


        cr.save(kategoriEntity);
    }

    // Update Product
    public void updateCategory(CategoryPostDTO category) throws CustomException {
        KategoriEntity kategoriEntity = cr.getReferenceById(category.getId());

        // Cek product name
        if (cr.isNameExsistUpdate(category.getCategory_name(), kategoriEntity.getCategory_name())) {
            throw new CustomException(452, "Category name already exists");
        }

        if (cr.isNameExsist(category.getCategory_name())) {
            throw new CustomException(452, "Category name already exists");
        }

        kategoriEntity.setCategory_id(category.getId());
        kategoriEntity.setCategory_name(category.getCategory_name());


        cr.save(kategoriEntity);
    }

    // Soft Delete product
    public void deleteCategory(CategoryPostDTO category){
        KategoriEntity kategoriEntity = cr.getReferenceById(category.getId());

        kategoriEntity.setIs_delete(true);

        cr.save(kategoriEntity);
    }

}
