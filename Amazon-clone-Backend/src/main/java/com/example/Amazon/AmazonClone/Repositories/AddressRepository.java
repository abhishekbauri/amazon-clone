package com.example.Amazon.AmazonClone.Repositories;

import com.example.Amazon.AmazonClone.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
