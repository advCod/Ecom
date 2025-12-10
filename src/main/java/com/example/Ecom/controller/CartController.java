package com.example.Ecom.controller;

import com.example.Ecom.dto.AddCartItemRequest;
import com.example.Ecom.dto.CartItemResponse;
import com.example.Ecom.dto.UpdateCartItemRequest;
import com.example.Ecom.service.CartService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/cart")
@RestController
public class CartController {
    //TODO: endpoints

    @Autowired
    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/item")
    public ResponseEntity<CartItemResponse> addItem(@RequestBody AddCartItemRequest request){
        //TODO
        CartItemResponse response = service.addToCart(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<CartItemResponse> updateItem(@PathVariable Long id, @RequestBody AddCartItemRequest request){
        //TODO
        CartItemResponse response = service.updateCartItem(id,request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        //TODO
        service.removeFromCart(id);
        return ResponseEntity.noContent().build();
    }
}
