package com.iuri.delivery.repository;

import com.iuri.delivery.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
