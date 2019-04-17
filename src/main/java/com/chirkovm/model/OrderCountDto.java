package com.chirkovm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Michael Chirkov on 17.01.2018.
 */
@Getter
@Setter
@AllArgsConstructor
public class OrderCountDto {

    private String count;
}
