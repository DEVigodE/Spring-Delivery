package com.zibmbrazil.springdelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zibmbrazil.springdelivery.dto.OrderDTO;
import com.zibmbrazil.springdelivery.dto.ProductDTO;
import com.zibmbrazil.springdelivery.entities.Order;
import com.zibmbrazil.springdelivery.entities.Product;
import com.zibmbrazil.springdelivery.enums.OrderStatus;
import com.zibmbrazil.springdelivery.repositories.OrderRepository;
import com.zibmbrazil.springdelivery.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());

	}

	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(),
				OrderStatus.PENDIND);
		for (ProductDTO _productDto : dto.getProducts()) {
			Product _product = productRepository.getOne(_productDto.getId());
			order.getProducts().add(_product);
		}
		order = repository.save(order);

		return new OrderDTO(order);
	}

	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repository.save(order);
		return new OrderDTO(order);
	}

}
