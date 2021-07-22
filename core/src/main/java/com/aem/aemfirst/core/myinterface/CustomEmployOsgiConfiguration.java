package com.aem.aemfirst.core.myinterface;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "EmployDetails Configuration", description = "This configuration Contains EmployDetails")
public @interface CustomEmployOsgiConfiguration {

	@AttributeDefinition(name = "empId", description = "employid", type = AttributeType.STRING)
	public String getEmpId();
	
	@AttributeDefinition(name = "empName", description = "employname")
	public String getEmpName();

	@AttributeDefinition(name = "empSalary", description = "EmploySalary")
	public String getEmpSalary();

}
