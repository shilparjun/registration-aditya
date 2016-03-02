package com.aditya.exam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetQuestions
 */
public class GetStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		int year = Integer.parseInt(request.getParameter("year"));
		String branch = request.getParameter("branch");
        HttpSession session = request.getSession();
        
        ArrayList<StudentBean> records = new ArrayList<StudentBean>();

		try {
		       
            ExamDAO dao = new ExamDAO();
            records = dao.getStudents(year,branch);

            session.setAttribute("records", records);
  	         
  	         RequestDispatcher dispatch = request.getRequestDispatcher("AddMarksSecond.jsp");
  	         
  	         dispatch.forward(request, response);
  
           
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }			
		
		
	}
	

}
