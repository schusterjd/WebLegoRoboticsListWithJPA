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
 * Servlet implementation class EditSetServlet
 */
@WebServlet("/editSetServlet")
public class EditSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SetItemHelper sih = new SetItemHelper();
		
		String set = request.getParameter("set");
		String year = request.getParameter("year");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		SetItem setToUpdate = sih.searchById(tempId);
		setToUpdate.setName(set);
		setToUpdate.setYear(year);
		
		sih.updateSet(setToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllSetsServlet").forward(request, response);
		
	}

}
