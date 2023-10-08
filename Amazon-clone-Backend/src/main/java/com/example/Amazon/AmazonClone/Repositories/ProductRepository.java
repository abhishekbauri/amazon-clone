package com.example.Amazon.AmazonClone.repositories;

import com.example.Amazon.AmazonClone.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

    ProductEntity findByTitle(String title);

    ProductEntity findByProductId(Integer id);

    // writing query based on named parameters
    @Query("select p from ProductEntity p where p.categoryEntity.name = :category")
    List<ProductEntity> getProductsBasedOnCategory(@Param("category") String categoryName);
}

