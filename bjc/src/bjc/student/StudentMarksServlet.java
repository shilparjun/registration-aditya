package bjc.student;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentSearchServlet
 */
public class StudentMarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentMarksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("studentID");
		String examType = request.getParameter("ExamType");
		String firstName = request.getParameter("firstName");
		String section = request.getParameter("section");
		String town = request.getParameter("town");
		String hostel = request.getParameter("hostel");
        ArrayList list=new ArrayList();
        
		StudentsBean student = null;
		MarksBean marks = null;
		StudentDAO  marksDAO = new StudentDAO();		
		try {
			if(id != null) {
			student = marksDAO.getStudentDetails(id);
			marks = marksDAO.getMarks(id, examType);
			student.setMarksBean(marks);
			String success = "/DisplayStudentMarksDetails.jsp";
			request.setAttribute("student",student);
			request.getRequestDispatcher(success).forward(request, response);
			}
			System.out.println("In Student Mark Servlet" +list.size());
			list = 	marksDAO.getMarks(id, section, firstName, town, hostel);
			String success = "/SearchMarksDetails.jsp";
			request.setAttribute("student",list);
			request.getRequestDispatcher(success).forward(request, response);
            
        } catch (Exception ex) {
        	ex.getMessage();
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
		
		}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
