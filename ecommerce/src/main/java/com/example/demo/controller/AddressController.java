package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import com.example.demo.repo.AddressRepo;
import com.example.demo.service.impl.AddressServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressServiceImpl;

    @Autowired
    private AddressRepo addressRepo;

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@Valid @RequestBody AddressDto addressDto) {
        Address addAddress = addressServiceImpl.addAddress(addressDto);

        if(addAddress !=null)
            return ResponseEntity.status(HttpStatus.CREATED).body(addAddress);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Address Not Added");
    }

    @PutMapping("/update/{addressId}")
    public ResponseEntity<?> updateAddress(@PathVariable Long addressId, @RequestBody AddressDto addressDto){
        Address updateAddress = addressServiceImpl.updateAddress(addressId, addressDto);

        if(updateAddress!=null)
            return ResponseEntity.status(HttpStatus.OK).body("Address updated successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Address not updated");
    }
    
    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<?> softDeleteAddress(@PathVariable Long addressId){
        addressServiceImpl.softDeleteAddress(addressId);
        return ResponseEntity.status(HttpStatus.OK).body("Address deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAddresses(){
        return ResponseEntity.status(HttpStatus.OK).body(addressRepo.findAll());
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<?> fetchSpecificAddressId(@PathVariable Long addressId){
        return ResponseEntity.status(HttpStatus.OK).body(addressRepo.findById(addressId));
    }
}
