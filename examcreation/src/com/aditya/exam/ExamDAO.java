package com.aditya.exam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.PreparedStatement;



public class ExamDAO {
	
	Connection connection;
	Statement stmt;

	public ExamDAO() {
	}

	private static Connection getConnection() throws SQLException
			 {
		Connection con = ConnectionFactory.getInstance().getConnection();
		return con;
	}

	public ArrayList addQuestion(int year,String branch,  String subject,
				String chapter, String complexity,int marks,String question,
				String answer,String type, String option1,
				String option2, String option3, String option4, 
				 int semester) throws SQLException {
		Connection conn = getConnection();
		ArrayList<QuestionBean> list = new ArrayList<QuestionBean>();

	
		 PreparedStatement pst = (PreparedStatement) conn
				.prepareStatement("SELECT MAX(id) AS id FROM Questions");

		ResultSet rs = pst.executeQuery();

		 int lastid = 0;
		 if(rs.next()){
		 lastid = rs.getInt("id");
		 }
		 			 
		 String query = "Insert into questions values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 PreparedStatement preparedStmt = conn.prepareStatement(query);
		 preparedStmt.setInt (1, lastid+1);
		 preparedStmt.setInt (2, year);
		 preparedStmt.setString (3, branch);
		 preparedStmt.setString (4, subject);
		 preparedStmt.setString (5, chapter);
		 preparedStmt.setString (6, complexity);
		 preparedStmt.setInt (7, marks);
		 preparedStmt.setString (8, question);
		 preparedStmt.setString (9, answer);
		 preparedStmt.setString (10, type);
		 preparedStmt.setString (11, "admin1");
		 preparedStmt.setString (12, "admin2");
		 preparedStmt.setString (13, option1);
		 preparedStmt.setString (14, option2);
		 preparedStmt.setString (15, option3);
		 preparedStmt.setString (16, option4);
		 preparedStmt.setInt (17, semester);
		 preparedStmt.executeUpdate();
		 
		 list = getQuestions(type,  branch,  year,
					 subject, semester); 
		 conn.close();
		 
		 return list;

	}

	public ArrayList getQuestions(String type, String branch, int year,
			String subject,int semester) throws SQLException {
		
		
		String query = " select * from aditya.questions  where type like ? and branch like ? and yearjoined like ? and subject like ? and semester like ? ";

	
			Connection conn = getConnection();

			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);
			// create the mysql insert preparedstatement
			preparedStmt.setString(1, "%" + type + "%");
			preparedStmt.setString(2, "%" + branch + "%");
			preparedStmt.setString(3, "%" + year + "%");
			preparedStmt.setString(4, "%" + subject + "%");
			preparedStmt.setString(5, "%" + semester + "%");
			ArrayList<QuestionBean> list = new ArrayList<QuestionBean>();

			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
			QuestionBean examBean = new QuestionBean(
					 rs.getInt (1),
					 rs.getInt (2),
					 rs.getString (3),
					 rs.getString (4),
					 rs.getString (5),
					 rs.getString (6),
					 rs.getInt (7),
					 rs.getString (8),
					 rs.getString (9),
					 rs.getString (12),
					 rs.getString (13),
					 rs.getString (14),
					 rs.getString (15),
					 rs.getString (16),
					 rs.getInt (17)
					);
			
			list.add(examBean);
		
			}
			return list;
		}
	
	public ArrayList<QuestionBean> addQuestionPaper(String paperName,String type,int semester, String branch, 
			String subject,int year, String[] add) throws SQLException {
			Connection conn = getConnection();
			ArrayList<QuestionBean> list = new ArrayList<QuestionBean>();
			 PreparedStatement pst = (PreparedStatement) conn
					.prepareStatement("SELECT MAX(id) AS id FROM questionpapers");

			ResultSet rs = pst.executeQuery();

			 int lastid = 0;
			 int last = 0;
			 if(rs.next()){
			 lastid = rs.getInt("id");
			 }
				java.sql.Date sysdate = new java.sql.Date(Calendar.getInstance()
						.getTime().getTime());			 			 
			 String query = "Insert into questionpapers values (?,?,?,?,?,?,?,?,?)";
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			 preparedStmt.setInt (1, lastid+1);
			 preparedStmt.setString (2,paperName );
			 preparedStmt.setString (3, type);
			 preparedStmt.setInt (4,semester );
			 preparedStmt.setString (5,branch );
			 preparedStmt.setString (6, subject);
			 preparedStmt.setInt (7, year);
			 preparedStmt.setDate(8,sysdate );
			 preparedStmt.setString(9,"Active" );
			 preparedStmt.executeUpdate();
			 
				for (int i=0;i<add.length ;i++){
					
					 pst = (PreparedStatement) conn
							.prepareStatement("SELECT MAX(id) AS id FROM examquestions");

					 rs = pst.executeQuery();

					  
					 if(rs.next()){
					 last = rs.getInt("id");
					 }
					
					int questionNo = Integer.parseInt(add[i]);
					
					query = "insert into examquestions values (?,?,?)" ;  

					pst = (PreparedStatement) conn
		 					.prepareStatement(query);
					pst.setInt(1, last+1);
					pst.setInt(2, lastid+1);
					pst.setInt(3, questionNo);
					pst.executeUpdate();
				}			 
				
				list = getExamPapers(year,branch,subject);

				
			 conn.close();
				return list;
		}

	
//
	public ArrayList<StudentBean> getStudents(int year, String branch) throws SQLException  {
	
		
		String query = " select * from aditya.Students  where  branch like ? and yearjoined like ? ";

	
			Connection conn = getConnection();

			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);
			// create the mysql insert preparedstatement
			preparedStmt.setString(1, "%" + branch + "%");			
			preparedStmt.setString(2, "%" + year + "%");

			ArrayList<StudentBean> list = new ArrayList<StudentBean>();

			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				StudentBean studentBean = new StudentBean(
					 rs.getInt (1),
					 rs.getString (2),
					 rs.getString (3),
					 rs.getString (4)
					);
			
			list.add(studentBean);
		
			}
			return list;
	}

	public ArrayList<StudentMarksBean> addMarks(String branch,int year,String subject,int semester,ArrayList<StudentMarksBean> semesterMarks ) throws SQLException {
		
		ArrayList<StudentMarksBean> list = new ArrayList<StudentMarksBean>();
		Connection conn = getConnection();

		
		for (int i=0;i<semesterMarks.size();i++){
			
			StudentMarksBean marksBean = semesterMarks.get(i);
			
			 PreparedStatement pst = (PreparedStatement) conn
					.prepareStatement("SELECT MAX(id) AS id FROM studentmarks");

			ResultSet rs = pst.executeQuery();

			 int lastid = 0;
			 if(rs.next()){
			 lastid = rs.getInt("id");
			 }
			 			 
			 String query = "Insert into studentmarks values (?,?,?,?,?,?,?)";
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			 preparedStmt.setInt (1, lastid+1);
			 preparedStmt.setString (2, marksBean.getSubject());
			 preparedStmt.setInt (3, marksBean.getSemester());
			 preparedStmt.setInt (4, marksBean.getMarks1());
			 preparedStmt.setInt (5, marksBean.getMarks2());
			 preparedStmt.setInt (6, marksBean.getFinalmarks());
			 preparedStmt.setInt (7, marksBean.getStudentid());
			 preparedStmt.executeUpdate();
		}
		 conn.close();

		
		list = getStudentMarks( branch,  semester,
				subject, year);
		return list;
		
	}
	
	//Display Semester Marks
	
	public ArrayList getStudentMarks(String branch, int semester,
			String subject,int yearjoined) throws SQLException {
		
		String query =  "SELECT E.firstname, E.rollnumber, D.subject,D.semester,D.internal1,D.internal2,D.finalmarks,E.id,E.branch,E.yearjoined FROM aditya.students E, aditya.studentmarks D WHERE E.id  = D.studentid and yearjoined like ? and branch like ? and semester like ? and subject like ?";
			Connection conn = getConnection();

			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);
			preparedStmt.setString(1, "%" + yearjoined + "%");
			preparedStmt.setString(2, "%" + branch + "%");
			preparedStmt.setString(3, "%" + semester + "%");
			preparedStmt.setString(4, "%" + subject + "%");
			ArrayList<StudentMarksBean> list = new ArrayList<StudentMarksBean>();

			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
			StudentMarksBean marksBean = new StudentMarksBean(
					 rs.getString (1),
					 rs.getString (2),
					 rs.getString (3),
					 rs.getInt (4),
					 rs.getInt (5),
					 rs.getInt (6),
					 rs.getInt (7),
					 rs.getInt (8),
					 rs.getString(9),
					 rs.getInt(10)
					);
			
			list.add(marksBean);
		
			}
			return list;
		}
	
//Get Exam papers
	
		public ArrayList getExamPapers(int year,String branch,String subject) throws SQLException {
			
			String query = null;
				
			query =  "SELECT * from questionpapers where branch like ? and subject like ? and studyYear = ?";
			 
			
				Connection conn = getConnection();

				PreparedStatement preparedStmt = (PreparedStatement) conn
						.prepareStatement(query);
				preparedStmt.setString(1, "%" + branch + "%");
				preparedStmt.setString(2, "%" + subject + "%");
				preparedStmt.setInt(3,  year);
				

				ArrayList<QuestionBean> list = new ArrayList<QuestionBean>();

				ResultSet rs = preparedStmt.executeQuery();
				while (rs.next()) {
					QuestionBean marksBean = new QuestionBean(
						 rs.getInt (1),
						 rs.getString (2),
						 rs.getString (3),
						 rs.getInt (4),
						 rs.getString (5),
						 rs.getString (6),
						 rs.getInt (7)
						);
				
				list.add(marksBean);
			
				}
				return list;
			}

		public ArrayList<QuestionBean> getExamPaperQuestions(int id) throws SQLException {
			
			
			
			String query = 	"select * from aditya.questions where id IN (select questionid from aditya.examquestions where questionpaperid=?)";
			Connection conn = getConnection();

			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);

			preparedStmt.setInt(1,  id);
			

			ArrayList<QuestionBean> list = new ArrayList<QuestionBean>();

			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				QuestionBean marksBean = new QuestionBean(
					 rs.getInt(1),
					 rs.getInt(2),//year
					 rs.getString(3),//branch
					 rs.getString(4),//subject
					 rs.getString(8),//Question
					 rs.getString (9),//Answer
					 rs.getString(10),//type
					 rs.getInt(17)//semester
					);
			
			list.add(marksBean);
		
			}
			return list;
			
		}
	
	
}

