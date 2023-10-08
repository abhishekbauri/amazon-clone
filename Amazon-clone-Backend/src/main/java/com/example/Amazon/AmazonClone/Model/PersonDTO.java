package com.example.Amazon.AmazonClone.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class PersonDTO {
    private int personId;

    private String username;

    private String emailId;

    private String password;

    private RoleDTO role;

    private AddressDTO address;

    private GamesDTO games;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}
