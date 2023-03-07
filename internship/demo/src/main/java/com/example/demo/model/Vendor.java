package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "vendor")
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    private Long vendorId;


    @NotNull(message = "Vendor name is required")
    @Size(min = 3, max = 50, message = "Vendor name must be between 3 and 50 characters")
    @Column(name = "vendor_name")
    private String vendorName;

    @NotNull(message = "Vendor code is required")
    @Size(min = 3, max = 20, message = "Vendor code must be between 3 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Vendor code must be alphanumeric")
    @Column(name = "vendor_code", unique = true)
    private String vendorCode;

    @NotNull(message = "Vendor address is required")
    @Size(min = 5, max = 100, message = "Vendor address must be between 5 and 100 characters")
    @Column(name = "address")
    private String address;

    @NotNull(message = "Vendor city is required")
    @Size(min = 3, max = 50, message = "Vendor city must be between 3 and 50 characters")
    @Column(name = "city")
    private String city;

    @NotNull(message = "Vendor state is required")
    @Size(min = 3, max = 50, message = "Vendor state must be between 3 and 50 characters")
    @Column(name = "state")
    private String state;

    @NotNull(message = "Vendor pincode is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "Vendor pincode must be a 6 digit number")
    @Column(name = "pincode")
    private String pincode;

    @NotNull(message = "Vendor phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Vendor phone number must be a 10 digit number")
    @Column(name = "phone")
    private String phone;

    @NotNull(message = "Vendor email is required")
    @Email(message = "Invalid email format")
    @Column(name = "email", unique = true)
    private String email;
    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Vendor{" +

                ", vendorName='" + vendorName + '\'' +
                ", vendorCode='" + vendorCode + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // Getter and setter methodsnf
}
