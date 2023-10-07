package com.example.Amazon.AmazonClone.Repositories;

import com.example.Amazon.AmazonClone.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {


}
