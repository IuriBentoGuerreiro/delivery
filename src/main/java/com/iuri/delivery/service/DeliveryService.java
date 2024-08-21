package com.iuri.delivery.service;

import com.iuri.delivery.dto.delivery.DeliveryRequest;
import com.iuri.delivery.dto.delivery.DeliveryResponse;
import com.iuri.delivery.model.Delivery;
import com.iuri.delivery.model.Sale;
import com.iuri.delivery.model.User;
import com.iuri.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public DeliveryResponse save(DeliveryRequest deliveryRequest){
        var delivery = deliveryRepository.save(Delivery.builder()
                        .sale(new Sale(deliveryRequest.getSaleId()))
                        .deliveryStatus(deliveryRequest.getDeliveryStatus())
                        .deliveryTime(LocalDateTime.now())
                        .deliveryPerson(new User(deliveryRequest.getDeliveryPersonId()))
                        .departureTime(deliveryRequest.getDepartureTime())
                        .currentLocation(deliveryRequest.getCurrentLocation())
                .build());

        return DeliveryResponse.convert(delivery);
    }
}
