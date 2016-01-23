package com.dmitrynikol.serlets;

import java.io.IOException;

import java.util.List;
import bjc.student.StudentsBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmitrynikol.dao.ProductDAO;
import com.dmitrynikol.util.Sorting;
import com.dmitrynikol.util.SortingType;

/**
 * Servlet implementation class ProductServlet.
 * 
 * @author Dmitry Nikolaenko
 *
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Sorting sortedPriceColumn = Sorting.ASC;
	private Sorting sortedNameColumn = Sorting.ASC;
	private Sorting activeSortingWay = Sorting.ASC;
	private SortingType activeSortingType = SortingType.FIRSTNAME;
	
    public ProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int activeGroupId = 0;
		int currentPage = 1;
        int recordsOnPage = 10;
        
        if (request.getParameter("page") != null) {
            currentPage = Integer.parseInt(request.getParameter("page"));
        }
        
        if (request.getParameter("desc") != null) {
        	activeSortingWay = Sorting.DESC;
        } else if (request.getParameter("asc") != null) {
        	activeSortingWay = Sorting.ASC;
        } 
        else {
        	activeSortingWay = Sorting.DEFAULT;
        }
        
        // reverse sort direction logic, for now it's only two possible way - sort by name or price
        String sortParam = request.getParameter(activeSortingWay.getType().toLowerCase());
        if (sortParam != null) {
        	activeSortingType = SortingType.safeValueOf(sortParam);
        	//activeSortingType = sortParam;
        	// verification for change the sorting of product name or product price 
        	if (SortingType.FIRSTNAME.equals(activeSortingType)) {
        		// check for the correct change sort direction
        		if (sortedNameColumn.equals(activeSortingWay)) {
        			sortedNameColumn = Sorting.reverse(sortedNameColumn);
        		}
        	} else if (SortingType.SECTION.equals(activeSortingType)) {
        		// check for the correct change sort direction
        		if (sortedPriceColumn.equals(activeSortingWay)) {
        			sortedPriceColumn = Sorting.reverse(sortedPriceColumn);
        		}
        	}
        }
        
     /*   GroupDAO groupDao = new GroupDAO();
        List<Group> groups = groupDao.viewAllGroup();
        request.setAttribute("groupList", groups);
        */
        
        ProductDAO dao = new ProductDAO();
        List<StudentsBean> list = dao.viewAllProducts(activeGroupId, (currentPage-1) * recordsOnPage, 
        		recordsOnPage, activeSortingWay, activeSortingType);
        int productCount = dao.getProductCount();
        int numberOfPages = (int) Math.ceil(productCount * 1.0 / recordsOnPage);
        
        request.setAttribute("productList", list);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("activeGroupId", activeGroupId);
        request.setAttribute("productCount", productCount);
        
        request.setAttribute("activeSortingWay", activeSortingWay.getType().toLowerCase());
        request.setAttribute("activeSortingType", activeSortingType.getValue());
        
        request.setAttribute("sortedPriceColumn", sortedPriceColumn.getType().toLowerCase());
        request.setAttribute("sortedNameColumn", sortedNameColumn.getType().toLowerCase());
        
        RequestDispatcher view = request.getRequestDispatcher("displayProduct.jsp");
        view.forward(request, response);
	}
}