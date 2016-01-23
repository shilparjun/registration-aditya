package bjc.student;

import java.util.Calendar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class StudentDAO {
	
	Connection connection;
	Statement stmt;

	public StudentDAO() {
	}

	private static Connection getConnection() throws SQLException
			 {
		Connection con = ConnectionFactory.getInstance().getConnection();
		return con;
	}


/*	protected Connection getConnection() {
		Connection conn = null;

		try {
			// connect way #1
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url1 = "jdbc:mysql://localhost:3306/bjc";
			String user = "root";
			String password = "root";

			conn = DriverManager.getConnection(url1, user, password);
			if (conn != null) {
				System.out.println("Connected to the database test1");
			}
		}

		catch (SQLException ex) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		}
		return conn;
	}
*/
	public int getBalance(int studentfees, String id) {

		int stuAmount = 0;
		//int stuBalance = 0;

		String query = "select SUM(Annualfeespaid) as StuTotal  from fees where  fees.studentid = ?";

		try {

			Connection conn = getConnection();

			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);

			// create the mysql insert preparedstatement
			preparedStmt.setString(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				stuAmount = rs.getInt(1);
			}
			conn.close();
			//stuBalance = studentfees - stuAmount;

			System.out.println("Student Paid Amount " + stuAmount);

		} catch (SQLException ex) {
			ex.getMessage();

		}

		return stuAmount;
	}

	public int getBusFeeBalance(int busFees, String id) {

		int busAmount = 0;

		String query = "select SUM(BusfeesPaid) as BusTotal  from fees where  fees.studentid = ?";

		try {

			Connection conn = getConnection();

			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);

			// create the mysql insert preparedstatement
			preparedStmt.setString(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				busAmount = rs.getInt(1);
				System.out.println("BUS Amount " + busAmount);
			}

			conn.close();


			System.out.println("BUS Paid Amount " + busAmount);

		} catch (SQLException ex) {
			ex.getMessage();

		}

		return busAmount;
	}

	public MarksBean getMarks(String id, String examType) {

		// select
		// SUM(marks.English+marks.Sanskrit+marks.Maths1a+marks.Maths1b+marks.Physics+marks.Chemistry)
		// as Total from marks;
		String query = "select * from bjc.marks where studentid = ? ";
		MarksBean marksBean = null;		
		try {
		Connection conn = getConnection();
			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);

			// create the mysql insert preparedstatement
			if (examType == null) {
				preparedStmt.setString(1, id);
				// preparedStmt.setString (2, "Quarterly");
			} else {
				preparedStmt.setString(1, id);
				// preparedStmt.setString (2, examType);

			}
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				marksBean = new MarksBean(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),
						rs.getInt(7), rs.getInt(8), rs.getInt(9),
						rs.getInt(10), rs.getInt(11), rs.getInt(12),
						rs.getInt(13), rs.getString(14), rs.getInt(15));
			}
			conn.close();

		} catch (SQLException ex) {
			ex.getMessage();

		}
		

		return marksBean;
	}

	public StudentsBean getStudentDetails(String id) {

		StudentsBean students = null;
		ArrayList<StudentsBean> list = new ArrayList<StudentsBean>();

		String query = " select * from STUDENT  where sno = ?";

		try {
			Connection conn = getConnection();

			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);

			preparedStmt.setString(1, id);

			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				students = new StudentsBean(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5), // student year
						rs.getString(6),// First Name
						rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12),
						rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getInt(17),// tuition fees
						rs.getInt(18),// bus fees
						rs.getString(19)// fees set
				);
				
				list.add(students);
				ArrayList<FeesBean> feeList = (ArrayList<FeesBean>) getFeeDetails(id);
				students.setFeeList(feeList);				

			}
		
			conn.close();

		} catch (SQLException ex) {
			ex.getMessage();
		}

		return students;

	}

	public ArrayList<StudentsBean> getStudents(String id, String section, String firstName,
			String feesSet, String fatherName, String town,String hostel) {

		StudentsBean students = null;
		ArrayList<StudentsBean> list = new ArrayList<StudentsBean>();
		String query = " select * from STUDENT  where Section like ? and FirstName like ? and FeesSet like ? and FatherName like ? and Town like ? and HostelBus like ?";

		try {
	
			Connection conn = getConnection();

			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);
			// create the mysql insert preparedstatement
			preparedStmt.setString(1, "%" + section + "%");
			preparedStmt.setString(2, "%" + firstName + "%");
			preparedStmt.setString(3, "%" + feesSet + "%");
			preparedStmt.setString(4, "%" + fatherName + "%");
			preparedStmt.setString(5, "%" + town + "%");
			preparedStmt.setString(6, "%" + hostel + "%");

			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				students = new StudentsBean(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5), // student year
						rs.getString(6),// First Name
						rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12),
						rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getInt(17),// tuition fees
						rs.getInt(18),// bus fees
						rs.getString(19)// fees set
				);
				int amountpiad = getBalance(students.getStudentFees(),  students.getSno());
				students.setTutionFeesPaidAmount(amountpiad);
				int buspiad = getBusFeeBalance(students.getBusFees(),  students.getSno());
				students.setBusFeesPaidAmount(buspiad);
				list.add(students);
			}
			conn.close();
		} catch (SQLException ex) {
			ex.getMessage();
		}

		return list;

	}

	public ArrayList<StudentsBean> getEmployees() {

		StudentsBean students = null;
		ArrayList<StudentsBean> list = new ArrayList<StudentsBean>();
		//String query = " select * from STUDENT  where Section like ? and FirstName like ? and FeesSet like ? and FatherName like ? and Town like ? and HostelBus like ?";
		String query = " select SNo,Section,FirstName from STUDENT";
		try {
	
			Connection conn = getConnection();

			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);
/*			// create the mysql insert preparedstatement
			preparedStmt.setString(1, "%" + section + "%");
			preparedStmt.setString(2, "%" + firstName + "%");
			preparedStmt.setString(3, "%" + feesSet + "%");
			preparedStmt.setString(4, "%" + fatherName + "%");
			preparedStmt.setString(5, "%" + town + "%");
			preparedStmt.setString(6, "%" + hostel + "%");
*/
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				students = new StudentsBean(rs.getString(1),
						rs.getString(2),
						rs.getString(3)// First Name
				);
				list.add(students);
			}
			conn.close();
		} catch (SQLException ex) {
			ex.getMessage();
		}

		return list;

	}	
	
	
	
	
	public ArrayList<MarksBean> getMarks(String id, String section, String firstName,
			 String town,String hostel) {

		MarksBean marks = null;
		ArrayList<MarksBean> list = new ArrayList<MarksBean>();
		
		String query = "SELECT  marks.studentid,marks.english,marks.Maths1a,marks.Maths1b,marks.Physics,marks.Chemistry,marks.Botony,marks.Zoology,marks.total,student.Section,student.FirstName FROM marks ,Student where marks.studentid = student.SNo and  Section like ? and FirstName like ? and Town like ? and HostelBus like ?";

		try {
			Connection conn = getConnection();

			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);

			preparedStmt.setString(1, "%" + section + "%");
			preparedStmt.setString(2, "%" + firstName + "%");
			preparedStmt.setString(3, "%" + town + "%");
			preparedStmt.setString(4, "%" + hostel + "%");

			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				marks = new MarksBean(
						rs.getString(1), //Studentid
						rs.getInt(2),//English
						rs.getInt(3),//Maths1
						rs.getInt(4),//Maths2
						rs.getInt(5), //Physcis
						rs.getInt(6),//Che
						rs.getInt(7),//Botony
						rs.getInt(8),//Zoology
						rs.getInt(9),//Total
						rs.getString(10),
						rs.getString(11)
				);
	
				list.add(marks);
			}
			conn.close();
		} catch (SQLException ex) {
			ex.getMessage();
		}

		return list;

	}
	
	

	public StudentsBean updateStudent(String sno, String section,
			String firstName, String lastName, String group, String hostel,
			String schoolStudied, String schoolGrade, String fatherName,
			String contactNumber, String address, String town,
			String secondaryNumber, String fatherOccupation,String schoolFees) {

		StudentsBean student = null;
		
		int schoolFee =  Integer.parseInt(schoolFees);
		

		try {
			Connection conn = getConnection();

			String query = " UPDATE STUDENT set FirstName= ? ," + "LastName=?,"
					+ "FatherName=?," + "ContactNumber=?,"
					+ "SecondaryNumber=?," + "Section=?," + "SchoolStudied=?,"
					+ "SchoolGrade=?," + "Address=?," + "Town=?,"
					+ "FatherOccupation=?," + "HostelBus=?,"+"TutionFees=? " + "where sno = ?";

			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);
			preparedStmt.setString(1, firstName);
			preparedStmt.setString(2, lastName);
			preparedStmt.setString(3, fatherName);
			preparedStmt.setString(4, contactNumber);
			preparedStmt.setString(5, secondaryNumber);
			preparedStmt.setString(6, section);
			preparedStmt.setString(7, schoolStudied);
			preparedStmt.setString(8, schoolGrade);
			preparedStmt.setString(9, address);
			preparedStmt.setString(10, town);
			preparedStmt.setString(11, fatherOccupation);
			preparedStmt.setString(12, hostel);
			preparedStmt.setInt(13, schoolFee);
			preparedStmt.setString(14,sno );
			preparedStmt.execute();

			student = getStudentDetails(sno);

			conn.close();
		} catch (SQLException ex) {
			System.out
					.println("An error occurred in updateStudent. Maybe user/password is invalid");
			ex.printStackTrace();
		}
		return student;

	}

	public ArrayList<FeesBean> getFeeDetails(String id) {

		ArrayList<FeesBean> feeList = new ArrayList<FeesBean>();

		try {

			String query = " select * from fees where studentid = ?";

			Connection conn = getConnection();

			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement(query);

			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				FeesBean feeBean = new FeesBean(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9));
				feeList.add(feeBean);
			}
			conn.close();
		} catch (SQLException ex) {
			System.out
					.println("An error occurred in getFeeDetails. Maybe user/password is invalid");
			ex.printStackTrace();
		}
		return feeList;
	}

	public FeesBean updateFees(FeesBean feeBean) {

		try {

			String query = "Insert into fees values (?,?,?,?,?,?,?,?,?)";
			Connection conn = getConnection();

			PreparedStatement pst = (PreparedStatement) conn
					.prepareStatement("SELECT MAX(sno) AS id FROM fees");

			ResultSet rs = pst.executeQuery();

			 int lastid = 0;
			 if(rs.next()){
			 lastid = rs.getInt("id");
			 }
			 Calendar calendar = Calendar.getInstance();
			    java.sql.Date dateObject = new java.sql.Date(calendar.getTime().getTime());

			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement(query);
			ps.setInt(1, lastid+1);
			ps.setString(2, feeBean.getStudentid());
			ps.setInt(3, feeBean.getAnnualFeesPaid());
			ps.setInt(4, feeBean.getBusfeesPaid());
			ps.setDate(5, dateObject);
			ps.setString(6, feeBean.getNextInstallment());
			ps.setString(7, feeBean.getGivento());
			ps.setString(8, feeBean.getPaidBy());
			ps.setString(9, feeBean.getRemarks());

			ps.executeUpdate();
			conn.close();
		} catch (Exception ex) {
			System.out
					.println("An error occurred in updateStudent. Maybe user/password is invalid");
			ex.printStackTrace();
		}
		return feeBean;

	}

}
