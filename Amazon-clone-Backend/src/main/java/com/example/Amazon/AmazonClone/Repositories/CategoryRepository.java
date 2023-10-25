package com.example.Amazon.AmazonClone.repositories;

import com.example.Amazon.AmazonClone.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {


}
