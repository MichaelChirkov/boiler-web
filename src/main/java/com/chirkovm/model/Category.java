package com.chirkovm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Michael Chirkov on 14.11.2017.
 */
@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "banner_img")
    private String bannerImg;

    @Column(name = "meta_description")
    private String metaDescription;

    @Column(name = "title")
    private String title;

    @Column(name = "meta_keywords")
    private String keywords;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "parent_id")
    //private Category parent;

    //@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    //private Set<Category> childs = new HashSet<>();

    public Category(String name){
        super();
        this.name = name;
    }

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Product.class)
     //@JoinTable(name = "category_product", joinColumns = { @JoinColumn(name = "category_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = PropertyName.class)
    @JoinTable(name = "category_properties", joinColumns = { @JoinColumn(name = "category_id") }, inverseJoinColumns = { @JoinColumn(name = "property_name_id") })
    private List<PropertyName> propertyNames = new ArrayList<>();

   // @OneToMany(mappedBy = "category", orphanRemoval = true, cascade = CascadeType.ALL)
   // private Set<Product> products = new HashSet<>();

    public Category(String name, List<PropertyName> propertyNames, String shortDescription){
        this.name = name;
        this.propertyNames = propertyNames;
        this.shortDescription = shortDescription;

    }

    @Override
    public String toString() {
        return this.id + this.name;
    }
}

