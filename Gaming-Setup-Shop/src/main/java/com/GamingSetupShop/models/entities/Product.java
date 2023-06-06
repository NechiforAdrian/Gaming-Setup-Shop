package com.GamingSetupShop.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pc_case")
    private String pcCase;
    @Column(name = "power_supply")
    private String powerSupply;
    @Column(name = "mother_board")
    private String motherBoard;
    @Column(name = "processor")
    private String processor;
    @Column(name = "ram_memory")
    private String ramMemory;
    @Column(name = "graphic_card")
    private String graphicCard;
    @Column(name = "water_cooler")
    private String waterCooler;
    @Column(name = "solid_state_drive")
    private String solidStateDrive;
    @Column(name = "case_fan")
    private String caseFan;
    @Column(name = "price")
    private double price;
    @Column(name = "colour")
    private String colour;
    @Column(name = "brand")
    private String brand;
    @Column
    @ManyToMany(mappedBy = "products")
    private Set<Customer> customers;
}
