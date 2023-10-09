package com.example.Amazon.AmazonClone.controllers;

import com.example.Amazon.AmazonClone.model.PersonDTO;
import com.example.Amazon.AmazonClone.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/person",produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE})
@Slf4j
@RestController
public class PersonController {
    @Autowired
    public PersonService personService;

    @PostMapping("/savePerson")
    public ResponseEntity<Response> savePerson(@RequestBody PersonDTO p){
        boolean isSaved = personService.savePersonDetails(p);
        Response response = new Response();
        if(isSaved) {
            response.setStatus(200);
            response.setMessage("PersonDTO saved successfully");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("isPersonSaved", "true")
                    .body(response);
        }
        response.setStatus(404);
        response.setMessage("Incorrect or Duplicate Entry Recieved");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header("isPersonSaved", "false")
                .body(response);
    }

    @PostMapping("/updatePerson")
    public ResponseEntity<Response> updatePersonByUsername(@RequestBody PersonDTO p){
        boolean isUpdated = personService.updatePersonDetails(p);
        Response response = new Response();
        if(isUpdated) {
            response.setStatus(210);
            response.setMessage("Updation was successful");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("isUpdated", "true")
                    .body(response);
        }
        response.setStatus(404);
        response.setMessage("EmailId is Incorrect");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header("isError", "true")
                .body(response);
    }

    @GetMapping("getPersonByEmail")
    public PersonDTO getPersonByEmail(@RequestHeader(name = "email") String email){
        return personService.getPersonDetailsByEmail(email);
    }

    @GetMapping("/getAllPersons")
    public List<PersonDTO> getAllPerson(){
        List<PersonDTO> res = personService.getAllPersonDetails();
        return (res);
    }
}
