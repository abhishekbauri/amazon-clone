package com.example.Amazon.AmazonClone.Services;


import com.example.Amazon.AmazonClone.Model.Person;
import com.example.Amazon.AmazonClone.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public boolean savePersonDetails(Person p){
        Person obj = personRepository.findByEmailId(p.getEmailId());
        if(obj != null && obj.getPersonId() > 0) return (false);
        personRepository.save(p);
        return (true);
    }

    public boolean updatePersonDetails(Person p) {
        Person obj = personRepository.findByEmailId(p.getEmailId());
        if(obj != null && obj.getPersonId() > 0){
            if(p.getUsername() != null) obj.setUsername(p.getUsername());
            if(p.getPassword() != null) obj.setPassword(p.getPassword());
            if(p.getRole() != null) obj.setRole(p.getRole());
            if(p.getAddress() != null) obj.setAddress(p.getAddress());
            personRepository.save(obj);
            return (true);
        }
        return (false);
    }

    public Person getPersonDetailsByEmail(String email){
        return personRepository.findByEmailId(email);
    }

    public List<Person> getAllPersonDetails(){
        return personRepository.findAll();
    }
}
