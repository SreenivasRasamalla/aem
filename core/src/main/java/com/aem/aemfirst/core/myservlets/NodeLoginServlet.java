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
        Constants.SERVICE_DESCRIPTION + "=Employee Login Node Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
         "sling.servlet.paths=" + "/bin/nodeloginservlet"            
})
public class NodeLoginServlet extends SlingAllMethodsServlet{
	private static final Logger log = LoggerFactory.getLogger(NodeRegServlet.class);
	@Reference
	private NodeInt nodintfc;
	
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		String uname = request.getParameter("UserName");
		String psw = request.getParameter("Password");
		log.info("username is "+uname+"password is "+psw);
		try {
			
		boolean b = nodintfc.loginEmployee(uname, psw);
		log.info("logged in by "+b);
		
		response.getWriter().print("EmployNodeLogin  servlet called with****");
		
		if (b) {
			log.info("Logged in Successfully.."+b);
			response.getWriter().print("Logged in Successfully.."+b);
		} else {
			log.info("Wrong Credentials..!!");
			response.getWriter().print("Wrong Credentials");
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//super.doPost(request, response);
	}

}
