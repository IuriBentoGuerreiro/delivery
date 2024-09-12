package com.iuri.delivery.service;

import com.iuri.delivery.dto.deliveryPerson.DeliveryPersonDTO;
import com.iuri.delivery.model.DeliveryPerson;
import com.iuri.delivery.repository.DeliveryPersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class DeliveryPersonService {

    @Autowired
    private DeliveryPersonRepository deliveryPersonRepository;

    public DeliveryPerson findById(Integer id){
        return deliveryPersonRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found"));
    }

    public DeliveryPerson save(DeliveryPersonDTO deliveryPersonDTO){
        var deliveyPerson = new DeliveryPerson();
        BeanUtils.copyProperties(deliveryPersonDTO, deliveyPerson);
        return deliveryPersonRepository.save(deliveyPerson);
    }
}
