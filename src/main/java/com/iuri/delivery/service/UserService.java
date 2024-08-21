package com.iuri.delivery.service;

import com.iuri.delivery.dto.user.UserRequest;
import com.iuri.delivery.dto.user.UserResponse;
import com.iuri.delivery.model.User;
import com.iuri.delivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse save(UserRequest userRequest){
        return UserResponse.convert(userRepository.save(User.convert(userRequest)));
    }

    public List<UserResponse> findAll(){
        return userRepository.findAll().stream()
                .map(UserResponse::convert).toList();
    }
}
