package com.iuri.delivery.model;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Client extends User{

    public Client(Integer id, String name, String email, String address) {
        super(id, name, email, address);
    }

    public Client(Integer id) {
        super(id);
    }
}
