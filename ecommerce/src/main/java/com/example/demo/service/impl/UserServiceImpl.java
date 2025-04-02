package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.entity.Role;
import com.example.demo.repo.AddressRepo;
import com.example.demo.repo.CartRepo;
import com.example.demo.repo.ProductRepo;
import com.example.demo.repo.RoleRepo;
import com.example.demo.entity.User;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CartRepo cartRepo;

    @Override
    public User registerUser(UserDto userDto){
        
        if(userRepo.findByEmail(userDto.getEmail()).isPresent()){
            throw new UserAlreadyExistsException("User with email"+ userDto.getEmail()+ "Already Exists");
        }

        User user = new User();

        /*
		 * user.setName(userDto.getName()); user.setEmail(userDto.getEmail());
		 * user.setPassword(userDto.getPassword()); user.setPhone(userDto.getPhone());
		 */

        BeanUtils.copyProperties(userDto, user);

//         user.setEmail(userDto.getEmail());
//         user.setPassword(userDto.getPassword());
//         user.setUsername(userDto.getUsername());

//         Set<Address> addresses = new HashSet<>();

//         for(Long addressId: userDto.getAddressIds()){
//             Address address = addressRepo.findById(addressId).orElseThrow(()->new EntityNotFoundException("Address not found"));
//             addresses.add(address);
//         }

//         Set<Role> roles = new HashSet<>();
        
//         for(Long roleId: userDto.getRoleIds()){
//             Role role = roleRepo.findById(roleId).orElseThrow(()-> new EntityNotFoundException("Role not found"));
//             roles.add(role);
//         }

//         Set<Product> products = new HashSet<>();

//         for(Long productId: userDto.getProductIds()){
//             Product product = productRepo.findById(productId).orElseThrow(()-> new EntityNotFoundException("Product not found"));
//             products.add(product);
//         }


//         user.setProducts(products);
//         user.setAddresses(addresses);
//         user.setRoles(roles);
        return userRepo.save(user);
    }

    @Override
    public User updateUser(Long userId, UserDto userDto) {
        User user = userRepo.findById(userId).orElseThrow(()->new RuntimeException("User not found with id"+ userId));

        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());

        Set<Address> addresses = new HashSet<>();

        for(Long addressId: userDto.getAddressIds()){
            Address address = addressRepo.findById(addressId).orElseThrow(()->new EntityNotFoundException("Address not found"));
            addresses.add(address);
        }

        Set<Role> roles = new HashSet<>();

        for(Long roleId: userDto.getRoleIds()){
            Role role = roleRepo.findById(roleId).orElseThrow(()-> new EntityNotFoundException("Role not found"));
            roles.add(role);
        }

        Set<Product> products = new HashSet<>();
        
        for(Long productId: userDto.getProductIds()){
            Product product = productRepo.findById(productId).orElseThrow(()-> new EntityNotFoundException("Product not found"));
            products.add(product);
        }

        Set<Cart> carts = new HashSet<>();
        for(Long cartId: userDto.getCartIds()){
            Cart cart = cartRepo.findById(cartId).orElseThrow(()-> new EntityNotFoundException("Cart not found"));
            carts.add(cart);
        }

        user.setProducts(products);
        user.setRoles(roles);
        user.setAddresses(addresses);
        return userRepo.save(user);
    }

    @Override
    public void softDeleteUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(()->new RuntimeException("User not found with id"+userId));    
        user.setDeleted(true);
        userRepo.save(user);
    }

    
}