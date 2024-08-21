package com.iuri.delivery.model;

import com.iuri.delivery.dto.delivery.DeliveryRequest;
import com.iuri.delivery.dto.delivery.DeliveryResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "delivery")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "delivery_person_id")
    private User deliveryPerson;

    @Column(name = "delivery_status")
    private String deliveryStatus;
    @Column(name = "departure_time")
    private LocalDateTime departureTime;
    @Column(name = "delivery_time")
    private LocalDateTime deliveryTime;
    @Column(name = "current_location")
    private String currentLocation;

    public static DeliveryResponse convert(DeliveryRequest deliveryRequest) {
        return DeliveryResponse.builder()
                .sale(new Sale(deliveryRequest.getSaleId()))
                .deliveryPerson(new User(deliveryRequest.getDeliveryPersonId()))
                .deliveryStatus(deliveryRequest.getDeliveryStatus())
                .departureTime(deliveryRequest.getDepartureTime())
                .deliveryTime(deliveryRequest.getDeliveryTime())
                .currentLocation(deliveryRequest.getCurrentLocation())
                .build();
    }
}
