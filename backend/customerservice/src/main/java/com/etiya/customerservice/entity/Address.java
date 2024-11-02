package com.etiya.customerservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customer;

    @JoinColumn(name = "district_id")
    @ManyToOne
    private District district;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "address")
    private BillingAccount billingAccount;

    @Column(name = "flat_number")
    private String flatNumber;
}
