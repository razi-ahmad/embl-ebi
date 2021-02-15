package com.embl.ebi.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "First Name is mandatory")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last Name is mandatory")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Age is required")
    @Column(name = "age")
    private Integer age;

    @NotNull(message = "Favourite color is required")
    @Column(name = "favourite_color")
    private String favouriteColor;
}
