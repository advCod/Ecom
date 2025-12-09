package com.example.Ecom.service.impl;

import com.example.Ecom.dto.AddCartItemRequest;
import com.example.Ecom.dto.CartItemResponse;
import com.example.Ecom.model.CartItem;
import com.example.Ecom.repository.CartItemRepository;
import com.example.Ecom.service.CartService;

public class CartServiceImpl implements CartService {

    private CartItemRepository repository;

    public CartServiceImpl(CartItemRepository repository) {
        this.repository=repository;
    }

    @Override
    public CartItemResponse addToCart(AddCartItemRequest request) {
        CartItem item = new CartItem(request.getProductId(), request.getQuantity());
        CartItem saved = repository.save(item);
        CartItemResponse response = new CartItemResponse(saved.getProductId(), saved.getQuantity());
        return response;
    }

    @Override
    public CartItemResponse updateCartItem(Long id, AddCartItemRequest request) {

        return null;
    }

    @Override
    public void removeFromCart(String productId) {

    }
    //TODO: implement method

}
