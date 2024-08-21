package com.iuri.delivery.dto.user;

import com.iuri.delivery.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private Integer id;
    private String name;
    private String email;
    private String address;

    public static UserResponse convert(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .address(user.getAddress())
                .build();
    }
}
