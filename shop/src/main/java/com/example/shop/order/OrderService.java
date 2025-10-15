package com.example.shop.order;

import com.example.shop.order.dto.orderCreateRequest;
import com.example.shop.order.dto.orderUpdateRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    //@Transactional
    public Long createOrder(OrderCreateRequest request) {
        order existingOrder = orderRepository.findByLoginId(request.getLoginId());
        if (existingOrder != null) {
            throw new RuntimeException("이미 존재하는 주문입니다 : " + request.getLoginId());
        }

        Order order = new Order(
                request.getLoginId(),
                request.getPassword(),
                request.getPhoneNumber(),
                request.getAddress()
        );

        orderRepository.save(order);

        return order.getId();
    }

    //@Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //@Transactional(readOnly = true)
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);

        if(order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }

        return order;
    }

    //@Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }

        //Repository를 통해 삭제
        orderRepository.deleteById(id);
    }
}
