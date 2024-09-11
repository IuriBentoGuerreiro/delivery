package com.iuri.delivery.repository;

import com.iuri.delivery.model.DeliveryPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, Integer> {
}
