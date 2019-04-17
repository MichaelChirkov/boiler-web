package com.chirkovm.model;

import com.chirkovm.model.converter.LocalDateTimeConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Michael Chirkov on 14.11.2017.
 */
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="delivery_method_id")
    //private DeliveryMethod deliveryMethod;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private Client client;

    @Column
    private String description;

    @Column(name = "order_time")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime orderTime;

    @Column(name = "total_price")
    private Long price;

    @Column
    private Boolean viewed;

    @Column(name = "session_id")
    private String sessionId;

    @Column
    private Boolean confirmed;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = OrderedProduct.class)
    @JoinTable(name = "order_products", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = { @JoinColumn(name = "orderProduct_id") })
    private List<OrderedProduct> orderedProducts = new ArrayList<>();
}
