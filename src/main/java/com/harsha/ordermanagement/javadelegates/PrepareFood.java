package com.harsha.ordermanagement.javadelegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("prepareFood")
public class PrepareFood implements JavaDelegate {

	private static Logger log = LoggerFactory.getLogger(PrepareFood.class);
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		log.info("Food is being prepared, please sit back and relax");

	}

}
