package com.iuri.delivery.dto.delivery;

import com.iuri.delivery.model.Delivery;
import com.iuri.delivery.model.Sale;
import com.iuri.delivery.model.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class DeliveryResponse {

    private Integer id;
    private List <Sale> sale;
    private User deliveryPerson;
    private String deliveryStatus;
    private LocalDateTime departureTime;
    private LocalDateTime deliveryTime;
    private String currentLocation;

    public static DeliveryResponse convert(Delivery delivery) {
        return DeliveryResponse.builder()
                .id(delivery.getId())
                .sale(delivery.getSales())
                .deliveryPerson(delivery.getDeliveryPerson())
                .deliveryStatus(delivery.getDeliveryStatus())
                .departureTime(delivery.getDepartureTime())
                .deliveryTime(delivery.getDeliveryTime())
                .currentLocation(delivery.getCurrentLocation())
                .build();
    }
}
