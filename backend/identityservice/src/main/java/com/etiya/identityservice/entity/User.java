package com.etiya.identityservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User implements UserDetails
{
    @Id
    @GeneratedValue()
    @UuidGenerator()
    private UUID id;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles;;
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="identityno")
    private String identityNo;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;


    @Column(name = "status")
    private Boolean status;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // roller
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }
}