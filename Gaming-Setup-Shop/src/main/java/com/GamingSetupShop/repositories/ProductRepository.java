package com.GamingSetupShop.repositories;

import com.GamingSetupShop.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByBrandAndColourAndPrice(String brand, String colour, double price);
}
