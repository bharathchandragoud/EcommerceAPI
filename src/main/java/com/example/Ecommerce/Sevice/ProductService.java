package com.example.Ecommerce.Sevice;

import com.example.Ecommerce.Repo.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(new Product(1,"Bharath",100),new Product(2,"Bhavya",99),new Product(3,"Bunny",98),new Product(4,"New",97));

    public List<Product> getProducts(){
        System.out.println("came into service");
        return products;
    }

    public Product getProductById(int pId) {
        return  products.stream().filter(p->p.getId() == pId).findFirst().get();
    }
}
