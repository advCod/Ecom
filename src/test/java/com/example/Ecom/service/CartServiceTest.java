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

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CartServiceTest {
    private CartService service;
    private CartItemRepository repository;

    @BeforeEach
    void setUp(){
        repository = mock(CartItemRepository.class);
        service = new CartServiceImpl(repository);
    }

    @Test
    void addProductToCartTest(){
        //request created
        AddCartItemRequest request = new AddCartItemRequest();
        request.setProductId("abcProduct");
        request.setQuantity(3);

        //item to be saved and returned as response
        CartItem savedItem = new CartItem();
        savedItem.setProductId("abcProduct");
        savedItem.setQuantity(3);

        when(repository.save(ArgumentMatchers.any(CartItem.class))).thenReturn(savedItem);

        //execution
        CartItemResponse response = service.addToCart(request);

        //verification
        assertEquals("abcProduct",response.getProductId());
        assertEquals(3,response.getQuantity());
        verify(repository, times(1)).save(any(CartItem.class));
    }

    @Test
    void updateQuantityTest(){
        //Arrangement
        CartItem exisitngItem = new CartItem("pqrProduct",5);
        exisitngItem.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(exisitngItem));
        when(repository.save(any(CartItem.class))).thenReturn(exisitngItem);

        AddCartItemRequest request = new AddCartItemRequest();
        request.setProductId("pqrProduct");
        request.setQuantity(10);

        CartItemResponse response = service.updateCartItem(1L, request);
        //verification
        assertEquals("pqrProduct", response.getProductId());
        assertEquals(10, response.getQuantity());
        verify(repository).save(any(CartItem.class));
    }

    @Test
    void deleteCartItemTest(){
        CartItem item = new CartItem("xyzProduct",20);
        item.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(item));
        service.removeFromCart(item.getId());
        verify(repository).delete(item);
    }
}
