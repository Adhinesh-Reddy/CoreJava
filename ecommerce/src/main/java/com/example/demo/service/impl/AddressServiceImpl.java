package com.example.demo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import com.example.demo.repo.AddressRepo;
import com.example.demo.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Override
    public Address addAddress(AddressDto addressDto) {
        
        Address address = new Address();

        BeanUtils.copyProperties(addressDto, address);

        return addressRepo.save(address);
    }

    @Override
    public Address updateAddress(Long addressId, AddressDto addressDto) {
        Address address = addressRepo.findById(addressId).orElseThrow(()->new RuntimeException("Address not found with id: "+addressId));

        BeanUtils.copyProperties(addressDto, address);

        return addressRepo.save(address);
    }

    @Override
    public void softDeleteAddress(Long addressId) {
        Address address = addressRepo.findById(addressId).orElseThrow(()->new RuntimeException("Address not found with id: "+addressId));
        address.setDeleted(true);
        addressRepo.save(address);
    }
    
}
