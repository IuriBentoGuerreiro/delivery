package com.iuri.delivery.controller;

import com.iuri.delivery.dto.user.UserRequest;
import com.iuri.delivery.dto.user.UserResponse;
import com.iuri.delivery.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "save")
    public UserResponse save(@Valid @RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "findAll")
    public List<UserResponse> findAll(){
        return userService.findAll();
    }
}
