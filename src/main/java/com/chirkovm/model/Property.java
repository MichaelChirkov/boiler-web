package com.chirkovm.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Michael Chirkov on 14.11.2017.
 */
@Entity
@Table(name="properties")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_name_id")
    private PropertyName propertyName;

    @Column
    private String value;

    public Property(PropertyName propertyName, String value){
        this.propertyName = propertyName;
        this.value = value;
    }

}
