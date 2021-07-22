package com.aem.aemfirst.core.mymodel;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class)
public class MyFirstModel {

	
	@Inject
	private String title;
	
	@Inject 
	private String description;

	
	@PostConstruct
     protected void init(){
	
	  }
	
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
}
