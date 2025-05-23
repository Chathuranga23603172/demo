package UserPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class UserController {
	
	private static boolean isSuccess;
	private static Connection con =null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
public static boolean insertdata(String name, String gmail, String password, String phone) {
		
		boolean isSuccess = false;
		try {
			
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String  sql = "insert into user values(0,'"+name+"','"+gmail+"','"+password+"','"+phone+"')";
			int rs = stmt.executeUpdate(sql);
			if(rs>0) {
				isSuccess = true;
			}
			
			else {
				isSuccess = false;
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return isSuccess;
	}

//Login Validate
public static List<UserModel> loginvalidate(String name,String password){
	
	ArrayList<UserModel> user = new ArrayList<>();
	try {
		con = DBConnection.getConnection();
		stmt = con.createStatement();
		
		String sql = "select * from user where name='"+name+"' and password='"+password+"'";
		
		 rs= stmt.executeQuery(sql);
		
		if(rs.next()) {
			int id = rs.getInt(1);
			String uname = rs.getString(2);
			String gmail = rs.getString(3);
			String pass = rs.getString(4);
			String phone = rs.getString(5);
			
			UserModel u = new UserModel(id,uname,gmail,pass,phone);
			
			user.add(u);
		}
		
	}catch(Exception e) {
		 e.printStackTrace();
	}
	return user;
  }

   public static List<UserModel> userProfile(String Id){
	   int convertID = Integer.parseInt(Id);
	   
	   ArrayList<UserModel> user = new ArrayList<>();
	   
	   try {
		   con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql ="select * from user where id='"+convertID+"'";
			
			 rs= stmt.executeQuery(sql);
				
				if(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String gmail = rs.getString(3);
					String password = rs.getString(4);
					String phone = rs.getString(5);
					
					UserModel u = new UserModel(id,name,gmail,password,phone);
					
					user.add(u);
				}
				
		   
	   }catch(Exception e) {
		   
		   e.printStackTrace();
	   }
	   
	   return user;
   }
    //user data update
   public static boolean updateProfile(String id,String name,String gmail,String password,String phone) {
		
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			String sql ="update user set name='"+name+"',gmail='"+gmail+"',password='"+password+"',phone='"+phone+"'"
					+ "where id='"+id+"'" ;
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			
			else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
   
   public static List<UserModel> getAllUser(String Id){
		ArrayList<UserModel> user = new ArrayList<>();
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			String sql="select * from user ";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String gmail = rs.getString(3);
				String password = rs.getString(4);
				String phone = rs.getString(5);
				
				
				UserModel u = new UserModel(id,name,gmail,password,phone);
				user.add(u);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
   
   public static boolean deleteAccount(String id) {
		
		int convID = Integer.parseInt(id);
		
		try {
			
			 
			//DBConnection
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			String sql = "delete from user where id='"+convID+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			
			else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		return isSuccess;
	}
   public static List<UserModel> getAlluser(){
		ArrayList<UserModel> user = new ArrayList<>();
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			String sql="select * from user ";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String gmail = rs.getString(3);
				String password = rs.getString(4);
				String phone = rs.getString(5);
				
				
			UserModel sta = new UserModel(id,name,gmail,password,phone);
				user.add(sta);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
   public static boolean AdminupdateProfile(String id,String name,String gmail,String password,String phone) {
		
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			String sql ="update user set name='"+name+"',gmail='"+gmail+"',password='"+password+"',phone='"+phone+"'"
					+ "where id='"+id+"'" ;
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			
			else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
  
}
