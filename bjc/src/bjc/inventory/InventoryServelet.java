package bjc.inventory;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.ArrayList;
import java.util.Date;
/**
 * Servlet implementation class InventoryServelet
 */
public class InventoryServelet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryServelet() {
    	 super();
    	 System.out.println("First SOP");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InventoryBean invBean = new InventoryBean();
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int cost = Integer.parseInt(request.getParameter("cost"));
		String itemPurDate = request.getParameter("purDate");
		String purchasedBy = request.getParameter("purchasedBy");
		String enterBy = request.getParameter("enterBy");
		String moneyGiven = request.getParameter("moneyGiven"); //radio
		String itemRemarks = request.getParameter("itemRemarks");

		java.sql.Date sql = null;
		try {
			  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			  Date  parsed = format.parse(itemPurDate);
		         sql = new java.sql.Date(parsed.getTime());

		} catch (Exception e) {
			e.printStackTrace();
		}

		invBean.setType(type);
		invBean.setName(name);
		invBean.setItemQuantity(quantity);
		invBean.setItemCost(cost);
		invBean.setItemPurDate(sql);
		invBean.setPurchasedBy(purchasedBy);
		invBean.setEnterBy(enterBy);
		invBean.setMoneyGiven(moneyGiven);
		invBean.setRemarks(itemRemarks);
		
		InventoryDAO dao = new InventoryDAO();
		dao.addItem(invBean);
		ArrayList<InventoryBean> list = new ArrayList<InventoryBean>();
		list.add(invBean);
		String success = "/SearchInventory.jsp";
		request.setAttribute("inventory",list);
		request.getRequestDispatcher(success).forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
