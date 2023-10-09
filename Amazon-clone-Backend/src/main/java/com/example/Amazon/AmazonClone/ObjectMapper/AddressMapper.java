package com.example.Amazon.AmazonClone.objectMapper;

import com.example.Amazon.AmazonClone.entity.AddressEntity;
import com.example.Amazon.AmazonClone.model.AddressDTO;

public class AddressMapper {

    public static AddressDTO entityToDto(AddressEntity addressEntity){
        if(addressEntity == null) return null;

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddress1(addressEntity.getAddress1());
        addressDTO.setAddress2(addressEntity.getAddress2());
        addressDTO.setAddressId(addressEntity.getAddressId());
        addressDTO.setCity(addressEntity.getCity());
        addressDTO.setLandmark(addressEntity.getLandmark());
        addressDTO.setState(addressEntity.getState());
        addressDTO.setCreatedAt(addressEntity.getCreatedAt());
        addressDTO.setCreatedBy(addressEntity.getCreatedBy());
        addressDTO.setPinCode(addressEntity.getPinCode());
        addressDTO.setUpdatedAt(addressEntity.getUpdatedAt());
        addressDTO.setUpdatedBy(addressEntity.getUpdatedBy());

        return (addressDTO);
    }

    public static AddressEntity dtoToEntity(AddressDTO addressDTO){
        if(addressDTO == null) return null;

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress1(addressDTO.getAddress1());
        addressEntity.setAddress2(addressDTO.getAddress2());
        addressEntity.setAddressId(addressDTO.getAddressId());
        addressEntity.setCity(addressDTO.getCity());
        addressEntity.setLandmark(addressDTO.getLandmark());
        addressEntity.setState(addressDTO.getState());
        addressEntity.setCreatedAt(addressDTO.getCreatedAt());
        addressEntity.setCreatedBy(addressDTO.getCreatedBy());
        addressEntity.setPinCode(addressDTO.getPinCode());
        addressEntity.setUpdatedAt(addressDTO.getUpdatedAt());
        addressEntity.setUpdatedBy(addressDTO.getUpdatedBy());

        return (addressEntity);
    }
}
