package com.etiya.customerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    private UUID id;
    private String name;
    private Date createdDate;
    private boolean status;
    private double discount;
}
