package com.aem.aemfirst.core.dbutils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.commons.datasource.poolservice.DataSourcePool;


@Component(service=DbUtil.class, immediate=true)
public class DbUtil  {
	protected static final Logger log = LoggerFactory.getLogger(DbUtil.class);
	@Reference
	DataSourcePool dsService;			//DataSourcePool is a predefined Osgi service

	Connection con = null;
		
	public Connection getDatabaseConnection(String data){
		
		
		try {
			log.info("Initiating Connection");
			DataSource ds = (DataSource) dsService.getDataSource(data);		//drivermanager.getclass format(from adv java)
			con = ds.getConnection();
			log.info("Connection established successfully from dbutil===="+con);
			
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			log.info(sw.toString());
			// TODO: handle exception
		}
		
		
		return con;
		
	}
	
}
