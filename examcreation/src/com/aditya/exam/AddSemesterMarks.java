package com.aditya.exam;

import java.io.IOException;




import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddQuestionPaper
 */
public class AddSemesterMarks extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int year = Integer.parseInt(request.getParameter("year"));
		String subject = request.getParameter("subject");
		String branch = request.getParameter("branch");
		int semester = Integer.parseInt(request.getParameter("semester"));
		
		ArrayList<String> parameterNames = new ArrayList<String>();
		
		ArrayList<StudentMarksBean> semesterMarks = new ArrayList<StudentMarksBean>();

        HttpSession session = request.getSession();
        
		 Enumeration enumeration = request.getParameterNames();
		 int marks1=0,marks2=0,finalMarks = 0;
		    while (enumeration.hasMoreElements()) {
		        String parameterName = (String) enumeration.nextElement();
		        
		        if (parameterName.startsWith("internal1")) {
		        	
		        	 marks1 = Integer.parseInt(request.getParameter(parameterName)); 
		        } else if (parameterName.startsWith("internal2")) {
		        	
		        	int studentID = Integer.parseInt(parameterName.substring(9, parameterName.length()));
		        	
		        	 marks2 = Integer.parseInt(request.getParameter(parameterName)); 
		        	 
		        	 if(marks1 > marks2) {
			        	 finalMarks =	marks1;	        		 
		        	 } else 
		        		 finalMarks = marks2;
  
		        			 
		        	StudentMarksBean markBean = new StudentMarksBean(subject,semester,marks1,marks2,finalMarks,studentID);
		        	
		        	semesterMarks.add(markBean);
		        }

		    }
		
			try {
	            ExamDAO dao = new ExamDAO();

	            semesterMarks = dao.addMarks(branch,year,subject,semester,semesterMarks);
		        } catch(SQLException ex) {
		        	   ex.getMessage();
		           }

         session.setAttribute("records", semesterMarks);
  	         
  	         RequestDispatcher dispatch = request.getRequestDispatcher("DisplaySemesterMarks.jsp");
  	         
  	         dispatch.forward(request, response);
		
	}


}
