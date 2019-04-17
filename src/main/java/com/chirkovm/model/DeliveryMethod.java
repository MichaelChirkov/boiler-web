package com.chirkovm.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Michael Chirkov on 28.09.2017.
 */

@Entity
@Table(name = "delivery_method")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeliveryMethod {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;


   // @OneToOne(mappedBy = "deliveryMethod")
   // private Order order;

}
