package com.example.Ecommerce.controller;

import com.example.Ecommerce.Repo.Product;
import com.example.Ecommerce.Sevice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService ps;

    @RequestMapping("/products")
    public List<Product> getProducts(){
        System.out.println("came into controller");
        return  ps.getProducts();
    }

    @RequestMapping("/products/{id}")
    public Product getProductById(@PathVariable int id){
        System.out.println("came into controller");
        return  ps.getProductById(id);
    }
}
