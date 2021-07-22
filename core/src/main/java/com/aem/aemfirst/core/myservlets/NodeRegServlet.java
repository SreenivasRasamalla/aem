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

import com.aem.aemfirst.core.myinterface.NodeInt;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Employee Register Node Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
         "sling.servlet.paths=" + "/bin/empnoderegservlet"            
})

public class NodeRegServlet extends SlingAllMethodsServlet {

	private static final Logger log = LoggerFactory.getLogger(NodeRegServlet.class);
	@Reference
	private NodeInt nodint;
	
/*	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String uname = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		
		nodint.registerEmployDetails(fname,lname,uname,pwd);
		
		log.info("Registration Done="+nodint);
		log.info("Form values--------"+fname+lname+uname+pwd);
		response.getWriter().print("EmployRegistration doGet servlet called, please check if node is created.");
		
		//super.doGet(request, response);
	}*/
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(request, response);
		
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String uname = request.getParameter("userName");
		String pwd	 = request.getParameter("pwd");
		
		nodint.registerEmployDetails(fname,lname,uname,pwd);
		
		log.info("Registration Done="+nodint);
		
		response.getWriter().print("EmployRegistration doPost servlet called, please check if node is created.");
			
	}
}
