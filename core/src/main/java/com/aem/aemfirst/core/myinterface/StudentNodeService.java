package com.aem.aemfirst.core.myinterface;



import java.util.List;

import org.json.simple.JSONObject;

//json simple import

import com.aem.aemfirst.core.bean.StudentNodeBean;
import com.aem.aemfirst.core.bean.Studentlist;

public interface StudentNodeService {

	public StudentNodeBean studentsData();
	//public JSONObject studentsData();
	public List<Studentlist> getStudentData();
	
	
}
