package com.harsha.ordermanagement.javadelegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("calculatePaymentDelegate")
public class CalculatePaymentDelegate implements JavaDelegate {

	private static Logger log = LoggerFactory.getLogger(CalculatePaymentDelegate.class);

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.info("CalculatePaymentDelegate Started");
		long offerPrice;
		if (execution.hasVariable("regularOffer")) {
			offerPrice = (long) execution.getVariable("regularOffer");
		} else if (execution.hasVariable("venderOffer") && execution.hasVariable("specialProOffer")) {
			offerPrice = (long) execution.getVariable("venderOffer") + (long) execution.getVariable("specialProOffer");
		} else {
			offerPrice = 0;
		}
		long totalPrice = 200 - offerPrice;
		execution.setVariable("totalPrice", totalPrice);
		log.info("total price:"+totalPrice);
	}

}
