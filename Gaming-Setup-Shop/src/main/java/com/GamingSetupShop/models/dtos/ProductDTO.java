package com.GamingSetupShop.models.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductDTO implements Serializable {

    private long id;
    private String colour;
    private String brand;
    private double price;
    private List<String> selectedComponent;
}
