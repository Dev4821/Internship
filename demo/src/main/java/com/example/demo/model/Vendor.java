package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "vendors")
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    private Long vendorId;

    @NotNull(message = "Vendor name cannot be null")
    @Size(min = 2, max = 50, message = "Vendor name should be between 2 and 50 characters")
    @Column(name = "vendor_name")
    private String vendorName;

    @NotNull(message = "Vendor code cannot be null")
    @Size(min = 2, max = 20, message = "Vendor code should be between 2 and 20 characters")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Vendor code should only contain alphanumeric characters")
    @Column(name = "vendor_code", unique = true)
    private String vendorCode;

    @NotNull(message = "Address cannot be null")
    @Size(min = 2, max = 100, message = "Address should be between 2 and 100 characters")
    @Column(name = "address")
    private String address;

    @NotNull(message = "City cannot be null")
    @Size(min = 2, max = 50, message = "City should be between 2 and 50 characters")
    @Column(name = "city")
    private String city;

    @NotNull(message = "State cannot be null")
    @Size(min = 2, max = 50, message = "State should be between 2 and 50 characters")
    @Column(name = "state")
    private String state;

    @NotNull(message = "Pincode cannot be null")
    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode should be a 6 digit number")
    @Column(name = "pincode")
    private String pincode;

    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be a 10 digit number")
    @Column(name = "phone")
    private String phone;

    @NotNull(message = "Email cannot be null")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email address")
    @Column(name = "email", unique = true)
    private String email;

    // Default constructor required by JPA
    public Vendor() {}

    // Constructor with arguments
    public Vendor(String vendorName, String vendorCode, String address, String city, String state,
            String pincode, String phone, String email) {
        this.vendorName = vendorName;
        this.vendorCode = vendorCode;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters
    public Long getVendorId() {
        return vendor
    }
}
