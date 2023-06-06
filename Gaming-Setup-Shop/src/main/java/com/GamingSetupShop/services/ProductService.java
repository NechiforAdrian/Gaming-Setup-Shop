package com.GamingSetupShop.services;

import com.GamingSetupShop.models.dtos.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findProductByBrandAndColourAndPrice(String brand, String colour, double price);

    List<ProductDTO> findAllProducts();

    void deleteProductById(long id);
}
