/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Feb 21, 2021
 */

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SetItem;

/**
 * Servlet implementation class AddSetServlet
 */
@WebServlet("/addSetServlet")
public class AddSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String set = request.getParameter("set");
		String year = request.getParameter("year");
		
		SetItem si = new SetItem(set, year);
		SetItemHelper sih = new SetItemHelper();
		sih.insertSet(si);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
