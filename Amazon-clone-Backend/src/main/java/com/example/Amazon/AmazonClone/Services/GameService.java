package com.example.Amazon.AmazonClone.Services;

import com.example.Amazon.AmazonClone.Model.Games;
import com.example.Amazon.AmazonClone.Repositories.GameRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public boolean saveGameDetails(Games game){
        Games temp = gameRepository.findByName(game.getName());
        if(temp != null && temp.getGameId() > 0){
            return (false);
        }

        Games savedGame = gameRepository.save(game);
        return savedGame.getGameId() > 0;
    }

    public List<Games> getAllGamesDetails(){
        return gameRepository.findAll();
    }




    // to be made after adding authentication in project
//    public List<Games> getAllGamesDetailsByEmail(Authentication authentication){
//
//    }
}
