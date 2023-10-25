package com.example.Amazon.AmazonClone.repositories;

import com.example.Amazon.AmazonClone.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {
    PersonEntity findByEmailId(String email);
}

