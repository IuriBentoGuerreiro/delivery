package com.iuri.delivery.service;

import com.iuri.delivery.dto.client.ClientDTO;
import com.iuri.delivery.model.Client;
import com.iuri.delivery.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findById(Integer id){
        return clientRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found"));
    }

    public Client save(ClientDTO clientDTO){
        var client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return clientRepository.save(client);
    }
}
