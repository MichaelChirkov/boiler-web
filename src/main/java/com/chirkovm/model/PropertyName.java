package com.chirkovm.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Michael Chirkov on 16.11.2017.
 */
@Entity
@Table(name="property_name")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PropertyName{

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;


    @Column(name = "is_size")
    private Boolean isSize;

    public PropertyName(String name, Boolean value){
        this.name = name;
        this.isSize = value;
    }


}
