package com.example.Amazon.AmazonClone.Repositories;

import com.example.Amazon.AmazonClone.Model.Games;
import com.example.Amazon.AmazonClone.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Games,Integer> {

    public Games findByName(String name);
}
