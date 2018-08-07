package com.cch.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cch.dto.Account;
import com.cch.dto.Application;

@Path("/netbanking")
public class NetBanking {
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Account openAccount(Application application)
	{
		
		Account account=new Account();
		account.setAccountantName(application.getAccountantName());
		account.setAccountNo(application.getMobileNo());
		account.setAddressLine1(application.getAddressLine1());
		account.setCity(application.getCity());
		account.setCountry(application.getCountry());
		account.setEmail(application.getEmail());
		account.setMobileNo(application.getMobileNo());
		
		return account;
		
		
	}

}
