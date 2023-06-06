package com.GamingSetupShop.services;

import com.GamingSetupShop.models.dtos.CustomerDTO;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
}
