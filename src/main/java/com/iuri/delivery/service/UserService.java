package com.iuri.delivery.service;

import com.iuri.delivery.dto.user.UserRequest;
import com.iuri.delivery.dto.user.UserResponse;
import com.iuri.delivery.model.User;
import com.iuri.delivery.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

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

    public User findById(Integer id){
        return userRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found"));
    }

    public User update(UserRequest userRequest, Integer id){
        var user = findById(id);
        BeanUtils.copyProperties(userRequest, user, "id");
        return userRepository.save(user);
    }

    public void delete(Integer id){
        var user = findById(id);
        userRepository.delete(user);
    }
}
