package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.Locale.Category;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.OrderItems;
import com.example.demo.entity.Product;
import com.example.demo.repo.CartItemRepo;
import com.example.demo.repo.OrderItemRepo;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;
    

    @Override
    public Product addProduct(ProductDto productDto) {
        Product product = new Product();

        BeanUtils.copyProperties(productDto, product);

        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Long productId, ProductDto productDto) {
        Product product = productRepo.findById(productId).orElseThrow(()->new RuntimeException("Product not found with id: "+ productId));

        BeanUtils.copyProperties(productDto, product);

        Set<CartItem> cartItems = new HashSet<>();

        for(Long cartItemId: productDto.getCartItemIds()){
            CartItem cartItem = cartItemRepo.findById(cartItemId).orElseThrow(()->new RuntimeException("CartItem not found with id: "+ cartItemId));
            cartItems.add(cartItem);
        }

        Set<OrderItems> orderItems = new HashSet<>();

        for(Long orderItemId: productDto.getOrderItemIds()){
            OrderItems orderItem = orderItemRepo.findById(orderItemId).orElseThrow(()->new RuntimeException("Order Item not found with id: "+ orderItemId));
            orderItems.add(orderItem);
        }
        
        product.setOrderItems(orderItems);

        product.setCartItems(cartItems);
        return productRepo.save(product);
    }

    @Override
    public void softDeleteProduct(Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(()->new RuntimeException("Product not found with id: "+ productId));

        product.setDeleted(true);

        productRepo.save(product);
    }
    
}
