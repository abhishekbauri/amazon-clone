package com.example.Amazon.AmazonClone.services;

import com.example.Amazon.AmazonClone.entity.ProductEntity;
import com.example.Amazon.AmazonClone.model.ProductDTO;
import com.example.Amazon.AmazonClone.objectMapper.ProductMapper;
import com.example.Amazon.AmazonClone.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Boolean saveProductDetails(ProductDTO p){

        ProductEntity productEntity = ProductMapper.dtoToEntity(p);
//        BeanUtils.copyProperties(p, productEntity);

        ProductEntity obj = productRepository.findByTitle(productEntity.getTitle());
        if(obj != null && obj.getProductId() > 0){
            return (false);
        }

        System.out.println(obj);
        productRepository.save(productEntity);
        return (true);
    }

    public boolean updateProductDetails(ProductDTO productDTO){
        boolean isSaved = false;
        ProductEntity productEntity = ProductMapper.dtoToEntity(productDTO);
        ProductEntity savedProduct = productRepository.findByProductId(productEntity.getProductId());

        if(savedProduct != null && savedProduct.getProductId() > 0){
            isSaved = true;

            if(productEntity.getTitle() != null) savedProduct.setTitle(productEntity.getTitle());
            if(productEntity.getBrand() != null) savedProduct.setBrand(productEntity.getBrand());
            if(productEntity.getAmount() != null) savedProduct.setAmount(productEntity.getAmount());
            if(productEntity.getDescription() != null) savedProduct.setDescription(productEntity.getDescription());
            if(productEntity.getRating() != null) savedProduct.setRating(productEntity.getRating());
            if(productEntity.getCategoryEntity() != null) savedProduct.setCategoryEntity(productEntity.getCategoryEntity());
            if(productEntity.getReturnable() != null) savedProduct.setReturnable(productEntity.getReturnable());
            if(productEntity.getUrl() != null) savedProduct.setUrl(productEntity.getUrl());
            if(productEntity.getModelName() != null) savedProduct.setModelName(productEntity.getModelName());
            if(productEntity.getCreatedAt() != null) savedProduct.setCreatedAt(productEntity.getCreatedAt());
            if(productEntity.getCreatedBy() != null) savedProduct.setCreatedBy(productEntity.getCreatedBy());

            productRepository.save(savedProduct);

        }
        return (isSaved);
    }

    public List<ProductDTO> getProductsDetailsBasedOnCategory(String category){
        List<ProductEntity> productEntities = productRepository.getProductsBasedOnCategory(category);

        List<ProductDTO> productDTOS = new ArrayList<>();
        productEntities.forEach(productEntity -> {
            ProductDTO productDTO = ProductMapper.entityToDTO(productEntity);
//            BeanUtils.copyProperties(productEntity, productDTO);
            productDTOS.add(productDTO);

        });

        return (productDTOS);
    }

    public List<ProductDTO> getAllProductsDetails(){
        List<ProductEntity> productEntities = productRepository.findAll();

        List<ProductDTO> productDTOS = new ArrayList<>();
        productEntities.forEach(productEntity -> {
            ProductDTO productDTO = ProductMapper.entityToDTO(productEntity);
//            BeanUtils.copyProperties(productEntity, productDTO);
            productDTOS.add(productDTO);
        });

        return (productDTOS);
    }
}
