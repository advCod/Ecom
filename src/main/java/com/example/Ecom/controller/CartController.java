package com.example.Ecom.controller;

import com.example.Ecom.dto.AddCartItemRequest;
import com.example.Ecom.dto.CartItemResponse;
import com.example.Ecom.dto.UpdateCartItemRequest;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
@RestController
public class CartController {
    //TODO: endpoints

    @PostMapping("/item")
    public CartItemResponse addItem(@RequestBody AddCartItemRequest request){
        //TODO
        return null;
    }

    @PutMapping("/item/{productId}")
    public CartItemResponse updateItem(@PathVariable String productId, @RequestBody UpdateCartItemRequest request){
        //TODO
        return null;
    }

    @DeleteMapping("/item/{productId}")
    public void deleteItem(@PathVariable String productId){
        //TODO
    }
}
