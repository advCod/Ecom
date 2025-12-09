package com.example.Ecom.service;

import com.example.Ecom.dto.AddCartItemRequest;
import com.example.Ecom.dto.AddCartItemResponse;
import com.example.Ecom.dto.UpdateCartItemRequest;

public interface CartService {
    //TODO: add update delete

    CartItemResponse addToCart(AddCartItemRequest request);
    CartItemResponse updateCartItem(String productId, int quantity);
    void removeFromCart(String productId);


}
