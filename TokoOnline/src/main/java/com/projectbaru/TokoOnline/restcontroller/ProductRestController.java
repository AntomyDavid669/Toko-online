package com.projectbaru.TokoOnline.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectbaru.TokoOnline.dto.ProductInterfaceDTO;
import com.projectbaru.TokoOnline.dto.ProductPostDTO;
import com.projectbaru.TokoOnline.service.ProductService;
import com.projectbaru.TokoOnline.utils.CustomException;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    @Autowired ProductService ps;

    @GetMapping("/product")
    public List<ProductInterfaceDTO> getAllProduct(){
        return ps.getAllProduct();
    }

    @PostMapping("/product")
    public String insertProduct(@RequestBody ProductPostDTO productPostDTO){
        try {
            ps.insertProduct(productPostDTO);
            String response = "Product Added successfully";
            return response;
        } catch (CustomException e) {
            String response = e.getMessage();
            return response;
        }
    }

    @PutMapping("/product")
    public String updateProduct(@RequestBody ProductPostDTO productPostDTO){
        try {
            ps.updateProduct(productPostDTO);
            String response = "Product Updated successfully";
            return response;
        } catch (CustomException e) {
            String response = e.getMessage();
            return response;
        }
    }

    @DeleteMapping("/product")
    public String deleteProduct(@RequestBody ProductPostDTO productPostDTO){
        ps.deleteProduct(productPostDTO);
        String response = "Product Deleted successfully";
        return response;
    }
}
