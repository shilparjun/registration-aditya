package com.aditya.exam;

import java.io.IOException;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddMCQ
 */
public class AddMCQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMCQ() {
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
		
		String option1 = null;
		String option2 = null;
		String option3 = null;
		String option4 = null;
		String branch = request.getParameter("branch");
		int year = Integer.parseInt(request.getParameter("year"));
		String subject = request.getParameter("subject");
		String chapter= request.getParameter("chapter");
		String complexity= request.getParameter("complexity");
		String question= request.getParameter("question");
		String type = request.getParameter("type");
    	String answer = request.getParameter("answer");
    	int marks = Integer.parseInt(request.getParameter("marks"));     

    	if(type == "MCQ" || type.equals("MCQ")) {
    		option1= request.getParameter("option1");
			option2= request.getParameter("option2");
			option3= request.getParameter("option3");
			option4 = request.getParameter("option4");
        }
	
    	if(answer.equals("Option1")) {
    		answer = option1; 
	   } else if (answer.equals("Option2")) {
		   answer = option2;
		   
	   }else if (answer.equals("Option3")) {
		   answer = option3;
		   
	   } else if (answer.equals("Option4")) {
		   answer = option4;
	   }
        ArrayList<QuestionBean> records = new ArrayList<QuestionBean>();

        HttpSession session = request.getSession();

		int semester = Integer.parseInt(request.getParameter("semester"));
		Connection conn;
 		try {
 			       
             ExamDAO dao = new ExamDAO();
             records = dao.addQuestion(year,branch, subject, chapter, complexity, marks,question,
            		 answer,type,option1, option2, option3, option4, semester);
             
             session.setAttribute("records", records);
             
        //     records = dao.getQuestions(type,branch, year, subject,semester); 
   	         RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayQuestionsAfterAdd.jsp");

   	         dispatch.forward(request, response);
         } catch (SQLException ex) {
             System.out.println("An error occurred. Maybe user/password is invalid");
             ex.printStackTrace();
         }			
		
		
	}
	}

	
