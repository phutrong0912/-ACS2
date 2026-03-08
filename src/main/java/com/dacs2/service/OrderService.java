package com.dacs2.service;

import com.dacs2.model.Orders;
import com.dacs2.model.OrderRequest;
import com.dacs2.model.ProductOrder;
import jakarta.mail.MessagingException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public interface OrderService {

    Orders createOrder(Integer userId, OrderRequest orderRequest) throws UnsupportedEncodingException, MessagingException;

    void saveOrder(Orders order) throws MessagingException, UnsupportedEncodingException;

    List<Orders> getOrdersByUserId(Integer userId);

    Orders updateOrderStatus(Integer id, String status) throws MessagingException, UnsupportedEncodingException;

    Page<Orders> getAllOrdersPagination(Integer pageNumber, Integer pageSize);

    Page<Orders> searchOrderByOrderIdPagination(Integer pageNumber, Integer pageSize, String orderId);

    Boolean deleteOrder(Orders order);

    List<ProductOrder> getProductOrdersByOrderId(String orderId);

    Orders getOrderByOrderId(String orderId);

    ProductOrder ratingProduct(Integer userId, Integer productOrderId, String textComment, Integer rating);

}
