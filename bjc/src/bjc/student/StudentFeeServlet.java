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
 * Servlet implementation class StudentSearchServlet
 */
public class StudentFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentFeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("studentid");
		int busFee = 0;
		Integer tutionFees = Integer.parseInt(request.getParameter("TutionFees"));
		if (request.getParameter("BusFees")!= null) {
		  Integer busFees = Integer.parseInt(request.getParameter("BusFees"));
		  busFee = busFees.intValue();
		} 
		String receivedFrom = request.getParameter("ReceivedFrom");
		String receivedBy = request.getParameter("ReceivedBy");
		String nextPayment = request.getParameter("NextPayment");
		String remarks = request.getParameter("remarks");
        FeesBean feeBean = new FeesBean (id,tutionFees.intValue(),busFee,nextPayment,receivedBy,receivedFrom,remarks);
		StudentsBean student = null;
		FeesBean fees = null;
		
		try {
			StudentDAO  feesDAO = new StudentDAO();
            // connect way #1
		    	
			fees = feesDAO.updateFees(feeBean);
			student = feesDAO.getStudentDetails(id);
			
			int studentPaidAmount = feesDAO.getBalance(student.getStudentFees(), id);
			int busAmoutnPaid = feesDAO.getBusFeeBalance(student.getBusFees(),id);
			student.setBalance(student.getStudentFees() - studentPaidAmount);
			student.setTutionFeesPaidAmount(studentPaidAmount);
			student.setBusFeeBalance(student.getBusFees() - busAmoutnPaid);
			student.setBusFeesPaidAmount(busAmoutnPaid);
		    String  success = "/DisplayStudentFeeDetails.jsp";
			request.setAttribute("students",student);
			request.getRequestDispatcher(success).forward(request, response);		           			
            
        } catch (Exception ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
	}

}
