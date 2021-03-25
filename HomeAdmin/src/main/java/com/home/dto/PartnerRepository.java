package com.home.dto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.entity.Partner;
import com.home.entity.User;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long>{

}