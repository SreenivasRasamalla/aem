package com.aem.aemfirst.core.mymodel;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.aem.aemfirst.core.bean.StudentNodeBean;
import com.aem.aemfirst.core.bean.Studentlist;
import com.aem.aemfirst.core.myinterface.StudentNodeService;

@Model(adaptables=Resource.class)
public class StudentNodeModel {

	@OSGiService
	private StudentNodeService std;
	
	private String studid;
	private String studname;
	private String list;
		
	@PostConstruct
     protected void init(){
		
	StudentNodeBean nodbean = std.studentsData();
	
	studid = "\tStudent Id is\n" + nodbean.getStudentId() +" and ";
	studname = "\tStudent name is\n"+ nodbean.getStudentName();
	
	/*List<Studentlist> list = std.getStudentData();
	
	list.addAll(list);*/
	
	  }


	public String getStudid() {
		return studid;
	}

	public String getStudname() {
		return studname;
	}
	/*public String getList() {
		return list;
	}*/


		
	}
