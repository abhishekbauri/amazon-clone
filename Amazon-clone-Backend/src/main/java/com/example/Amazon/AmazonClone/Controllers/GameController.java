package com.example.Amazon.AmazonClone.controllers;

import com.example.Amazon.AmazonClone.model.GamesDTO;
import com.example.Amazon.AmazonClone.services.GameService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/games",produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE})
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping(path = "/saveNewGame")
    public ResponseEntity<Response> saveGame(@RequestBody GamesDTO game){
        boolean isSaved = gameService.saveGameDetails(game);
        Response response = new Response();
        if(isSaved) {
            response.setStatus(200);
            response.setMessage("Game saved successfully");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("isGameSaved", "true")
                    .body(response);
        }
        response.setStatus(404);
        response.setMessage("Incorrect or Duplicate Entry Recieved");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header("isGameSaved", "false")
                .body(response);
    }

    @GetMapping(path = "/getAllGames")
    public List<GamesDTO> getAllGames(){
        return gameService.getAllGamesDetails();
    }






    // to be made after adding authentication in project
//    @GetMapping(path = "/getAllGamesByEmail")
//    public List<GamesDTO> getAllGamesByEmail(Authentication authentication){
//        return gameService.getAllGamesDetailsByEmail(authentication);
//    }

}








