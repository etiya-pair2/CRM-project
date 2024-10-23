package com.etiya.customerservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "customer_id")
@Table(name="corporate_customer")
public class CorporateCustomer extends Customer{


    @NotNull
    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @Column(name = "tax_no")
    private String taxNo;
}
