package com.aem.aemfirst.core.myservlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.sql.rowset.serial.SerialException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.aemfirst.core.myimpl.MyInterfaceImpl;
import com.aem.aemfirst.core.myinterface.MyInterface;


@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=My first Sling Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
        "sling.servlet.paths=" + "/bin/myslingservlet"
})

/*public class MySlingServlet extends SlingSafeMethodsServlet {
	
	private static final long serialVersionUid = 1L;
	protected static final Logger log = LoggerFactory.getLogger(MySlingServlet.class);	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().write("Iam from my first do get sling servlet");
		//super.doGet(request, response);
	}
}*/

public class MySlingServlet extends SlingAllMethodsServlet{
	
	
	@Reference 
	MyInterface obj;     // we are using this @Reference annotation here instead of creating object like in java [ MyInterface obj = new MyInterfaceImpl(); ]
	
	protected static final Logger log = LoggerFactory.getLogger(MySlingServlet.class);
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		
		// TODO Auto-generated method stub
		response.getWriter().write("Iam from dopost sling servlet");
		//super.doPost(request, response);
		
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String email = request.getParameter("email");
			//object creation is done above with @Reference annotation
		obj.addDetail(fName, lName, email);
	log.info("My sling servlet from do post method is called");	
	}
}
