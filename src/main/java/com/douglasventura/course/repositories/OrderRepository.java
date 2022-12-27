package com.douglasventura.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglasventura.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
