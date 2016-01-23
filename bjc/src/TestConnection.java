import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import bjc.inventory.InventoryBean;
import bjc.student.StudentDetailsBean;

public class TestConnection {
    public static void main(String[] args) {
 
    //	InventoryBean invBean = null ;
        ArrayList list=new ArrayList();
        
        String startDate = "01-18-2015";
        
        String[] parts = startDate.split("-");
        
        startDate = parts[2] +"-" +parts[0]+"-"+parts[1];
        System.out.println("startDate"+startDate);
    	
 		Connection conn;
 		PreparedStatement stmt=null;
 		try {
             // connect way #1
 			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());

 			//Class.forName("com.mysql.jdbc.Driver").newInstance(); 
             String url1 = "jdbc:mysql://localhost:3306/mysql";
             String user = "root";
             String password = "root";
             
             conn = DriverManager.getConnection(url1, user, password);
             if (conn != null) {
                 System.out.println("Connected to the database test1");
             }
             
             String query = " select * from STUDENTDETAILS where Section = ? and StudentName like ? and SchoolName = ? and FatherName like ? and Village like ?";

             PreparedStatement preparedStmt = conn.prepareStatement(query);

   	            // create the mysql insert preparedstatement
   	            preparedStmt.setString (1, "JE1");
   	            preparedStmt.setString (2, "%" + "Sanyu" + "%");
   	            preparedStmt.setString (3, "Chaitanya1 Bharathi");
   	            preparedStmt.setString (4, "%" +"m"+ "%");
   	            preparedStmt.setString (5, "%" +"n" + "%");
   	                      
   	            
   	          /*  ResultSet rs = preparedStmt.executeQuery();
   		           while( rs.next()){
   		        	   StudentDetailsBean 		  studentBean = new StudentDetailsBean (
   		        			   rs.getString(1),
   		        			   rs.getString(2),
   		        			   rs.getString(3),
   		        			   rs.getString(4),
   		        			   rs.getString(5),
   		        			   rs.getString(6),
   		        			   rs.getString(7),
   		        			   rs.getString(8),
   		        			   rs.getString(9),
   		        			   rs.getString(10),
   		        			   rs.getString(11));
   		        			//   rs.getDate(12));
   		        	   list.add(studentBean);      	   
   		            
 	           }*/
             
 	           System.out.println("SIZE" +list.size());
             conn.close();
             
             
         } catch (SQLException ex) {
             System.out.println("An error occurred. Maybe user/password is invalid");
             ex.printStackTrace();
         }	
 		
 		if(list.size() == 0) {
 			System.out.println("No records Found");
 		} else 
 			System.out.println("records Found"); {
 				
 			}
 		
    }
}