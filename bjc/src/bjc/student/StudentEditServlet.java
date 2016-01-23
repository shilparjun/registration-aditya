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
public class StudentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("studentId");
		String submit = request.getParameter("submit");

		System.out.println("submit" + submit);
		System.out.println("submitid" + id);

		Connection conn = null;
		StudentsBean studentBean = null;
		FeesBean feeBean = null;
		StudentDAO dao = new StudentDAO();

		studentBean = dao.getStudentDetails(id);

		String success = null;

		if (submit != null) {
			if (submit.equals("edit")) {
				success = "/EditStudentInformation.jsp";
				request.setAttribute("students", studentBean);
				request.getRequestDispatcher(success)
						.forward(request, response);
			} else if (submit.equals("fees")) {
				ArrayList feeList = null;
				feeList = dao.getFeeDetails(id);
				int studentPaidAmount = dao.getBalance(studentBean.getStudentFees(), id);
				int busAmoutnPaid = dao.getBusFeeBalance(studentBean.getBusFees(),id);
				studentBean.setBalance(studentBean.getStudentFees() - studentPaidAmount);
				studentBean.setTutionFeesPaidAmount(studentPaidAmount);
				studentBean.setBusFeeBalance(studentBean.getBusFees() - busAmoutnPaid);
				studentBean.setBusFeesPaidAmount(busAmoutnPaid);
				studentBean.setFeeList(feeList);
				success = "/DisplayStudentFeeDetails.jsp";
				request.setAttribute("students", studentBean);
				request.getRequestDispatcher(success)
						.forward(request, response);
			} else if (submit.equals("marks")) {
				String examType = request.getParameter("ExamType");
				MarksBean marksBean = (MarksBean) dao.getMarks(id, examType);
				studentBean.setMarksBean(marksBean);
				success = "/DisplayStudentMarksDetails.jsp";
				request.setAttribute("students", studentBean);
				request.getRequestDispatcher(success)
						.forward(request, response);
			} else if (submit.equals("feeedit")) {
			
				ArrayList feeList = dao.getFeeDetails(id);
				int studentPaidAmount = dao.getBalance(studentBean.getStudentFees(), id);
				int busAmoutnPaid = dao.getBusFeeBalance(studentBean.getBusFees(),id);
				studentBean.setBalance(studentBean.getStudentFees() - studentPaidAmount);
				studentBean.setTutionFeesPaidAmount(studentPaidAmount);
				studentBean.setBusFeeBalance(studentBean.getBusFees() - busAmoutnPaid);
				studentBean.setBusFeesPaidAmount(busAmoutnPaid);
				studentBean.setFeeList(feeList);
				success = "/EditStudentFeeDetails.jsp";
				request.setAttribute("students", studentBean);
				request.getRequestDispatcher(success)
						.forward(request, response);
			}
		} else {
			success = "/DisplayStudentDetails.jsp";
			request.setAttribute("students", studentBean);
			request.getRequestDispatcher(success).forward(request, response);
		}

	}

	/*
	 * if(submit != null) { if(submit.equals("edit")) { success =
	 * "/EditStudentInformation.jsp";
	 * request.setAttribute("students",studentBean);
	 * request.getRequestDispatcher(success).forward(request, response); } else
	 * if(submit.equals("fees")) { success = "/DisplayStudentFeeDetails.jsp";
	 * request.setAttribute("students",studentBean);
	 * request.getRequestDispatcher(success).forward(request, response); } else
	 * if(submit.equals("marks")) { success = "/DisplayStudentMarksDetails.jsp";
	 * request.setAttribute("students",studentBean);
	 * request.getRequestDispatcher(success).forward(request, response); } }
	 */

	/*
	 * if(edit != null) { success = "/EditStudentInformation.jsp";
	 * request.setAttribute("students",studentBean);
	 * request.getRequestDispatcher(success).forward(request, response); } else
	 * { success = "/DisplayStudentDetails.jsp";
	 * request.setAttribute("students",studentBean);
	 * request.getRequestDispatcher(success).forward(request, response); }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("studentID");
		String submit = request.getParameter("submit");
		System.out.println("submit" + submit);

		StudentDAO dao = new StudentDAO();

		StudentsBean studentBean = dao.getStudentDetails(id);

		String success = null;
		if (submit == "edit") {
			success = "/EditStudentInformation.jsp";
			request.setAttribute("students", studentBean);
			request.getRequestDispatcher(success).forward(request, response);
		} else if (submit == "fees") {
			success = "/DisplayStudentFeeDetails.jsp";
			request.setAttribute("students", studentBean);
			request.getRequestDispatcher(success).forward(request, response);
		}
	}
}
