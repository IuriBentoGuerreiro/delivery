package com.iuri.delivery.controller;

import com.iuri.delivery.dto.ClientDTO;
import com.iuri.delivery.model.Client;
import com.iuri.delivery.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public Client save(@RequestBody ClientDTO clientDTO){
        return clientService.save(clientDTO);
    }
}
