package com.cch.readers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import com.cch.dto.Account;
import com.cch.dto.Application;
@Provider
@Consumes(MediaType.APPLICATION_XML)
public class JaxbMessageBodyReader implements MessageBodyReader {
@Context
private Providers providers;
	@Override
	public boolean isReadable(Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		if(type.isAnnotationPresent(XmlRootElement.class))
		{
			return true;
		}
		return false;
	}

	@Override
	public Object readFrom(Class type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		
		System.out.println("Reader Object");
		try {
		//	JAXBContext context=JAXBContext.newInstance(Application.class);
			Unmarshaller unmarshaller=null;
			if(type.isAssignableFrom(Account.class)||type.isAssignableFrom(Application.class)) {
	           ContextResolver jcontectrel=providers.getContextResolver(JAXBContext.class, mediaType);
	           JAXBContext     context=(JAXBContext)jcontectrel.getContext(type);
			 unmarshaller=context.createUnmarshaller();
			}
		  return 	unmarshaller.unmarshal(entityStream);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			throw new WebApplicationException();
		}
		//return null;
	}

}
