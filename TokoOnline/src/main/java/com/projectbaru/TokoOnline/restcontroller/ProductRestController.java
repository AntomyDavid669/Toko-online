package com.projectbaru.TokoOnline.restcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<String> insertProduct(@RequestParam("image") MultipartFile image, ProductPostDTO productPostDTO) {
        try {
            ps.insertProduct(productPostDTO, image);
            return ResponseEntity.ok("Product Added successfully");
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/product")
    public ResponseEntity<String> updateProduct(@RequestParam("image") MultipartFile image, ProductPostDTO productPostDTO) {
        try {
            ps.updateProduct(productPostDTO, image);
            return ResponseEntity.ok("Product Updated successfully");
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/product")
    public String deleteProduct(@RequestBody ProductPostDTO productPostDTO){
        ps.deleteProduct(productPostDTO);
        String response = "Product Deleted successfully";
        return response;
    }
}
