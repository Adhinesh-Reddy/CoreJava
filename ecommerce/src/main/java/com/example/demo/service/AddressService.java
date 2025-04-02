package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.dto.AddressDto;

public interface AddressService {
    public Address addAddress(AddressDto addressDto);
    public Address updateAddress(Long addressId, AddressDto addressDto);
    public void softDeleteAddress(Long addressId);
}
