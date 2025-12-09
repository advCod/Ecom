package com.example.Ecom.repository;

import com.example.Ecom.model.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    // TODO: CRUD

}
