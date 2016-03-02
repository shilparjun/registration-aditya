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
public class GetQuestionPapers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		 ArrayList<QuestionBean> records = new ArrayList<QuestionBean>();
	        HttpSession session = request.getSession();
			try {


	            ExamDAO dao = new ExamDAO();
	            records = dao.getExamPaperQuestions(id);

	            session.setAttribute("records", records);
	  	         
	  	         RequestDispatcher dispatch = request.getRequestDispatcher("QuestionPaperQuestionsDisplay.jsp");
	  	         
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
		int year = Integer.parseInt(request.getParameter("year"));
		String branch = request.getParameter("branch");
		String subject = request.getParameter("subject");
        HttpSession session = request.getSession();
        
        ArrayList<QuestionBean> records = new ArrayList<QuestionBean>();

		try {
		       
            ExamDAO dao = new ExamDAO();
            records = dao.getExamPapers(year,branch,subject);

            session.setAttribute("records", records);
  	         
  	         RequestDispatcher dispatch = request.getRequestDispatcher("QuestionPaperDisplay.jsp");
  	         
  	         dispatch.forward(request, response);
  
           
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }			
		
		
	}
	

}
