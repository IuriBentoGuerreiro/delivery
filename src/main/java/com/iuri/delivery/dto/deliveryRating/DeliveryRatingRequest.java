package com.iuri.delivery.dto.deliveryRating;

import lombok.Data;

@Data
public class DeliveryRatingRequest {

    private String comment;
    private Integer rating;
    private Integer DeliveryPersonId;
    private Integer saleId;
}
