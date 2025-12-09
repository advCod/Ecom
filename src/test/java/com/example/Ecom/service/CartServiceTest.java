package com.example.Ecom.service;

import com.example.Ecom.dto.AddCartItemRequest;
import com.example.Ecom.dto.CartItemResponse;
import com.example.Ecom.model.CartItem;
import com.example.Ecom.repository.CartItemRepository;
import com.example.Ecom.service.impl.CartServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CartServiceTest {
    private CartServiceImpl service;
    private CartItemRepository repository;

    @BeforeEach
    void setUp(){
        repository = mock(CartItemRepository.class);
        service = new CartServiceImpl(repository);
    }

    @Test
    void addProductToCart(){
        //request created
        AddCartItemRequest request = new AddCartItemRequest();
        request.setProductId("abcProduct");
        request.setQuantity(3);

        //item to be saved and returned as response
        CartItem savedItem = new CartItem();
        savedItem.setProductId("abcProduct");
        savedItem.setQuantity(3);

        when(CartItemRepository.save(ArgumentMatchers.any(CartItem.class))).thenReturn(savedItem);

        //execution
        CartItemResponse response = service.addToCart(request);

        //verification
        assertEquals("abcProduct",response.getProductId());
        assertEquals("3",response.getQuantity());
        verify(repository, times(1)).save(any(CartItem.class));
    }
}
