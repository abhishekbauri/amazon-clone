package com.example.Amazon.AmazonClone.objectMapper;

import com.example.Amazon.AmazonClone.entity.ProductEntity;
import com.example.Amazon.AmazonClone.model.ProductDTO;

public class ProductMapper {

    public static ProductDTO entityToDTO(ProductEntity productEntity) {
        if(productEntity == null) return null;

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productEntity.getProductId());
        productDTO.setTitle(productEntity.getTitle());
        productDTO.setBrand(productEntity.getBrand());
        productDTO.setModelName(productEntity.getModelName());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setAmount(productEntity.getAmount());
        productDTO.setUrl(productEntity.getUrl());
        productDTO.setRating(productEntity.getRating());
        productDTO.setReturnable(productEntity.getReturnable());
        productDTO.setCategory(CategoryMapper.entityToDTO(productEntity.getCategoryEntity()));
        productDTO.setCreatedAt(productEntity.getCreatedAt());
        productDTO.setCreatedBy(productEntity.getCreatedBy());
        productDTO.setUpdatedAt(productEntity.getUpdatedAt());
        productDTO.setUpdatedBy(productEntity.getUpdatedBy());
        return productDTO;
    }

    public static ProductEntity dtoToEntity(ProductDTO productDTO) {
        if(productDTO == null) return null;

        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productDTO.getProductId());
        productEntity.setTitle(productDTO.getTitle());
        productEntity.setBrand(productDTO.getBrand());
        productEntity.setModelName(productDTO.getModelName());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setAmount(productDTO.getAmount());
        productEntity.setUrl(productDTO.getUrl());
        productEntity.setRating(productDTO.getRating());
        productEntity.setReturnable(productDTO.getReturnable());
        productEntity.setCategoryEntity(CategoryMapper.dtoToEntity(productDTO.getCategory()));
        productEntity.setCreatedAt(productDTO.getCreatedAt());
        productEntity.setCreatedBy(productDTO.getCreatedBy());
        productEntity.setUpdatedAt(productDTO.getUpdatedAt());
        productEntity.setUpdatedBy(productDTO.getUpdatedBy());
        return productEntity;
    }
}
