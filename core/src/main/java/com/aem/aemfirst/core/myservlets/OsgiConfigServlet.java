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

import com.aem.aemfirst.core.myinterface.CustomOsgiReadService;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Employee Register Node Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
         "sling.servlet.paths=" + "/bin/osgiconfigservlet"            
})
public class OsgiConfigServlet extends SlingAllMethodsServlet {
	
	@Reference
	CustomOsgiReadService intface;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ser = intface.readOsgiConfiguration();
		
		response.getWriter().print(ser);
		//super.doGet(request, response);
	}

}
