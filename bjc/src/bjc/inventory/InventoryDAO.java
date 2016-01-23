package bjc.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import bjc.student.ConnectionFactory;

public class InventoryDAO {
	Connection connection;
	Statement stmt;

	public InventoryDAO() {
	}

	private static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		Connection con = ConnectionFactory.getInstance().getConnection();
		return con;
	}

	public void addItem(InventoryBean invBean) {
		try {
			String query = " insert into inventory (ItemName,Type,Quantity,Cost,PurchaseDate,PurchasedBy,GivenBy,Remarks,EnteredDate)"
					+ " values (?, ?, ?, ?, ?,?,?,?,?)";
			connection = getConnection();
			java.sql.Date sysdate = new java.sql.Date(Calendar.getInstance()
					.getTime().getTime());
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, invBean.getName());
			preparedStmt.setString(2, invBean.getType());
			preparedStmt.setInt(3, invBean.getItemQuantity());
			preparedStmt.setInt(4, invBean.getItemCost());
			preparedStmt.setDate(5, invBean.getItemPurDate());
			preparedStmt.setString(6, invBean.getPurchasedBy());
			preparedStmt.setString(7, invBean.getMoneyGiven());
			preparedStmt.setString(8, invBean.getRemarks());
			preparedStmt.setDate(9, sysdate);
			preparedStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<InventoryBean> getItems(String startDate, String endDate,
			String type) {
		InventoryBean invBean = null;
		ArrayList<InventoryBean> list = new ArrayList<InventoryBean>();

		try {
			connection = getConnection();
			String query = " select * from inventory where PurchaseDate between ? and ? and Type like ?";
			PreparedStatement preparedStmt = connection.prepareStatement(query);

			preparedStmt.setString(1, startDate);
			preparedStmt.setString(2, endDate);
			preparedStmt.setString(3, "%" + type + "%");

			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				invBean = new InventoryBean(rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getInt(5), rs.getDate(6),
						rs.getString(7), rs.getString(8), rs.getString(9));
				list.add(invBean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}