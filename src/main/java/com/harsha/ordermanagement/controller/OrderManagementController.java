package com.harsha.ordermanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harsha.ordermanagement.customerdata.repository.CustomerDataRepository;
import com.harsha.ordermanagement.model.CustomerData;
import com.harsha.ordermanagement.service.OrderManagementService;

@RestController
public class OrderManagementController {
	
	private static Logger log = LoggerFactory.getLogger(OrderManagementController.class);

	@Autowired
	public OrderManagementService service;
	
	@Autowired
	public CustomerDataRepository repo;

	@PostMapping(value = "/Order", 
			produces = {"application/json"},
			consumes = { "application/json" })
	public Object userdetails(@RequestBody CustomerData customerData) {
		log.info("customerData "+customerData);
		repo.save(customerData);
		Object processInfo = service.invokeCamundaFlow(customerData);
		return processInfo;
	}
	
	@DeleteMapping(value = "/cancelAllOrders")
	public String cancelAllOrders() {
		return service.cancelAllOrders();
	}
	
	@DeleteMapping(value = "/cancelSingleOrder")
	public String cancelSingleOrder(@RequestParam("businessKey")String businessKey) {
		return service.cancelSingleOrder(businessKey);
	}
	
	@GetMapping(value = "/getAllRunningProcessInstance",
			produces= {"application/json"})
	public List<String> getAllRunningProcessInstants(){
		return service.getAllRunningProcessInstants();
	}
	
	@GetMapping(value = "/getProcessInstance",
			produces= {"application/json"})
	public Object getRunningProcessInstantWithBussinessKey(@RequestParam("businessKey")String businessKey){
			return service.getRunningProcessInstantWithBussinessKey(businessKey);
	}
	
	@DeleteMapping(value = "/deleteProcessInstance",
			produces= {"application/json"})
	public String deleteRunningProcessInstant(){
		service.deleteRunningProcessInstantWithProcessInstance();
		return "Success";
	}
}
