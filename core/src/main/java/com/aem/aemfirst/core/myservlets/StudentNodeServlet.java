package com.aem.aemfirst.core.myservlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.aemfirst.core.bean.StudentNodeBean;
import com.aem.aemfirst.core.myinterface.StudentNodeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Student Node Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
         "sling.servlet.paths=" + "/bin/studentnodeservlet"            
})
public class StudentNodeServlet extends SlingAllMethodsServlet{
	
	private static Logger log = LoggerFactory.getLogger(StudentNodeServlet.class);
	
	@Reference
	StudentNodeService stdnod;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			log.info("****inside servlet****");
			
			StudentNodeBean bean = stdnod.studentsData();
					
			String stdid = bean.getStudentId();		//getting from bean
			String stdname = bean.getStudentName();
			//response.getWriter().print("Student Id====="+stdid+"Student Name====="+stdname);
			
															// Creating Object of ObjectMapper define in Jackson API  
        	ObjectMapper Obj = new ObjectMapper();  
            												// Converting the Java object into a JSON string  
            String jsonStr = Obj.writeValueAsString(bean);  
            												// Displaying Java object into a JSON string  
            log.info("json==="+jsonStr);
           
            response.getWriter().print(jsonStr);
            
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//super.doGet(request, response);
	}

}
