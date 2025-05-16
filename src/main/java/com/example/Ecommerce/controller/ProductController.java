package com.example.Ecommerce.controller;

import com.example.Ecommerce.entity.ProductEntity;
import com.example.Ecommerce.modal.Product;
import com.example.Ecommerce.sevice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService ps;

    @RequestMapping("/products")
    public List<ProductEntity> getProducts(){
        System.out.println("came into controller");
        return  ps.getProducts();
    }

    @RequestMapping("/products/{id}")
    public ProductEntity getProductById(@PathVariable int id){
        System.out.println("came into controller");
        return ps.getProductById(id);
    }

    @PostMapping("/products")
    public ProductEntity saveProduct(@RequestBody ProductEntity prod){
        return ps.createProduct(prod);
    }

    @PutMapping("/products/{id}")
    public  ProductEntity updateProduct(@RequestBody ProductEntity prod,@PathVariable int id){
        return  ps.updateProduct(prod,id);

    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        ps.deleteProduct(id);
    }
}
