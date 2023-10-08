package com.example.Amazon.AmazonClone.repositories;

import com.example.Amazon.AmazonClone.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Integer> {
}
