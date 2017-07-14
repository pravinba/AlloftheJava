package com.zorro.handler;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

public class StockCheckHandler implements WorkItemHandler {

	@Override
	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub
		
		System.out.println("abortWorkItem --> called ");
		arg1.abortWorkItem(arg0.getId());
	}

	@Override
	public void executeWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub
		
		System.out.println("executeWorkItem --> called ");		
		String productName = (String)arg0.getParameter("productName");
		String quantity = (String)arg0.getParameter("quantity");
		
		System.out.println("Product name  --> "+productName);
		System.out.println("Quantity  --> "+quantity);
		arg1.completeWorkItem(arg0.getId(), arg0.getParameters());

	}

}
