package com.iuri.delivery.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.iuri.delivery.dto.user.UserRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<DeliveryRating> deliveryRatings;

    public User(Integer id){
        this.id = id;
    }

    public static User convert(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .address(userRequest.getAddress())
                .build();
    }
}
