package com.projectbaru.TokoOnline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projectbaru.TokoOnline.dto.CategoryInterfaceDTO;
import com.projectbaru.TokoOnline.entity.KategoriEntity;

public interface CategoryRepository extends JpaRepository<KategoriEntity, Long>{
    @Query(nativeQuery = true, value = "SELECT category_id AS id, category_name from kategori WHERE is_delete = FALSE")
    List<CategoryInterfaceDTO> getAllCategory();

    // Logic Insert
    // Cek category_name is exsist
    @Query(nativeQuery = true, value = "select exists (select * from kategori where category_name iLIKE :category_name  AND is_delete = false)")
    public Boolean isNameExsist(@Param("category_name") String category_name);

    // Logic Update
    // Cek category_name is exsist and same
    @Query(nativeQuery = true, value = "select exists (select * from kategori where category_name iLIKE :category_name AND category_name iLIKE :oldcategory_name AND is_delete = false)")
    public Boolean isNameExsistUpdate(@Param("category_name") String category_name, @Param("oldcategory_name") String oldcategory_name);

}
