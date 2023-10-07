package com.example.Amazon.AmazonClone.Repositories;

import com.example.Amazon.AmazonClone.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

    ProductEntity findByTitle(String title);

    // writing query based on named parameters
    @Query("select p from ProductEntity p where p.categoryEntity.name = :category")
    List<ProductEntity> getProductsBasedOnCategory(@Param("category") String categoryName);
}

