package com.example.ebearrestapi.repository;

import com.example.ebearrestapi.entity.OrderPaymentEntity;
import com.example.ebearrestapi.etc.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderPaymentRepository extends JpaRepository<OrderPaymentEntity, Long> {
    List<OrderPaymentEntity> findAllByOrderStatusAndCreatedAtBefore(OrderStatus status, LocalDateTime before);
}
