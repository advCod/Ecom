package com.example.Ecom.service;

import com.example.Ecom.dto.AddCartItemRequest;
import com.example.Ecom.dto.AddCartItemResponse;
import com.example.Ecom.dto.CartItemResponse;
import com.example.Ecom.dto.UpdateCartItemRequest;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    //TODO: add update delete

    CartItemResponse addToCart(AddCartItemRequest request);
    CartItemResponse updateCartItem(Long id, AddCartItemRequest request);
    void removeFromCart(Long id);


}
