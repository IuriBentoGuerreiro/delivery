package com.iuri.delivery.controller;

import com.iuri.delivery.dto.user.UserRequest;
import com.iuri.delivery.dto.user.UserResponse;
import com.iuri.delivery.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse save(@Valid @RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }

    @GetMapping
    public List<UserResponse> findAll(){
        return userService.findAll();
    }
}
