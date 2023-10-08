package com.example.Amazon.AmazonClone.repositories;

import com.example.Amazon.AmazonClone.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
}
