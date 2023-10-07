package com.example.Amazon.AmazonClone.Repositories;

import com.example.Amazon.AmazonClone.Entity.GamesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GamesEntity,Integer> {

    public GamesEntity findByName(String name);
}
