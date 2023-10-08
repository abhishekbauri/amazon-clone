package com.example.Amazon.AmazonClone.objectMapper;

import com.example.Amazon.AmazonClone.entity.PersonEntity;
import com.example.Amazon.AmazonClone.model.PersonDTO;

public class PersonMapper {

    public static PersonDTO entityToDto(PersonEntity personEntity) {
        if(personEntity == null) return null;

        PersonDTO personDTO = new PersonDTO();
        personDTO.setPersonId(personEntity.getPersonId());
        personDTO.setUsername(personEntity.getUsername());
        personDTO.setEmailId(personEntity.getEmailId());
        personDTO.setPassword(personEntity.getPassword());
        personDTO.setRole(RoleMapper.entityToDto(personEntity.getRoleEntity()));
        personDTO.setAddress(AddressMapper.entityToDto(personEntity.getAddressEntity()));
        personDTO.setGames(GamesMapper.entityToDto(personEntity.getGamesEntity()));
        personDTO.setCreatedAt(personEntity.getCreatedAt());
        personDTO.setCreatedBy(personEntity.getCreatedBy());
        personDTO.setUpdatedAt(personEntity.getUpdatedAt());
        personDTO.setUpdatedBy(personEntity.getUpdatedBy());
        return personDTO;
    }

    public static PersonEntity dtoToEntity(PersonDTO personDTO) {
        if(personDTO == null) return null;

        PersonEntity personEntity = new PersonEntity();
        personEntity.setPersonId(personDTO.getPersonId());
        personEntity.setUsername(personDTO.getUsername());
        personEntity.setEmailId(personDTO.getEmailId());
        personEntity.setPassword(personDTO.getPassword());
        personEntity.setRoleEntity(RoleMapper.dtoToEntity(personDTO.getRole()));
        personEntity.setAddressEntity(AddressMapper.dtoToEntity(personDTO.getAddress()));
        personEntity.setGamesEntity(GamesMapper.dtoToEntity(personDTO.getGames()));
        personEntity.setCreatedAt(personDTO.getCreatedAt());
        personEntity.setCreatedBy(personDTO.getCreatedBy());
        personEntity.setUpdatedAt(personDTO.getUpdatedAt());
        personEntity.setUpdatedBy(personDTO.getUpdatedBy());
        return personEntity;
    }
}
