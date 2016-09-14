package ssa;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class JdbcProject {
	
	static Connection myConn = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	
	public static void main(String[] args) throws SQLException {
		insert();
		selectData();
		System.out.println("");
		update();
		selectData();
		System.out.println("");
		delete();
		selectData();
	}

	
    public static void selectData() throws SQLException {
        try{
    			//load properties file
    			Properties props = new Properties();
    			
    			props.load(new FileInputStream("info.properties"));
    			
    			//read the props
    			String theUser = props.getProperty("user");
    			String thePassword = props.getProperty("password");
    			String theDburl = props.getProperty("dburl");
            //1. Making connection
            myConn= (Connection)DriverManager.getConnection(theDburl, theUser, thePassword);
            //2. Create statement
            stmt= myConn.createStatement();
            //3. Execute sql
            rs=stmt.executeQuery("select * from student where first_name='George' and last_name='Washington'");
            
            //4. Process the result set
			System.out.println("First Name" +"\t"+"Last Name"+"\t\t"+"GPA"+"\t\t"+"SAT"+"\t\t"+"Major");
			System.out.println("----------" +"\t"+"---------"+"\t\t"+"----"+"\t\t"+"----"+"\t\t"+"-------");

			while(rs.next())
            	System.out.println(rs.getString("first_name")+
            	"\t\t"+rs.getString("last_name")+"\t\t"+rs.getDouble("gpa")+"\t\t"+rs.getInt("sat")+"\t\t"+rs.getInt("major_id"));
               
            
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            if(myConn != null)
                myConn.close();
            if(stmt != null)
                stmt.close();
            
        }
    }
   
    
    
    public static void insert() throws SQLException {
        try{
    			//load properties file
    			Properties props = new Properties();
    			
    			props.load(new FileInputStream("info.properties"));
    			
    			//read the props
    			String theUser = props.getProperty("user");
    			String thePassword = props.getProperty("password");
    			String theDburl = props.getProperty("dburl");
            //1. Making connection
            myConn= (Connection)DriverManager.getConnection(theDburl, theUser, thePassword);
            //2. Create statement
            stmt= myConn.createStatement();
            //3. Execute sql
            String query = "insert into student values(666,'George','Washington',4.0,1600,null)";
            int rowAffected=stmt.executeUpdate(query);
            //4. Process the result set
               	System.out.println("table updated");
               
            
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            if(myConn != null)
                myConn.close();
            if(stmt != null)
                stmt.close();
            
        }
    }
    public static void update() throws SQLException {
        try{
    			//load properties file
    			Properties props = new Properties();
    			
    			props.load(new FileInputStream("info.properties"));
    			
    			//read the props
    			String theUser = props.getProperty("user");
    			String thePassword = props.getProperty("password");
    			String theDburl = props.getProperty("dburl");
            //1. Making connection
            myConn= (Connection)DriverManager.getConnection(theDburl, theUser, thePassword);
            //2. Create statement
            stmt= myConn.createStatement();
            //3. Execute sql
            String query = "update student set gpa=3.5,sat=1450,major_id=1 where id=666";
            int rowAffected=stmt.executeUpdate(query);
            //4. Process the result set
               	System.out.println("table updated");
               
            
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            if(myConn != null)
                myConn.close();
            if(stmt != null)
                stmt.close();
            
        }
    }
    public static void delete() throws SQLException {
        try{
    			//load properties file
    			Properties props = new Properties();
    			
    			props.load(new FileInputStream("info.properties"));
    			
    			//read the props
    			String theUser = props.getProperty("user");
    			String thePassword = props.getProperty("password");
    			String theDburl = props.getProperty("dburl");
            //1. Making connection
            myConn= (Connection)DriverManager.getConnection(theDburl, theUser, thePassword);
            //2. Create statement
            stmt= myConn.createStatement();
            //3. Execute sql
            String query = "delete from student where last_name='Washington'&& sat=1450";
            int rowAffected=stmt.executeUpdate(query);
            //4. Process the result set
               	System.out.println("table updated");
               
            
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            if(myConn != null)
                myConn.close();
            if(stmt != null)
                stmt.close();
            
        }
    }
    
}
