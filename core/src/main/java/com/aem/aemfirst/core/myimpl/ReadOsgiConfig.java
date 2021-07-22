package com.aem.aemfirst.core.myimpl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.aem.aemfirst.core.myinterface.CustomEmployOsgiConfiguration;
import com.aem.aemfirst.core.myinterface.CustomOsgiReadService;

@Component(service=CustomOsgiReadService.class, immediate = true)
@Designate(ocd=CustomEmployOsgiConfiguration.class)
public class ReadOsgiConfig implements CustomOsgiReadService{

private CustomEmployOsgiConfiguration configuration;
	
	@Activate
	protected void activate(CustomEmployOsgiConfiguration configuration){
	this.configuration = configuration;
	}
	@Override
	public String readOsgiConfiguration() {
		// TODO Auto-generated method stub
		String empId = configuration.getEmpId();
		String empName = configuration.getEmpName();
		String empSalary = configuration.getEmpSalary();
		
		return "Employee Id---"+empId+	"\n"+	"Employee Name---"+empName+	"\n"+	"Employee Salary---"+empSalary;
	}

}
