package com.iuri.delivery.model;

import com.iuri.delivery.dto.delivery.DeliveryRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany
    private List <Sale> sales;

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

    public static Delivery convert(DeliveryRequest deliveryRequest) {
        return Delivery.builder()
                .sales(deliveryRequest.getSaleRequests().stream().map(Sale::convert).toList())
                .deliveryPerson(new User(deliveryRequest.getDeliveryPersonId()))
                .deliveryStatus(deliveryRequest.getDeliveryStatus())
                .departureTime(deliveryRequest.getDepartureTime())
                .deliveryTime(deliveryRequest.getDeliveryTime())
                .currentLocation(deliveryRequest.getCurrentLocation())
                .build();
    }
}
