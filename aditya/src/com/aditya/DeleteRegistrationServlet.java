package com.aditya;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aditya.bean.RegistrationBean;

/**
 * Servlet implementation class ViewRegistrationServlet
 */
public class DeleteRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
 		try {
 			
            // connect way #1
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());

			//Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            String url1 = "jdbc:mysql://localhost:3306/aditya";
            String user = "root";
            String password = "root";
            
            conn = DriverManager.getConnection(url1, user, password);
            if (conn != null) {
                System.out.println("Connected to the database test1");
            } 			
 			String query = null;
 			String delete[] = request.getParameterValues("delete");
 			
 				for (int i=0;i<delete.length ;i++){
 					
 					query = "delete from registration where id =" + delete[i];

 					PreparedStatement pst = (PreparedStatement) conn
 		 					.prepareStatement(query);
 								pst.executeUpdate();
 				}
				
           
             PreparedStatement pst = (PreparedStatement) conn
 					.prepareStatement("select * from registration");

 			ResultSet rs = pst.executeQuery();
			ArrayList<RegistrationBean> records = new ArrayList<RegistrationBean>();
            HttpSession session = request.getSession();

 			 while(rs.next()){
 	 			RegistrationBean regBean = new RegistrationBean(
 	 					rs.getInt(1),
 	 					rs.getString(2),
 	 					rs.getString(3),
 	 					rs.getString(4),
 	 					rs.getString(5),
 	 					rs.getString(6),
 	 					rs.getString(7),
 	 					rs.getString(8),
 	 					rs.getString(9),
 	 					rs.getString(10),
 	 					rs.getInt(11)
 	 					);
 	            session.setAttribute("registration", regBean);
 	 			records.add(regBean);
 			 }
 
   	         
             
             session.setAttribute("records", records);
   	         
   	         RequestDispatcher dispatch = request.getRequestDispatcher("RegistrationDisplay.jsp");
   	         
   	         dispatch.forward(request, response);

             conn.close();
             
             
         } catch (SQLException ex) {
             System.out.println("An error occurred. Maybe user/password is invalid");
             ex.printStackTrace();
         }	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
 		try {
 			
            // connect way #1
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());

			//Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            String url1 = "jdbc:mysql://localhost:3306/aditya";
            String user = "root";
            String password = "root";
            
            conn = DriverManager.getConnection(url1, user, password);
            if (conn != null) {
                System.out.println("Connected to the database test1");
            } 			
 			String query = null;
 			String delete[] = request.getParameterValues("delete");
 			
 				for (int i=0;i<delete.length ;i++){
 					
 					query = "delete from registration where id =" + delete[i];

 					PreparedStatement pst = (PreparedStatement) conn
 		 					.prepareStatement(query);
 								pst.executeUpdate();
 				}
				
           
             PreparedStatement pst = (PreparedStatement) conn
 					.prepareStatement("select * from registration");

 			ResultSet rs = pst.executeQuery();
			ArrayList<RegistrationBean> records = new ArrayList<RegistrationBean>();
            HttpSession session = request.getSession();

 			 while(rs.next()){
 	 			RegistrationBean regBean = new RegistrationBean(
 	 					rs.getInt(1),
 	 					rs.getString(2),
 	 					rs.getString(3),
 	 					rs.getString(4),
 	 					rs.getString(5),
 	 					rs.getString(6),
 	 					rs.getString(7),
 	 					rs.getString(8),
 	 					rs.getString(9),
 	 					rs.getString(10),
 	 					rs.getInt(11)
 	 					);
 	            session.setAttribute("registration", regBean);
 	 			records.add(regBean);
 			 }
 
   	         
             
             session.setAttribute("records", records);
   	         
   	         RequestDispatcher dispatch = request.getRequestDispatcher("RegistrationDisplay.jsp");
   	         
   	         dispatch.forward(request, response);

             conn.close();
             
             
         } catch (SQLException ex) {
             System.out.println("An error occurred. Maybe user/password is invalid");
             ex.printStackTrace();
         }	
	}
}
