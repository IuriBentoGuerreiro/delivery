package com.iuri.delivery.dto.delivery;

import com.iuri.delivery.model.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DeliveryResponse {

    private Integer id;
    private Sale sale;
    private Client client;
    private DeliveryPerson deliveryPerson;
    private String deliveryStatus;
    private LocalDateTime departureTime;
    private LocalDateTime deliveryTime;
    private String currentLocation;

    public static DeliveryResponse convert(Delivery delivery) {
        return DeliveryResponse.builder()
                .id(delivery.getId())
                .sale(delivery.getSale())
                .deliveryPerson(delivery.getDeliveryPerson())
                .deliveryStatus(delivery.getDeliveryStatus())
                .departureTime(delivery.getDepartureTime())
                .deliveryTime(delivery.getDeliveryTime())
                .currentLocation(delivery.getCurrentLocation())
                .client(delivery.getClient())
                .build();
    }
}
