package com.harsha.ordermanagement.customerdata.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harsha.ordermanagement.model.CustomerData;

@Repository
public interface CustomerDataRepository extends JpaRepository<CustomerData,UUID> {

}
