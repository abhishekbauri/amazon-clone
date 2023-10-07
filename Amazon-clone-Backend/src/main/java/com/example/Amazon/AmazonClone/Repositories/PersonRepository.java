package com.example.Amazon.AmazonClone.Repositories;

import com.example.Amazon.AmazonClone.Entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {
    PersonEntity findByEmailId(String email);
}

