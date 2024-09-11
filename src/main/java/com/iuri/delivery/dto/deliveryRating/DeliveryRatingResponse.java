package com.iuri.delivery.dto.deliveryRating;

import com.iuri.delivery.model.DeliveryPerson;
import com.iuri.delivery.model.DeliveryRating;
import com.iuri.delivery.model.Sale;
import com.iuri.delivery.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeliveryRatingResponse {

    private Integer id;
    private String comment;
    private Integer rating;
    private DeliveryPerson deliveryPerson;
    private Sale sale;

    public static DeliveryRatingResponse convert(DeliveryRating deliveryRating){
        return DeliveryRatingResponse.builder()
                .id(deliveryRating.getId())
                .comment(deliveryRating.getComment())
                .rating(deliveryRating.getRating())
                .sale(deliveryRating.getSale())
                .deliveryPerson(deliveryRating.getDeliveryPerson())
                .build();
    }
}
