package com.aditya.exam;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetSemesterMarks
 */
public class GetSemesterMarks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int yearJoined  = Integer.parseInt(request.getParameter("yearJoined"));
		String branch = request.getParameter("branch");
		String subject = request.getParameter("subject");
		int semester = Integer.parseInt(request.getParameter("semester"));
        HttpSession session = request.getSession();
        
        ArrayList<StudentMarksBean> records = null;

		try {
		       
            ExamDAO dao = new ExamDAO();
            records = dao.getStudentMarks(branch, semester, subject, yearJoined);

            session.setAttribute("records", records);
  	         
  	         RequestDispatcher dispatch = request.getRequestDispatcher("DisplaySemesterMarks.jsp");
  	         
  	         dispatch.forward(request, response);
  
           
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }			
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int yearJoined  = Integer.parseInt(request.getParameter("yearJoined"));
		String branch = request.getParameter("branch");
		String subject = request.getParameter("subject");
		int semester = Integer.parseInt(request.getParameter("semester"));
        HttpSession session = request.getSession();
        
        ArrayList<StudentMarksBean> records = null;

		try {
		       
            ExamDAO dao = new ExamDAO();
            records = dao.getStudentMarks(branch, semester, subject, yearJoined);

            session.setAttribute("records", records);
  	         
  	         RequestDispatcher dispatch = request.getRequestDispatcher("DisplaySemesterMarks.jsp");
  	         
  	         dispatch.forward(request, response);
  
           
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }			
		}

}
