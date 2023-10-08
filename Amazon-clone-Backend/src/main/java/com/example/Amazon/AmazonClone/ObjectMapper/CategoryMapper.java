package com.example.Amazon.AmazonClone.objectMapper;

import com.example.Amazon.AmazonClone.entity.CategoryEntity;
import com.example.Amazon.AmazonClone.model.CategoryDTO;

public class CategoryMapper {

    public static CategoryDTO entityToDTO(CategoryEntity categoryEntity){
        if(categoryEntity == null) return null;
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setName(categoryEntity.getName());
        categoryDTO.setCreatedAt(categoryEntity.getCreatedAt());
        categoryDTO.setCreatedBy(categoryEntity.getCreatedBy());
        categoryDTO.setUpdatedAt(categoryEntity.getUpdatedAt());
        categoryDTO.setUpdatedBy(categoryEntity.getUpdatedBy());

        return (categoryDTO);
    }


    public static CategoryEntity dtoToEntity(CategoryDTO categoryDTO){
        if(categoryDTO == null) return null;

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryDTO.getId());
        categoryEntity.setName(categoryDTO.getName());
        categoryEntity.setCreatedAt(categoryDTO.getCreatedAt());
        categoryEntity.setCreatedBy(categoryDTO.getCreatedBy());
        categoryEntity.setUpdatedAt(categoryDTO.getUpdatedAt());
        categoryEntity.setUpdatedBy(categoryDTO.getUpdatedBy());

        return (categoryEntity);
    }
}
