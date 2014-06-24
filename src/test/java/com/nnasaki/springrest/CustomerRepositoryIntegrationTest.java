package com.nnasaki.springrest;

/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.nnasaki.springrest.domain.Address;
import com.nnasaki.springrest.domain.Customer;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import com.nnasaki.springrest.domain.CustomerRepository;
import com.nnasaki.springrest.domain.EmailAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Integration tests for {@link com.nnasaki.springrest.domain.CustomerRepository}.
 *
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CustomerRepositoryIntegrationTest {

    @Qualifier("customerRepository")
    @Autowired
    CustomerRepository repository;

    @Test
    public void savesCustomerCorrectly() {

        EmailAddress email = new EmailAddress("alicia@keys.com");

        Customer dave = new Customer("Alicia", "Keys");
        dave.setEmailAddress(email);
        dave.add(new Address("27 Broadway", "New York", "United States"));

        Customer result = repository.save(dave);
        assertThat(result.getId(), is(notNullValue()));
    }

    @Test
    public void readsCustomerByEmail() {

        EmailAddress email = new EmailAddress("dave@dmband.com");
        Customer result = repository.findByEmailAddress(email);
        assertThat(result.getFirstname(), is("Dave"));
        assertThat(result.getLastname(), is("Matthews"));
    }

    @Test
    public void preventsDuplicateEmail() {

        Customer dave = repository.findByEmailAddress(new EmailAddress("carter@dmband.com"));

        Customer anotherDave = new Customer("Carter", "Beauford");
        anotherDave.setEmailAddress(dave.getEmailAddress());

        repository.save(anotherDave);
    }
}
