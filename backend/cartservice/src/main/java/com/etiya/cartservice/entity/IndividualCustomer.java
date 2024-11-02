package com.etiya.cartservice.entity;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndividualCustomer {

    private UUID id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String gender;

    private Date birthday;

    private String motherName;

    private String fatherName;

    private String nationalityId;
}
