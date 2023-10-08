package com.example.Amazon.AmazonClone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class AddressDTO {

    @JsonIgnore
    private int addressId;

    private String address1;

    private String address2;

    private String pinCode;

    private String city;

    private String state;

    private String landmark;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private String createdBy;

    @JsonIgnore
    private LocalDateTime updatedAt;

    @JsonIgnore
    private String updatedBy;
}
