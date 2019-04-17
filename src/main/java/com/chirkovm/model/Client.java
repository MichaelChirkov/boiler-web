package com.chirkovm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Michael Chirkov on 14.01.2018.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column
    private String mail;

    @Column
    private String patronymic;

    @Column
    private String name;

    @OneToOne(mappedBy = "client")
    private Order order;

    public Client(String name, String patronymic, String mail, String phoneNumber){
        this.name = name;
        this.patronymic = patronymic;
        this.mail = mail;
        this.phoneNumber = Long.parseLong(phoneNumber);
    }
}
