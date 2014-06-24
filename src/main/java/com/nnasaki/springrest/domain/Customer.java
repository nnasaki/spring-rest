package com.nnasaki.springrest.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("UnusedDeclaration")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @NotNull
    @Size(max = 64)
    public String password;
}
