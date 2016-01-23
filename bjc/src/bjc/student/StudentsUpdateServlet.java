package bjc.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bjc.inventory.InventoryBean;

/**
 * Servlet implementation class StudentInfoServlet
 */
public class StudentsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentsUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sno = request.getParameter("studentid");
		String section = request.getParameter("section");
		String fatherName = request.getParameter("fatherName");
		String firstName = request.getParameter("firstName");
		String contactNumber = request.getParameter("contactNumber");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String group = request.getParameter("group");
		String town = request.getParameter("town");
		String hostel = request.getParameter("hostel");
		String secondaryNumber = request.getParameter("secondaryNumber");
		String schoolStudied = request.getParameter("schoolStudied");
		String fatherOccupation = request.getParameter("fatherOccupation");
		String schoolGrade = request.getParameter("schoolGrade");
		String schoolFees = request.getParameter("schoolFees");
		
		
		Connection conn= null;
		StudentsBean	  student = null;

		StudentDAO dao = new StudentDAO();
		
		student = dao.updateStudent(sno,section,firstName,lastName,group,hostel,schoolStudied,schoolGrade,fatherName,contactNumber,address,town,secondaryNumber,fatherOccupation,schoolFees);
		

	
			String success = null;
		//	ArrayList list = new ArrayList();
			success = "/DisplayStudentDetails.jsp";
			request.setAttribute("students",student);
			request.getRequestDispatcher(success).forward(request, response);
	
	}

}
