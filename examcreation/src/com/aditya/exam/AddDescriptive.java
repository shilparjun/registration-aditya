package com.aditya.exam;

import java.io.IOException;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddMCQ
 */
public class AddDescriptive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branch = request.getParameter("branchName");
		String subject = request.getParameter("branchName");
		System.out.println("subject is "+subject);
        List<String> list = new ArrayList<String>();
        String json = null;

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
				String query = "select subject from aditya.subjects where branch = " +"'"+branch+"'" ;
             
             PreparedStatement pst = (PreparedStatement) conn
 					.prepareStatement(query);

 			ResultSet rs = pst.executeQuery();
             
       	 while(rs.next()){
       		
       		 String subjects = rs.getString(1);
       		 list.add(subjects);
     		System.out.println("list size is "+list.size());
       	 }
       	conn.close();
 		}
               	 
       	catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }	

	     json = new Gson().toJson(list);
         response.setContentType("application/json");
         response.getWriter().write(json);
          		
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
