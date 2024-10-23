package com.etiya.customerservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "customer_id")
@Table(name="individual_customers")

public class IndividualCustomer extends Customer {

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "gender")
    private String gender;

    @NotNull
    @Column(name = "birthday")
    private Date birthday;


    @Column(name = "mother_name")
    private String motherName;


    @Column(name = "father_name")
    private String fatherName;

    @NotNull
    @Column(name = "nationality_id")
    private String nationalityId;


}
