package com.example.Amazon.AmazonClone.Controllers;

import com.example.Amazon.AmazonClone.Model.Person;
import com.example.Amazon.AmazonClone.Services.PersonService;
import jakarta.websocket.server.PathParam;
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
    public ResponseEntity<Response> savePerson(@RequestBody Person p){
        boolean isSaved = personService.savePersonDetails(p);
        Response response = new Response();
        if(isSaved) {
            response.setStatus(200);
            response.setMessage("Person saved successfully");
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
    public ResponseEntity<Response> updatePersonByUsername(@RequestBody Person p){
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
    public Person getPersonByEmail(@RequestHeader(name = "email") String email){
        return personService.getPersonDetailsByEmail(email);
    }

    @GetMapping("/getAllPersons")
    public List<Person> getAllPerson(){
        List<Person> res = personService.getAllPersonDetails();
        return (res);
    }
}
