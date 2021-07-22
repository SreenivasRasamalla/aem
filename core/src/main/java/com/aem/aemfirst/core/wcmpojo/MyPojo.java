package com.aem.aemfirst.core.wcmpojo;

import com.adobe.cq.sightly.WCMUsePojo;

public class MyPojo extends WCMUsePojo {
	
	private String title;
	private String description;

	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		title = getProperties().get("title", "").toLowerCase();
		description = getProperties().get("description", "").toLowerCase();		
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	
	
}
