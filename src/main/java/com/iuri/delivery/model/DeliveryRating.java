package com.iuri.delivery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(min = 1, max = 5)
    @NotNull
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "delivery_person_id")
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    @NotNull
    private Sale sale;
}
