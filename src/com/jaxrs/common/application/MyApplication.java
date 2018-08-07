package com.jaxrs.common.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.jaxrs.resources.BillingService;
@ApplicationPath("/api")
public class MyApplication extends Application {
	/*private Set<Object> singletons;
	private Set<Class<?>> classes;
	public MyApplication()
	{
		singletons=new HashSet<>();
		singletons.add(new BillingService());
		classes=new HashSet<>();
		
	}
	public Set<Object> getSingletons()
	{
	 return singletons;	
	}

	public Set<Class<?>> getClasses()
	{
		return classes;
	}*/
}
