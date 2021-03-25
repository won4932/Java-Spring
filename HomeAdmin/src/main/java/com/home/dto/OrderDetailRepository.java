package com.home.dto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.entity.OrderDetail;
import com.home.entity.User;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{

}
