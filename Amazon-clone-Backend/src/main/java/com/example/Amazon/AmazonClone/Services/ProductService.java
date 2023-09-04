package com.example.Amazon.AmazonClone.Services;

import com.example.Amazon.AmazonClone.Model.Product;
import com.example.Amazon.AmazonClone.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product saveProductDetails(Product p){
        return productRepository.save(p);
    }

    public List<Product> getAllProductsDetails(){
        return productRepository.findAll();
    }
}
