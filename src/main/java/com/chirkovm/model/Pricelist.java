package com.chirkovm.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Michael Chirkov on 16.03.2018.
 */
@Entity
@Table(name = "price_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pricelist {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String link;

    @Column(name = "eng_name")
    private String engName;
}
