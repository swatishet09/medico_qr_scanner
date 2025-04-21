package com.example.medical_scanner.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  // 🔹 Marks this class as a database entity
@Table(name = "medicine") // 🔹 Table name in the DB
public class Medicine {

    @Id  // 🔹 This is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 🔹 Auto-increment
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @Column(name = "manufacture_date", nullable = false)
    private LocalDate manufactureDate;

    @Column(length = 255)
    private String uses;

    // 🔹 Default constructor (needed for JPA)
    public Medicine() {}

    // 🔹 Constructor with fields
    public Medicine(String name, LocalDate expiryDate, LocalDate manufactureDate, String uses) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.manufactureDate = manufactureDate;
        this.uses = uses;
    }

    // 🔹 Getters and Setters (required for data access)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public LocalDate getManufactureDate() { return manufactureDate; }
    public void setManufactureDate(LocalDate manufactureDate) { this.manufactureDate = manufactureDate; }

    public String getUses() { return uses; }
    public void setUses(String uses) { this.uses = uses; }
}

