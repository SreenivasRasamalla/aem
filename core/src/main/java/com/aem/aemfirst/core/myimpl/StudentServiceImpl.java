package com.aem.aemfirst.core.myimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.json.simple.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.aemfirst.core.bean.StudentNodeBean;
import com.aem.aemfirst.core.bean.Studentlist;
import com.aem.aemfirst.core.myinterface.StudentNodeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(service=StudentNodeService.class, immediate=true)
public class StudentServiceImpl implements StudentNodeService {
	
	private static Logger log = LoggerFactory.getLogger(NodeImpl.class);
	
	@Reference
	private ResourceResolverFactory resolverFactory;
	Session session;
	ResourceResolver resolver = null;
	Resource resource;
	String resourcePath = "/content/aemfirst/en/jcr:content/student";
	
	//FIRST STEP : ACCESSING SYSTEM USER
	private Map<String, Object> getSubServiceMap(){
		log.info("****Inside getSubServiceMenu*****");
		Map<String, Object> serviceMap = null;
		
		try {
			serviceMap = new HashMap<String, Object>();
			serviceMap.put(ResourceResolverFactory.SUBSERVICE, "sreesystemuser");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			log.info("error*****"+ errors.toString());
		}
		
			log.info("****getSubServiceMenu method end****");
		return serviceMap;
		
	}
		
	@Override
	public StudentNodeBean studentsData() {
		// TODO Auto-generated method stub
		StudentNodeBean bean = null;
		
		
		try {
			resolver = resolverFactory.getServiceResourceResolver(getSubServiceMap());
			session = resolver.adaptTo(Session.class);
			log.info("Session*****"+session);
			resource = resolver.getResource(resourcePath);
			
			Node node = resource.adaptTo(Node.class);		//converting resource object into node
			log.info("Node****"+node);
			String stdId = node.getProperty("StudentId").getValue().getString();
			String stdName = node.getProperty("StudentName").getValue().getString();
			
			bean = new StudentNodeBean();		// Creating object of StudentNodeBean
			bean.setStudentId(stdId);		//setting to bean
			bean.setStudentName(stdName);
			log.info("Student Id====="+stdId+"Student Name====="+stdName);
			
			// Creating Object of ObjectMapper define in Jackson API  
        	ObjectMapper Obj = new ObjectMapper();  
            // Converting the Java object into a JSON string  
            String jsonStr = Obj.writeValueAsString(bean);  
            // Displaying Java object into a JSON string  
            log.info("json==="+jsonStr);
			       		 
			        		 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bean;
	}

	
			//***BY USING ARRAY LIST***
	@Override
	public List<Studentlist> getStudentData() {
		// TODO Auto-generated method stub
		ArrayList<Studentlist> obj = new ArrayList<>();
		obj.add(null);
		//need to implement
		return null;
	}

}
