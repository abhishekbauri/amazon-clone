package com.example.Amazon.AmazonClone.objectMapper;

import com.example.Amazon.AmazonClone.entity.RoleEntity;
import com.example.Amazon.AmazonClone.model.RoleDTO;

public class RoleMapper {

    public static RoleDTO entityToDto(RoleEntity roleEntity){
        if(roleEntity == null) return null;

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleName(roleEntity.getRoleName());
        roleDTO.setRoleId(roleEntity.getRoleId());
        roleDTO.setCreatedAt(roleEntity.getCreatedAt());
        roleDTO.setCreatedBy(roleEntity.getCreatedBy());
        roleDTO.setUpdatedAt(roleEntity.getUpdatedAt());
        roleDTO.setUpdatedBy(roleEntity.getUpdatedBy());
        return (roleDTO);
    }

    public static RoleEntity dtoToEntity(RoleDTO roleDTO){
        if(roleDTO == null) return (null);

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName(roleDTO.getRoleName());
        roleEntity.setRoleId(roleDTO.getRoleId());
        roleEntity.setCreatedAt(roleDTO.getCreatedAt());
        roleEntity.setCreatedBy(roleDTO.getCreatedBy());
        roleEntity.setUpdatedAt(roleDTO.getUpdatedAt());
        roleEntity.setUpdatedBy(roleDTO.getUpdatedBy());
        return (roleEntity);
    }
}
