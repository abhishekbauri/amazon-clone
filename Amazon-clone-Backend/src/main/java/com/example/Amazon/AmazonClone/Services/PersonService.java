package com.example.Amazon.AmazonClone.Services;


import com.example.Amazon.AmazonClone.Entity.PersonEntity;
import com.example.Amazon.AmazonClone.Model.PersonDTO;
import com.example.Amazon.AmazonClone.ObjectMapper.PersonMapper;
import com.example.Amazon.AmazonClone.Repositories.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public boolean savePersonDetails(PersonDTO p){
        PersonEntity obj = personRepository.findByEmailId(p.getEmailId());
        if(obj != null && obj.getPersonId() > 0) return (false);

        PersonEntity personEntity = PersonMapper.dtoToEntity(p);
//        BeanUtils.copyProperties(p, personEntity);
        personRepository.save(personEntity);
        return (true);
    }

    public boolean updatePersonDetails(PersonDTO p) {
        PersonEntity obj = personRepository.findByEmailId(p.getEmailId());

        PersonEntity personEntity = PersonMapper.dtoToEntity(p);;
//        BeanUtils.copyProperties(p, personEntity);

        if(obj != null && obj.getPersonId() > 0){
            if(personEntity.getUsername() != null) obj.setUsername(personEntity.getUsername());
            if(personEntity.getPassword() != null) obj.setPassword(personEntity.getPassword());
            if(personEntity.getRoleEntity() != null) obj.setRoleEntity(personEntity.getRoleEntity());
            if(personEntity.getAddressEntity() != null) obj.setAddressEntity(personEntity.getAddressEntity());
            personRepository.save(obj);
            return (true);
        }
        return (false);
    }

    public PersonDTO getPersonDetailsByEmail(String email){
        PersonEntity personEntity = personRepository.findByEmailId(email);

        PersonDTO personDTO = PersonMapper.entityToDto(personEntity);
//        BeanUtils.copyProperties(personEntity, personDTO);
        return (personDTO);
    }

    public List<PersonDTO> getAllPersonDetails(){
        List<PersonEntity> personEntities = personRepository.findAll();
        System.out.println("Person Entities : ");

        List<PersonDTO> personDTOS = new ArrayList<>();
        personEntities.forEach(personEntity -> {
            System.out.print(personEntity+", ");
            PersonDTO personDTO = PersonMapper.entityToDto(personEntity);
//            BeanUtils.copyProperties(personEntity, personDTO);
            personDTOS.add(personDTO);

        });
        System.out.println();
        System.out.println("Person DTOs : " + personDTOS);

        return (personDTOS);
    }


}
