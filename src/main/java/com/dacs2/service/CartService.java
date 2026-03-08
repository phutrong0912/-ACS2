package com.dacs2.service;

import com.dacs2.model.Cart;

import java.util.List;

public interface CartService {

    Cart saveCart(Integer productId, Integer userId);

    List<Cart> getCartByUser(Integer userId);

    Integer getCountCart(Integer userId);

    Boolean updateQuantity(Integer id, Integer quantity);

    Boolean deleteCart(Integer id);

    Double getTotalPrice(Integer userId);

    Boolean clearCartByUserId(Integer userId);

}
