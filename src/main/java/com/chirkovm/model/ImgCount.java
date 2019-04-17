package com.chirkovm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Michael Chirkov on 31.01.2018.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="img_count")
public class ImgCount {

    @Id
    private Long id;

    @Column
    private Long value;
}
