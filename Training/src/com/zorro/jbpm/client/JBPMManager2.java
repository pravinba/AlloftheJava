package com.zorro.jbpm.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.TaskSummary;
import org.kie.remote.client.api.RemoteRuntimeEngineFactory;




public class JBPMManager2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Creating runtime engine for process instantiation
		
		String workFlowProcessName="Hello.HelloProcess";
		//String workFlowProcessName="SampleProject.SampleHello";
		
		RuntimeEngine engine = getJbpmRuntimeEngine();
		KieSession session = engine.getKieSession();
		TaskService taskService = engine.getTaskService();
		
		Map<String,Object> parameter = new HashMap<String,Object>();
			
		parameter.put("in_emp_leave_status","Approved");
		
	
		// starting the task
		
		List<Status> status = getTaskStatusList();
		
		 List<TaskSummary> summary = taskService.
				 getTasksByStatusByProcessInstanceId(new Long(2), status, "Manager2");
		 
		
		 for(TaskSummary task:summary){
			 
			 System.out.println("The Task instance Id-->" + task.getId());
			 System.out.println("The process instance -->" + task.getProcessId());
			 System.out.println("The process Name -->" + task.getName());
			 System.out.println("The getActualOwnerId -->" + task.getActualOwnerId());
			 
			 
			 // start task 
			 
			 if(task.getStatus().equals(Status.Reserved)){
			   System.out.println("Starting Task");
			   taskService.start(task.getId(), "Manager2");
			 }
			 
			 // complete task			 
			 
			 if(task.getStatus().equals(Status.InProgress)){
				   System.out.println("Completing Task");
				   taskService.complete(task.getId(), "Manager2", parameter);
			 }
		 }
	
		
		//System.out.println("The process instance -->" + summary);
		//System.out.println("The process ID -->" + processInstance.getProcessId());
		//System.out.println("The process Name -->" + processInstance.getProcessName());
		
		
		

	}
	
	
	public static List<Status> getTaskStatusList(){
		
		   List<Status> status = new ArrayList<Status>(); 
		   status.add(Status.Reserved);
		   status.add(Status.Ready);
		   status.add(Status.InProgress);		
		return status;	
	}
	
	
	public static RuntimeEngine getJbpmRuntimeEngine(){	
		
		RuntimeEngine runtimeEngine=null;
	    String jbpmRestURL="http://localhost:8080/business-central";
	    String jbpmUserName="Manager2";
	    String jbpmPassWord="password-1";	
	    String generalInfoDeploymentId="Cts:Hello:1.0";
	    
	
	System.out.println("Deployment id :: "+generalInfoDeploymentId);
	
/*	System.out.println("jbpmUserName id :: "+jbpmUserName);
	System.out.println("jbpmPassWord id :: "+jbpmPassWord);*/
	
	System.out.println("jbpmRestURL id :: "+jbpmRestURL);
	
		
	 try {
			URL appUrl = new URL(jbpmRestURL);
			  runtimeEngine
	            = RemoteRuntimeEngineFactory.newRestBuilder().disableTaskSecurity()
	            .addUrl(appUrl)
	            .addUserName(jbpmUserName)
	            .addPassword(jbpmPassWord)
	            .addDeploymentId(generalInfoDeploymentId)
	            .build();
		} 

        catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 return runtimeEngine;
	}

}
