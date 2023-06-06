package com.GamingSetupShop.services;

import com.GamingSetupShop.models.dtos.CustomerDTO;
import com.GamingSetupShop.models.entities.Customer;
import com.GamingSetupShop.repositories.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private final ObjectMapper objectMapper;
    private final CustomerValidationService customerValidationService;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(ObjectMapper objectMapper,
                               CustomerValidationService customerValidationService,
                               CustomerRepository customerRepository) {
        this.objectMapper = objectMapper;
        this.customerValidationService = customerValidationService;
        this.customerRepository = customerRepository;
    }

    @Transactional
    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        customerValidationService.emailValidation(customerDTO.getEmail());
        Customer customer = objectMapper.convertValue(customerDTO, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);

        log.info("Customer " + savedCustomer.getFirstName() + " was created.");
        return objectMapper.convertValue(savedCustomer, CustomerDTO.class);
    }
}
