package com.javatpoint.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import Dao.*;
import Dao.DbConnection;
import Dao.SignUpHandler;

public class CommentService {
	@Path("/CommentService")
	public class SignUpService {
		
	@POST
	 @Path("/usercomments")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public String login(@FormParam("uname") String username,
	 @FormParam("comments") String comments) {
		boolean flag=false;
		try {
		String[] data= {username,comments};
		DbConnection dbConnect=new DbConnection();
		CommentHandler commentHandle=new CommentHandler();
		flag= commentHandle.InsercommentToDatabase(dbConnect.getConnection(), data, username);
		System.out.println(flag);

		} catch(Exception e) {
			
			System.out.println("Sign Up Service Error found : "+e.getMessage());
			
			}
		if (flag) {
			return "Comment Successful";
		} else {
			return "SignUp Failed. Please try again.";
		}
		}
	}
}
