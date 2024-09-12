package com.iuri.delivery.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class DeliveryPerson extends User{

    @JsonBackReference
    @OneToMany(mappedBy = "deliveryPerson")
    private List<DeliveryRating> deliveryRatings;

    public DeliveryPerson(Integer id, String name, String email, String address) {
        super(id, name, email, address);
    }

    public DeliveryPerson(Integer id) {
        super(id);
    }
}
