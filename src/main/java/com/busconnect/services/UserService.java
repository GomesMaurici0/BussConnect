package com.busconnect.services;

import com.busconnect.entities.UserClientEntity;
import com.busconnect.models.UserClientModel;
import com.busconnect.repository.UserClientJPA;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private final UserClientJPA userClient;
    private final ModelMapper modelMapper;


    public UserService(UserClientJPA userClient, ModelMapper modelMapper) {
        this.userClient = userClient;
        this.modelMapper = modelMapper;
    }

    public UserClientEntity convertToEntity(UserClientModel userDTO) {
        UserClientEntity entity = modelMapper.map(userDTO, UserClientEntity.class);
        return entity;
    }

    public UserClientEntity saveUser(@Valid UserClientModel userDTO) {
        UserClientEntity entity = convertToEntity(userDTO);
        if (userClient.existsByUsername(entity.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return userClient.save(entity);
    }

    public void delete(UUID id) {
        try {
            UserClientEntity entity = userClient.findById(id).
                    orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
            userClient.delete(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar usuário");
        }
    }
}