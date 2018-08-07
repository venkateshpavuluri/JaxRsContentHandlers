package com.cch.writers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.cch.dto.Account;
@Provider
@Produces(MediaType.APPLICATION_XML)
public class JaxbMessageBodyWriter implements MessageBodyWriter {

	@Override
	public boolean isWriteable(Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		if(type.isAnnotationPresent(Account.class))
		{
			return true;
		}
		return false;
	}

	@Override
	public void writeTo(Object t, Class type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Writer Object");
			JAXBContext context=JAXBContext.newInstance(Account.class);
			Marshaller marshaller=context.createMarshaller();
			marshaller.marshal(Account.class, entityStream);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
