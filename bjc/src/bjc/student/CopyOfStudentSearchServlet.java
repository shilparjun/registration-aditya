package bjc.student;

import java.io.IOException;

import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class StudentSearchServlet
 */
public class CopyOfStudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CopyOfStudentSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("id");

	/*	String id = request.getParameter("studentID");
		System.out.println("id"+id);
		String section = request.getParameter("section");
		String firstName = request.getParameter("firstName");
		String feeConfimred = request.getParameter("feeConfimred");
		String hostel = request.getParameter("hostel");
		String fatherName = request.getParameter("fatherName");
		String town = request.getParameter("town");*/
        ArrayList list=null;
		
		StudentDAO dao = new StudentDAO();
		
		//list = dao.getStudents(id,section,firstName,feeConfimred,fatherName,town,hostel);
		list = dao.getEmployees();
		
		for(int i=0 ; i < list.size() ;i++)  {
			
			StudentsBean	bean =  (StudentsBean)list.get(i);

		}

		String success = "/SearchStudentDetailsPage.jsp";
		request.setAttribute("students",list);
		request.getRequestDispatcher(success).forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("id");

	/*	String id = request.getParameter("studentID");
		System.out.println("id"+id);
		String section = request.getParameter("section");
		String firstName = request.getParameter("firstName");
		String feeConfimred = request.getParameter("feeConfimred");
		String hostel = request.getParameter("hostel");
		String fatherName = request.getParameter("fatherName");
		String town = request.getParameter("town");*/
        ArrayList list=null;
		
		StudentDAO dao = new StudentDAO();
		
		//list = dao.getStudents(id,section,firstName,feeConfimred,fatherName,town,hostel);
		list = dao.getEmployees();
		
		for(int i=0 ; i < list.size() ;i++)  {
			
			StudentsBean	bean =  (StudentsBean)list.get(i);

		}

		String success = "/SearchStudentDetailsPage.jsp";
		request.setAttribute("students",list);
		request.getRequestDispatcher(success).forward(request, response);
		}

	}

