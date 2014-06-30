package com.nnasaki.springrest.domain;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("UnusedDeclaration")
@Entity
public class Customer extends AbstractEntity{
    public String firstname, lastname;

    @NotNull
    @Size(max = 64)
    public String password;

    @Column(unique = true)
    public EmailAddress emailAddress;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    public Set<Address> addresses = new HashSet<>();

    /**
     * Creates a new {@link Customer} from the given firstname and lastname.
     *
     * @param firstname must not be {@literal null} or empty.
     * @param lastname must not be {@literal null} or empty.
     */
    public Customer(String firstname, String lastname) {

        Assert.hasText(firstname);
        Assert.hasText(lastname);

        this.firstname = firstname;
        this.lastname = lastname;
    }

    protected Customer() {

    }

    /**
     * Adds the given {@link Address} to the {@link Customer}.
     *
     * @param address must not be {@literal null}.
     */
    public void add(Address address) {

        Assert.notNull(address);
        this.addresses.add(address);
    }
}
