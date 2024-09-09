package com.iuri.delivery.service;

import com.iuri.delivery.dto.deliveryRating.DeliveryRatingRequest;
import com.iuri.delivery.dto.deliveryRating.DeliveryRatingResponse;
import com.iuri.delivery.model.DeliveryRating;
import com.iuri.delivery.repository.DeliveryRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryRatingService {

    private final DeliveryRatingRepository deliveryRatingRepository;
    private final SaleService saleService;
    private final UserService userService;

    @Autowired
    public DeliveryRatingService(DeliveryRatingRepository deliveryRatingRepository,
                                 SaleService saleService,
                                 UserService userService) {
        this.deliveryRatingRepository = deliveryRatingRepository;
        this.saleService = saleService;
        this.userService = userService;
    }

    public DeliveryRatingResponse save(DeliveryRatingRequest request){
        var deliveryRating = deliveryRatingRepository.save(DeliveryRating.builder()
                        .rating(request.getRating())
                        .comment(request.getComment())
                        .sale(saleService.findById(request.getSaleId()))
                        .user(userService.findById(request.getUserId()))
                .build());

        return DeliveryRatingResponse.convert(deliveryRating);
    }
}
