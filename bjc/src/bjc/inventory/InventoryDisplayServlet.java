package bjc.inventory;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class InventoryDisplayServlet
 */
public class InventoryDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryDisplayServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<InventoryBean> list = new ArrayList<InventoryBean>();
        String type = request.getParameter("itemNames");    
        String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		 if (type.equals("All")) {
			 type = "";
		 }

		InventoryDAO dao = new InventoryDAO();
		list = dao.getItems(startDate,endDate,type);
		String success = "/SearchInventory.jsp";
		request.setAttribute("inventory",list);
		request.getRequestDispatcher(success).forward(request, response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	

}
}
