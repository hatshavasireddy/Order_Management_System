package com.harsha.ordermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsha.ordermanagement.model.CustomerData;

@Service
public class OrderManagementService {

	private static Logger log = LoggerFactory.getLogger(OrderManagementService.class);

	@Autowired
	RuntimeService runtimeServices;
	
	@Autowired
	RepositoryService repositoryService;
	
	@Autowired
	TaskService taskService;

	public Object invokeCamundaFlow(CustomerData customerData) {

		log.info("Service method started");
		ProcessInstance pi = runtimeServices
				.startProcessInstanceByKey("orderManagement",
				customerData.getBussinessKey().toString(),
				Variables.putValue("customerData", customerData));
		log.info("process Started"+pi);
		return pi;
	}
	
	public List<String> getAllRunningProcessInstants(){
		log.info("getting ProcessInstances");

	        List<ProcessInstance> processInstances = runtimeServices
	        		.createProcessInstanceQuery()
	                .processDefinitionKey("orderManagement")
	                .active()
	                .list();
	        List<String> processInstanceIds = new ArrayList<String>();
	        for (ProcessInstance p : processInstances) {
	            processInstanceIds.add(String.valueOf(p));
	            log.info(String.valueOf(p));
	        }
		return processInstanceIds;
	}
	
	public Object getRunningProcessInstantWithBussinessKey(String businessKey) {

		log.info("Started");
		ProcessInstance pi = runtimeServices
				.createProcessInstanceQuery()
				.processDefinitionKey("orderManagement")
				.processInstanceBusinessKey(businessKey)
				.singleResult();
		log.info(pi.toString());
		return String.valueOf(pi);
	}
	
	public void deleteRunningProcessInstantWithProcessInstance() {

		log.info("Started");
		runtimeServices
				.deleteProcessInstance("10409d92-fe88-11ec-99c2-2e0da76b1f3e", "ntg");
				
	}

	public String cancelAllOrders() {
		runtimeServices.signalEventReceived("CancelAllOrders");
		return "Success";
	}

	public String cancelSingleOrder(String businessKey) {
		runtimeServices.createMessageCorrelation("CancelSingleOrder")
		.processInstanceBusinessKey(businessKey).correlateWithResult();
		return "Success";
	}

}
