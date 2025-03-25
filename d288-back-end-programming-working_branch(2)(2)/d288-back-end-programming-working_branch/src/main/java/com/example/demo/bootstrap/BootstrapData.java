package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootstrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() > 1) {
            return;
        }

        Customer a = new Customer();
        a.setFirstName("Jon");
        a.setLastName("Doe");
        a.setAddress("123 Maple Ave");
        a.setPostal_code("1580");
        a.setPhone("7892640971");
        a.setDivision(divisionRepository.getReferenceById(2L));

        Customer b = new Customer();
        b.setFirstName("Joan");
        b.setLastName("Doe");
        b.setAddress("123 Oak Ave");
        b.setPostal_code("4290");
        b.setPhone("3481092384");
        b.setDivision(divisionRepository.getReferenceById(3L));

        Customer c = new Customer();
        c.setFirstName("Sawyer");
        c.setLastName("Edwards");
        c.setAddress("123 Cedar Ave");
        c.setPostal_code("7230");
        c.setPhone("3851233482");
        c.setDivision(divisionRepository.getReferenceById(4L));

        Customer d = new Customer();
        d.setFirstName("Felix");
        d.setLastName("Hutchins");
        d.setAddress("123 Willow Ave");
        d.setPostal_code("7230");
        d.setPhone("3851233482");
        d.setDivision(divisionRepository.getReferenceById(5L));

        Customer e = new Customer();
        e.setFirstName("Willow");
        e.setLastName("Johnson");
        e.setAddress("123 Beech Ave");
        e.setPostal_code("5292");
        e.setPhone("7305471571");
        e.setDivision(divisionRepository.getReferenceById(6L));

        customerRepository.save(a);
        customerRepository.save(b);
        customerRepository.save(c);
        customerRepository.save(d);
        customerRepository.save(e);

        customerRepository.findAll();

    }
}
