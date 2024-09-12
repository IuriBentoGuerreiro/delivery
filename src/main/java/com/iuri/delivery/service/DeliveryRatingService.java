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
    private final DeliveryPersonService deliveryPersonService;
    private final EmailService emailService;

    @Autowired
    public DeliveryRatingService(DeliveryRatingRepository deliveryRatingRepository,
                                 SaleService saleService,
                                 DeliveryPersonService deliveryPersonService,
                                 EmailService emailService) {
        this.deliveryRatingRepository = deliveryRatingRepository;
        this.saleService = saleService;
        this.deliveryPersonService = deliveryPersonService;
        this.emailService = emailService;
    }

    public DeliveryRatingResponse save(DeliveryRatingRequest request){
        var deliveryPerson = deliveryPersonService.findById(request.getDeliveryPersonId());

        emailService.sendEmail(deliveryPerson.getEmail(), "VOCÊ ACABA DE RECEBER UMA AVALIAÇÃO, CONFIRA:", request.getComment());

        var deliveryRating = deliveryRatingRepository.save(DeliveryRating.builder()
                        .rating(request.getRating())
                        .comment(request.getComment())
                        .sale(saleService.findById(request.getSaleId()))
                .build());

        return DeliveryRatingResponse.convert(deliveryRating);
    }
}
