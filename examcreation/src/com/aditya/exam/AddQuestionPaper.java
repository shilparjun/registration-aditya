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
 * Servlet implementation class AddQuestionPaper
 */
public class AddQuestionPaper extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paperName =  request.getParameter("paperName");
		String type = request.getParameter("type");
		String branch = request.getParameter("branch");
		int year = Integer.parseInt(request.getParameter("year"));
		String subject = request.getParameter("subject");
		int semester = Integer.parseInt(request.getParameter("semester"));
		String add[] = request.getParameterValues("add");
        HttpSession session = request.getSession();
        
        ArrayList<QuestionBean> records = new ArrayList<QuestionBean>();

		try {
            ExamDAO dao = new ExamDAO();
            records = dao.addQuestionPaper(paperName,type,semester,branch, subject, year,add);

            session.setAttribute("records", records);
  	         
  	         RequestDispatcher dispatch = request.getRequestDispatcher("QuestionPaperDisplay.jsp");
  	         
  	         dispatch.forward(request, response);
  
           
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }			
		
		
	}


}
