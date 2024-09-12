package com.iuri.delivery.controller;

import com.iuri.delivery.dto.client.ClientDTO;
import com.iuri.delivery.model.Client;
import com.iuri.delivery.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Client")
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "save")
    public Client save(@RequestBody ClientDTO clientDTO){
        return clientService.save(clientDTO);
    }
}
