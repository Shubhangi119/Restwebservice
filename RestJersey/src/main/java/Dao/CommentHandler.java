package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CommentHandler {

	public boolean InsercommentToDatabase(Connection dbConnect, String[] data, String username ) throws Exception {

		try {
			
			PreparedStatement ps = dbConnect.prepareStatement("INSERT INTO usercomments values ('"
		+data[0]+"', '"+data[1]+"');");

			
			ps.executeUpdate();
			
			PreparedStatement ds=dbConnect.prepareStatement("select comments from usercomments where uname='"+username+"';"); 
			ps.executeUpdate();
			
			} catch (Exception e) {

				System.out.println("Sign Up Handler Error found : "+e.getMessage());
				throw e;
			}
		System.out.println("Handler successfull");
		return true;
		}
	}


