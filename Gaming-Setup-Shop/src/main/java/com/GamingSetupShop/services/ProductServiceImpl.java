package com.GamingSetupShop.services;

import com.GamingSetupShop.models.dtos.ProductDTO;
import com.GamingSetupShop.models.entities.Product;
import com.GamingSetupShop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findProductByBrandAndColourAndPrice(String brand, String colour, double price) {
        List<Product> products = productRepository.findProductByBrandAndColourAndPrice(brand, colour, price);
        List<ProductDTO> productDTOList = new ArrayList<>();
        products.forEach(product -> fromProductEntityToProductDTO(productDTOList, product));

        return productDTOList;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        productRepository.findAll().forEach(product -> fromProductEntityToProductDTO(productDTOList, product));

        return null;
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

    private void fromProductEntityToProductDTO(List<ProductDTO> productDTOS, Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setBrand(product.getBrand());
        productDTO.setColour(product.getColour());
        productDTO.setPrice(product.getPrice());
    }
}
