package com.chirkovm.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Michael Chirkov on 14.11.2017.
 */
@Entity
@Table(name = "products")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer price;

    @Column
    private String mainImg;

    @Column
    private String schemaImg;

    @Column
    private Double discount;

    @Column
    private String description;

    @Column
    private Boolean isSparPart;

    @Column
    private Boolean isDeleted;

    @Column(name = "meta_description")
    private String metaDescription;

    @Column(name = "title")
    private String title;

    @Column(name = "meta_keywords")
    private String keywords;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Product.class)
    @JoinTable(name = "product_spar_parts", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = { @JoinColumn(name = "spar_part_id") })
    private Set<Product> sparParts = new HashSet<>();

    public Product(String name, Integer price, Double discount, String description, Category category,
                   Set<Product> sparParts, List<Property> properties, Boolean isSparPart){
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.category = category;
        this.sparParts = sparParts;
        this.properties = properties;
        this.isSparPart = isSparPart;
        this.isDeleted = false;
    }

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Property.class)
    @JoinTable(name = "product_property", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = { @JoinColumn(name = "property_id") })
    private List<Property> properties = new ArrayList<>();
   /* @Fetch(FetchMode.JOIN)
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private RelatedProduct relatedProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName="id")
    private Category category;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Product.class)
    //@JoinTable(name = "related_products", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
    //private Set<Product> relatedProducts = new HashSet<>(); */

}
