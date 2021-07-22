package com.aem.aemfirst.core.myservlets;

import java.io.IOException;
import java.sql.Connection;

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

import com.aem.aemfirst.core.dbutils.DbUtil;
//import com.aem.aemfirst.core.myinterface.MyInterface;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=My database Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/bin/dbservlet"
})

public class DbConServlet extends SlingAllMethodsServlet {

	protected static final Logger log = LoggerFactory.getLogger(DbConServlet.class);
	Connection	con=null;
	@Reference
	DbUtil ob;
	
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
			con = ob.getDatabaseConnection("mysource");
				log.info("Im from Db connection servlet==="+con);
				response.getWriter().write("Iam from DbConServlet, please check your logger file");
	//	super.doGet(request, response);
	}
}
