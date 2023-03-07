package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.repo.VendorReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {
    @Autowired
    VendorReposistory vendorReposistory;
    @PostMapping("/vendorSave")
    public String insertVendor(@RequestBody Vendor vendor)
    {
        vendorReposistory.save(vendor);
      return "Your Record is successfull submitted";
    }

}
