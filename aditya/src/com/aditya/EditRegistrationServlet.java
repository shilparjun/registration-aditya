package com.aditya;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class EditRegistrationServlet
 */
public class EditRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRegistrationServlet() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
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
		
		Connection conn;
 		try {
             // connect way #1
 			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());

 			//Class.forName("com.mysql.jdbc.Driver").newInstance(); 
             String url1 = "jdbc:mysql://localhost:3306/aditya";
             String user = "root";
             String password = "root";
             
             conn = DriverManager.getConnection(url1, user, password);
		
             String query = " UPDATE REGISTRATION set FirstName= ? ," + "LastName=?,"
				+ "FatherName=?," + "Contact=?,"
				+ "address=?," + "email=?," + "hobbies=?,"
				+ "gender=?," + "branch=?," + "batchyear=? "
				+ "where id = ?";

				PreparedStatement preparedStmt = (PreparedStatement) conn
						.prepareStatement(query);
				preparedStmt.setString(1, firstName);
				preparedStmt.setString(2, lastName);
				preparedStmt.setString(3, fatherName);
				preparedStmt.setString(4, contact);
				preparedStmt.setString(5, address);
				preparedStmt.setString(6, email);
				preparedStmt.setString(7, hobbies);
				preparedStmt.setString(8, gender);
				preparedStmt.setString(9, group);
				preparedStmt.setInt(10, year);
				preparedStmt.setInt(11, id);
     			preparedStmt.executeUpdate();
				
			    RequestDispatcher dispatch = request.getRequestDispatcher("/ViewRegistrationServlet");
			    dispatch.forward(request, response);
		        conn.close();
 		} catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }	
	
	
	}

}
