package com.example.Ecom.service.impl;

import com.example.Ecom.dto.AddCartItemRequest;
import com.example.Ecom.dto.CartItemResponse;
import com.example.Ecom.model.CartItem;
import com.example.Ecom.repository.CartItemRepository;
import com.example.Ecom.service.CartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    //TODO: implement method
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
        CartItem itemToBeUpdated = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        itemToBeUpdated.setProductId(request.getProductId());
        itemToBeUpdated.setQuantity(request.getQuantity());
        CartItem updated = repository.save(itemToBeUpdated);
        CartItemResponse response = new CartItemResponse(updated.getProductId(), updated.getQuantity());
        return response;
    }

    @Override
    public void removeFromCart(Long id) {
        CartItem item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        repository.delete(item);
    }


}
