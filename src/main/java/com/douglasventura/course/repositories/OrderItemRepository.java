package com.douglasventura.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglasventura.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
