package com.example.customerservice;

import com.example.customerservice.entity.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication  {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration) {
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(
                    null, "kawtar", "kawtar@gmail.com"
            ));
            customerRepository.save(new Customer(
                    null, "lamyaa", "lam@gmail.com"
            ));
            customerRepository.save(new Customer(
                    null, "coral", "coral@gmail.com"
            ));
            customerRepository.save(new Customer(
                    null, "shay", "shay@gmail.com"
            ));
        };
    }
}