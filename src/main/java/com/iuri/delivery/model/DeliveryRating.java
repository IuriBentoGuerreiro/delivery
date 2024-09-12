package com.iuri.delivery.model;

import com.iuri.delivery.dto.deliveryRating.DeliveryRatingRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rating")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "comment")
    @NotBlank
    private String comment;

    @Column(name = "rating")
    @Max(5)
    @Min(1)
    @NotNull
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "delivery_person_id")
    @NotNull
    private DeliveryPerson deliveryPerson;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    @NotNull
    private Sale sale;

    public static DeliveryRating convert(DeliveryRatingRequest deliveryRatingRequest){
        return DeliveryRating.builder()
                .comment(deliveryRatingRequest.getComment())
                .rating(deliveryRatingRequest.getRating())
                .deliveryPerson(new DeliveryPerson(deliveryRatingRequest.getDeliveryPersonId()))
                .sale(new Sale(deliveryRatingRequest.getSaleId()))
                .build();
    }
}
