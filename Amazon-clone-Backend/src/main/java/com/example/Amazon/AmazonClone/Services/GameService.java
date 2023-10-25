package com.example.Amazon.AmazonClone.services;

import com.example.Amazon.AmazonClone.entity.GamesEntity;
import com.example.Amazon.AmazonClone.model.GamesDTO;
import com.example.Amazon.AmazonClone.objectMapper.GamesMapper;
import com.example.Amazon.AmazonClone.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public boolean saveGameDetails(GamesDTO gamesDTO){
        GamesEntity gamesEntity = GamesMapper.dtoToEntity(gamesDTO);
        GamesEntity temp = gameRepository.findByName(gamesEntity.getName());
        if(temp != null && temp.getGameId() > 0){
            return (false);
        }

        GamesEntity savedGame = gameRepository.save(gamesEntity);
        return savedGame.getGameId() > 0;
    }

    public List<GamesDTO> getAllGamesDetails(){
        List<GamesEntity> gamesEntities = gameRepository.findAll();

        List<GamesDTO> gamesDTOS = new ArrayList<>();
        gamesEntities.forEach(gamesEntity -> {
            GamesDTO gamesDTO = GamesMapper.entityToDto(gamesEntity);
            gamesDTOS.add(gamesDTO);
        });

        return (gamesDTOS);
    }




    // to be made after adding authentication in project
//    public List<GamesDTO> getAllGamesDetailsByEmail(Authentication authentication){
//
//    }
}
