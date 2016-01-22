package com.aditya;

import java.io.IOException;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddRegistration
 */
public class AddRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String group = request.getParameter("group");
		int year = Integer.parseInt(request.getParameter("year"));
		String firstName = request.getParameter("firstName");
		String lastName= request.getParameter("lastName");;
		String fatherName= request.getParameter("fatherName");;
		String contact= request.getParameter("contact");;
		String address= request.getParameter("address");;
		String email= request.getParameter("email");;
		String hobbies= request.getParameter("hobbie");
		String gender = request.getParameter("gender");

/*		RegistrationBean regBean = new RegistrationBean(id,
														firstName,
														lastName,
														fatherName,
														contact,
														address,
														email,
														hobbies,
														gender,
														group,
														year);
		System.out.println(regBean.toString());*/
		
		//Connect to Database
		
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
             
             PreparedStatement pst = (PreparedStatement) conn
 					.prepareStatement("SELECT MAX(id) AS id FROM Registration");

 			ResultSet rs = pst.executeQuery();

 			 int lastid = 0;
 			 if(rs.next()){
 			 lastid = rs.getInt("id");
 			 }
 			 String query = "Insert into Registration values (?,?,?,?,?,?,?,?,?,?,?)";
             PreparedStatement preparedStmt = conn.prepareStatement(query);
             preparedStmt.setInt (1, lastid+1);
             preparedStmt.setString (2, firstName);
             preparedStmt.setString (3, lastName);
             preparedStmt.setString (4, fatherName);
             preparedStmt.setString (5, contact);
             preparedStmt.setString (6, address);
             preparedStmt.setString (7, email);
             preparedStmt.setString (8, hobbies);
             preparedStmt.setString (9, gender);
             preparedStmt.setString (10, group);
             preparedStmt.setInt (11, year);
    	         
   	         RequestDispatcher dispatch = request.getRequestDispatcher("/ViewRegistrationServlet");
   	         
   	         dispatch.forward(request, response);

             conn.close();
             
             
         } catch (SQLException ex) {
             System.out.println("An error occurred. Maybe user/password is invalid");
             ex.printStackTrace();
         }	
		
		
	}

}
