package com.wipro.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.restapi.model.CustomerDetails;

public interface CustomerDetailsReopsitory extends JpaRepository<CustomerDetails, Long>{

}
