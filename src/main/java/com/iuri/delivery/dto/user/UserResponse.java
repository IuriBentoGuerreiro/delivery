package com.iuri.delivery.dto.user;

import com.iuri.delivery.model.DeliveryRating;
import com.iuri.delivery.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponse {

    private Integer id;
    private String name;
    private String email;
    private String address;
    private List<DeliveryRating> deliveryRatings;

    public static UserResponse convert(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .address(user.getAddress())
                .deliveryRatings(user.getDeliveryRatings())
                .build();
    }
}
