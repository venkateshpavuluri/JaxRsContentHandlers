package com.response.handlers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;

import com.cch.dto.Account;
import com.cch.dto.Application;
import com.sun.research.ws.wadl.Response;
@Path("/openAccount")
public class NetBankingService {
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public javax.ws.rs.core.Response openAccount(Application application)
	{
		
		Account account=new Account();
		account.setAccountantName(application.getAccountantName());
		account.setAccountNo(application.getMobileNo());
		account.setAddressLine1(application.getAddressLine1());
		account.setCity(application.getCity());
		account.setCountry(application.getCountry());
		account.setEmail(application.getEmail());
		account.setMobileNo(application.getMobileNo());
		
		return javax.ws.rs.core.Response.accepted().header("accountno", "90304567").cookie(new NewCookie("site","web")).entity(account).build();
		
		
	}

}
