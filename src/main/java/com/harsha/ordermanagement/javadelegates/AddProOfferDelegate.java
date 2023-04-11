package com.harsha.ordermanagement.javadelegates;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.harsha.ordermanagement.model.CustomerData;

@Component("addProOfferDelegate")
public class AddProOfferDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		try {
			CustomerData customerData = (CustomerData) execution.getVariable("customerData");
			String proOffer = customerData.getProOffer();
			if (proOffer.isEmpty())
				throw new BpmnError("ProOfferNotFound", "vendor offer not found");
			else
				execution.setVariable("venderOffer", 50);
		} catch (BpmnError e) {
			execution.setVariable("errorMessage", "vendor offer not found");
			throw e;
		} catch (Exception e) {
			execution.setVariable("errorMessage", "Customer Data not found");
			throw new BpmnError("errorCaught","Customer Data not found");
		}

	}

}
