package com.jaxrs.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/billing")
public class BillingService {

	@GET
	@Produces(MediaType.MULTIPART_FORM_DATA)
	@Path("/productInfo/{billNo}")
	public File getProductIno(@PathParam("billNo") String billNo) {

		return new File("C:\\Users\\welcome\\Desktop\\mysqlcredentials.txt");

	}
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/inputst")
  public String gateWay(InputStream in)throws IOException {
      StringBuffer buffer=new StringBuffer();
      int ch;
      while ((ch = in.read()) != -1){
	
    	  buffer.append((char)ch);
	}
		return buffer.toString();
	}
  
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/bytes")
  public String readBytes(byte[] in)throws IOException {
      StringBuffer buffer=new StringBuffer();
      for(byte b:in) {
    	  buffer.append((char)b);
      }
		return buffer.toString();
	}
  
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/reader")
  public String readBytes(Reader reader)throws IOException {
      StringBuffer buffer=new StringBuffer();
      int data ; 
      while ((data=reader.read()) != -1) {  
    	  buffer.append((char)data);
         
      }  
		return buffer.toString();
	}

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Path("/file")
  public String readFileData(File file)throws IOException {
      StringBuffer buffer=new StringBuffer();
      BufferedReader br = new BufferedReader(new FileReader(file));
      
      String st;
      while ((st = br.readLine()) != null) {
        //System.out.println(st);
    	  buffer.append(st);
      }
		return buffer.toString();
	}


}
