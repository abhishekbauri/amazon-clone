package com.example.Amazon.AmazonClone.ObjectMapper;

import com.example.Amazon.AmazonClone.Entity.GamesEntity;
import com.example.Amazon.AmazonClone.Entity.RoleEntity;
import com.example.Amazon.AmazonClone.Model.GamesDTO;
import com.example.Amazon.AmazonClone.Model.RoleDTO;

public class GamesMapper {

    public static GamesDTO entityToDto(GamesEntity gamesEntity){
        if(gamesEntity == null) return null;
        GamesDTO gamesDTO = new GamesDTO();
        gamesDTO.setGameId(gamesEntity.getGameId());
        gamesDTO.setName(gamesEntity.getName());
        gamesDTO.setStatus(gamesEntity.getStatus());
        gamesDTO.setCreatedAt(gamesEntity.getCreatedAt());
        gamesDTO.setCreatedBy(gamesEntity.getCreatedBy());
        gamesDTO.setUpdatedAt(gamesEntity.getUpdatedAt());
        gamesDTO.setUpdatedBy(gamesEntity.getUpdatedBy());

        return (gamesDTO);
    }

    public static GamesEntity dtoToEntity(GamesDTO gamesDTO){
        if(gamesDTO == null) return null;
        GamesEntity gamesEntity = new GamesEntity();
        gamesEntity.setGameId(gamesDTO.getGameId());
        gamesEntity.setName(gamesDTO.getName());
        gamesEntity.setStatus(gamesDTO.getStatus());
        gamesEntity.setCreatedAt(gamesDTO.getCreatedAt());
        gamesEntity.setCreatedBy(gamesDTO.getCreatedBy());
        gamesEntity.setUpdatedAt(gamesDTO.getUpdatedAt());
        gamesEntity.setUpdatedBy(gamesDTO.getUpdatedBy());

        return (gamesEntity);
    }
}
