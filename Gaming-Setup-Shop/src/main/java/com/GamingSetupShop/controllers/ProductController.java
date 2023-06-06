package com.GamingSetupShop.controllers;

import com.GamingSetupShop.models.dtos.ProductDTO;
import com.GamingSetupShop.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProductDTO>> findProductByBrandAndColourAndWeightAndPrice(@RequestParam(required = false) String brand,
                                                                                         @RequestParam(required = false) String colour,
                                                                                         @RequestParam(required = false) Double price) {
        return ResponseEntity.ok(productService.findProductByBrandAndColourAndPrice(brand, colour, price));
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable long id) {
        log.info("Product with id " + id + " was deleted.");
        productService.deleteProductById(id);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAllProducts() {
        log.info("Products retrieved.");
        return ResponseEntity.ok(productService.findAllProducts());
    }
}
