import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException ;
import java.sql.*;


public class Dbconn {
	
	ResultSet rs=null;
	String connString = "jdbc:mysql://db211it.cpzjbadhzyqb.us-east-1.rds.amazonaws.com/HarrisContactDb";
	String username = "admin";
	String password = "Orange12345";
	Connection con = null;
	
	public Dbconn() 
	{
		try {
			con = DriverManager.getConnection(connString, username, password);
			System.out.println("Connected");
		}
		catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Not Connected");}
		}
		
	public ResultSet GetAllPersonal()
	{
		
		String sql="{call selectALLPersonal()}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		
	}return rs;}
	
	
	public void UpdatePersonal(String Fname, String Lname,String Email,String Tel,String Address1,String Address2,String City,String PostCode,String id)
	{
		ResultSet rs=null;
		String sql="{call updatePersonal (?,?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			cst.setString(1,id);
			cst.setString(2, Fname);
			cst.setString(3, Lname);
			cst.setString(4, Email);
			cst.setString(5, Tel);
			cst.setString(6, Address1);
			cst.setString(7, Address2);
			cst.setString(8, City);
			cst.setString(9, PostCode);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			//to do auto- generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void AddPersonal(String Fname, String Lname,String Email,String Tel,String Address1,String Address2,String City,String PostCode)
	{
		String sql="{CALL insertPersonal(?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);			
			cst.setString(1, Fname);
			cst.setString(2, Lname);
			cst.setString(3, Email);
			cst.setString(4, Tel);
			cst.setString(5, Address1);
			cst.setString(6, Address2);
			cst.setString(7, City);
			cst.setString(8, PostCode);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			//to do auto- generated catch block
			e.printStackTrace();
		}
	}
			
	public void DeletePersonal(int id) {
		ResultSet rs = null;
		String sql = "{CALL deletePersonal(?)}";
		try {
			java.sql.CallableStatement cst = con.prepareCall(sql);
			cst.setInt(1, id);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	public ResultSet GetALLBusiness()
	{
	
		String sql="{call selectALLBusiness()}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return rs;
	
	}
	
	public void updateBusiness(String Fname, String Lname,String Email,String Tel,String Address1,String Address2,String City,String PostCode,String id)
	{
		ResultSet rs=null;
		String sql="{call updateBusiness (?,?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			cst.setString(1,id);
			cst.setString(2, Fname);
			cst.setString(3, Lname);
			cst.setString(4, Email);
			cst.setString(5, Tel);
			cst.setString(6, Address1);
			cst.setString(7, Address2);
			cst.setString(8, City);
			cst.setString(9, PostCode);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			//to do auto- generated catch block
			e.printStackTrace();
		}
	}
	
	public void AddBusiness(String Fname, String Lname,String Email,String Tel,String Address1,String Address2,String City,String PostCode)
	{
		String sql="{CALL insertBusiness(?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);			
			cst.setString(1, Fname);
			cst.setString(2, Lname);
			cst.setString(3, Email);
			cst.setString(4, Tel);
			cst.setString(5, Address1);
			cst.setString(6, Address2);
			cst.setString(7, City);
			cst.setString(8, PostCode);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			//to do auto- generated catch block
			e.printStackTrace();
		}
	}	
		
	public void DeleteBusiness(int id) {
		ResultSet rs = null;
		String sql = "{CALL deleteBusiness(?)}";
		try {
			java.sql.CallableStatement cst = con.prepareCall(sql);
			cst.setInt(1, id);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

			
			
		
		
	

		
