package com.CCS.Service.Mapper;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.UserRequestDTO;
import com.CCS.Service.ResponseDTO.UserResponseDTO;
import com.CCS.Service.model.User;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setStatus(dto.getStatus());
        user.setTenantId(dto.getTenantId());

        return user;
    }


    public UserResponseDTO toResponseDTO(User user) {

        UserResponseDTO dto = new UserResponseDTO();

        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setStatus(user.getStatus());
        dto.setTenantId(user.getTenantId());

        return dto;
    }
}