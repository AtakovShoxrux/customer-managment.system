package com.cmsystem.cm_system.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.*;
import java.io.*;

@Data
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @NaturalId(mutable = true)
    private String email;
    @NaturalId(mutable = true)
    private String mobile;

    private String country;
    private String city;
    private String address;

}
