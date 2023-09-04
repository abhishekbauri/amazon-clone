package com.example.Amazon.AmazonClone.Repositories;

import com.example.Amazon.AmazonClone.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {


}
