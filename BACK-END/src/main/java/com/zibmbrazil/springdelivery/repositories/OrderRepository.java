package com.zibmbrazil.springdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zibmbrazil.springdelivery.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
