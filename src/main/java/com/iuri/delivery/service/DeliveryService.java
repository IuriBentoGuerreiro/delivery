package com.iuri.delivery.service;

import com.iuri.delivery.dto.delivery.DeliveryRequest;
import com.iuri.delivery.dto.delivery.DeliveryResponse;
import com.iuri.delivery.model.Delivery;
import com.iuri.delivery.repository.DeliveryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final SaleService saleService;
    private final UserService userService;
    private final EmailService emailService;
    private final ClientService clientService;
    private final DeliveryPersonService deliveryPersonService;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository, SaleService saleService, UserService userService,
                           EmailService emailService, ClientService clientService, DeliveryPersonService deliveryPersonService) {
        this.deliveryRepository = deliveryRepository;
        this.saleService = saleService;
        this.userService = userService;
        this.emailService = emailService;
        this.clientService = clientService;
        this.deliveryPersonService = deliveryPersonService;
    }

    public DeliveryResponse save(DeliveryRequest deliveryRequest){
        var client = userService.findById(deliveryRequest.getClient());

        emailService.sendEmail(client.getEmail(), "PEDIDO ENVIADO!!!", "Seu pedido foi enviado com sucesso!");
        var delivery = deliveryRepository.save(Delivery.builder()
                .sale(saleService.findById(deliveryRequest.getSaleId()))
                .deliveryPerson(deliveryPersonService.findById(deliveryRequest.getDeliveryPersonId()))
                .deliveryStatus(deliveryRequest.getDeliveryStatus())
                .deliveryTime(LocalDateTime.now())
                .departureTime(deliveryRequest.getDepartureTime())
                .currentLocation(deliveryRequest.getCurrentLocation())
                .client(clientService.findById(deliveryRequest.getClient()))
                .build());

        return DeliveryResponse.convert(delivery);
    }

    public List<DeliveryResponse> findAll(){
        return deliveryRepository.findAll().stream()
                .map(DeliveryResponse::convert).toList();
    }

    public Delivery findById(Integer id){
        return deliveryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found"));
    }

    public Delivery update(DeliveryRequest deliveryRequest, Integer id){
        var delivery = findById(id);
        BeanUtils.copyProperties(deliveryRequest, delivery, "id");
        return deliveryRepository.save(delivery);
    }

    public void delete(Integer id){
        var delivery = findById(id);
        deliveryRepository.delete(delivery);
    }
}
