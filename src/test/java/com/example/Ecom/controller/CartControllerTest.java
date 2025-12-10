package com.example.Ecom.controller;

import com.example.Ecom.dto.AddCartItemRequest;
import com.example.Ecom.dto.CartItemResponse;
import com.example.Ecom.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CartController.class)
class CartControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CartService service;

    @Test
    void addProductToCart() throws Exception {
        CartItemResponse response = new CartItemResponse("ABC123", 10);

        when(service.addToCart(any(AddCartItemRequest.class))).thenReturn(response);

        mvc.perform(
                        post("/api/cart/item")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"productId\":\"ABC123\",\"quantity\":2}")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value("ABC123"))
                .andExpect(jsonPath("$.quantity").value(10));
    }
}
