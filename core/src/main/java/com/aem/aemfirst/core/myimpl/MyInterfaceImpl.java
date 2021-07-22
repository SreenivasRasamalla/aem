package com.aem.aemfirst.core.myimpl;

import java.sql.Connection;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.aem.aemfirst.core.myinterface.MyInterface;
import com.day.commons.datasource.poolservice.DataSourcePool;
		
		//the below function is called as OSGI service
@Component(service=MyInterface.class, immediate=true)


public class MyInterfaceImpl implements MyInterface{

	protected static final Logger log = LoggerFactory.getLogger(MyInterfaceImpl.class);
	@Reference
	private DataSourcePool dsService;			//DataSourcePool is a predefined Osgi service
	
	Connection con = null;
	
	@Override
	public boolean addDetail(String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		
		log.info("firstname========"+firstName);
		log.info("lastName========"+lastName);
		log.info("email========"+email);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
