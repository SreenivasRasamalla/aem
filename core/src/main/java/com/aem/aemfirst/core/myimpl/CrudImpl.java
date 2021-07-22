package com.aem.aemfirst.core.myimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.aemfirst.core.bean.StudentDetails;
import com.aem.aemfirst.core.dbutils.CrudDbUtil;
import com.aem.aemfirst.core.myinterface.CrudInt;


@Component(service=CrudInt.class, immediate=true)
public class CrudImpl implements CrudInt {
	
	protected static final Logger log = LoggerFactory.getLogger(CrudImpl.class);
	
	@Reference
	CrudDbUtil db;
		
	@Override
	public boolean addStudent(String stdId, String stdName, String stdDept, String stdAddress) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;
		
		String sql = "INSERT INTO student(stdId, stdName, stdDept, stdAddress) VALUES (?,?,?,?)";
		
		try {
			
			con = db.getDatabaseConnection("mysource");
			//log.info("addStudent method called successfully" + con);

			ps = con.prepareStatement(sql);
		/*	ps.setString(1,bean.getStdId());
			ps.setString(2,bean.getStdName());
			ps.setString(3,bean.getStdDept());
			ps.setString(4,bean.getStdAddress());*/
			
			ps.setString(1,stdId);
			ps.setString(2,stdName);
			ps.setString(3,stdDept);
			ps.setString(4,stdAddress);
			
			int i = ps.executeUpdate();				// using .executeUpdate method to update the data or to make any changes in the database
			if (i==1) {
				flag = true;		//true; when data retrieves
				log.info("success");
				} else {
					flag = false;
					log.info("failed");
					}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return flag;
	}

	/*@Override
	public boolean StudentDetailsinfo(StudentDetails bnclass) {
		// TODO Auto-generated method stub
		Connection con = null;
		boolean flag = false;
		
		//String sql = "INSERT INTO student (stdId, stdName, stdDept, stdAddress) values (?,?,?,?)";
		String sql = "insert into student values(?,?,?,?)";
		try {
			con = db.getDatabaseConnection("mysource");
			log.info("addStudent method called successfully" + con);

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,bnclass.getStdId());
			ps.setString(2,bnclass.getStdName());
			ps.setString(3,bnclass.getStdDept());
			ps.setString(4,bnclass.getStdAddress());
			
			ps.setString(1,stdId);
			ps.setString(2,stdName);
			ps.setString(3,stdDept);
			ps.setString(4,stdAddress);
			int i = ps.executeUpdate();				// using .executeUpdate method to update the data or to make any changes in the database
			if (i==1) {
				flag = true;		//true; when data retrieves
				log.info("success");
				} else {
					flag = false;
					log.info("failed");
					}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		log.info("----Out of Logic, Please check your Implementation Class");
		return flag;
	}*/

	
	


}
