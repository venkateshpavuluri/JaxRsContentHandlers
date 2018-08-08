package com.cch.contextresolvers;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.cch.dto.Account;
import com.cch.dto.Application;
@Provider
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class JaxbContextResolver implements ContextResolver<JAXBContext> {

	@Override
	public JAXBContext getContext(Class type) {
		// TODO Auto-generated method stub
		System.out.println("Context resolver method");
		JAXBContext context=null;
		try {
			 context=JAXBContext.newInstance(Account.class,Application.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return context;
	}

}
