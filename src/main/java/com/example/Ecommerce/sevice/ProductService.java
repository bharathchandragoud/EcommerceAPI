package com.example.Ecommerce.sevice;

import com.example.Ecommerce.entity.ProductEntity;
import com.example.Ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo prodRepo;

    public List<ProductEntity> getProducts(){
        System.out.println("came into service");
       return prodRepo.findAll();
    }

    public ProductEntity getProductById(int pId) {
        return  prodRepo.findById(pId).orElse(null);
    }

    public ProductEntity updateProduct(ProductEntity prod,int id){
        return prodRepo.findById(id).map(p->{
            p.setName(prod.getName());
            p.setPrice(prod.getPrice());
            return prodRepo.save(p);
        }).orElseThrow(()-> new RuntimeException("Product is not found"));
    }

    public ProductEntity createProduct(ProductEntity prod){
        return  prodRepo.save(prod);
    }

    public void deleteProduct(int pId){
         prodRepo.deleteById(pId);
    }
}
