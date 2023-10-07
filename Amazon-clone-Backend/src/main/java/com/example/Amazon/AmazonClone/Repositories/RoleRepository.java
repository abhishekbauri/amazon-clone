package com.example.Amazon.AmazonClone.Repositories;

import com.example.Amazon.AmazonClone.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
}
