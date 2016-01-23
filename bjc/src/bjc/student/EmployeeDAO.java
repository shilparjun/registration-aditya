package bjc.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 
public class EmployeeDAO {
    Connection connection;
    Statement stmt;
    private int noOfRecords;
         
    public EmployeeDAO() { }
     
    private static Connection getConnection() 
            throws SQLException, 
                ClassNotFoundException 
    {
        Connection con = ConnectionFactory.
                getInstance().getConnection();
        return con;
    }
     
    public List<StudentsBean> viewAllEmployees(
                int offset, 
                int noOfRecords)
    {
        String query = "select SQL_CALC_FOUND_ROWS * from student limit "
                 + offset + ", " + noOfRecords;
        List<StudentsBean> list = new ArrayList<StudentsBean>();
        StudentsBean employee = null;
        try {
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                employee = new StudentsBean();
                employee.setSno((rs.getString("sno")));
                employee.setFirstName(rs.getString("FirstNAme"));
                employee.setLastName(rs.getString("LastName"));
                employee.setStudentFees(rs.getInt("TutionFees"));
                list.add(employee);
            }
            rs.close();
             
            rs = stmt.executeQuery("SELECT FOUND_ROWS()");
            if(rs.next())
                this.noOfRecords = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally
        {
            try {
                if(stmt != null)
                    stmt.close();
                if(connection != null)
                    connection.close();
                } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
 
    public int getNoOfRecords() {
        return noOfRecords;
    }
}