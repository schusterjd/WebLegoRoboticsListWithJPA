package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		String act = request.getParameter("doThisToList");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		} else if (act.equals("delete")) {
			
			try {
				
				Integer tempId =  Integer.parseInt(request.getParameter("id"));
				ListDetails listToDelete = ldh.searchForListDetailsById(tempId);
				ldh.deleteList(listToDelete);
				
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
			
		} else if (act.equals("edit")) {
			
			try {
				
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToEdit = ldh.searchForListDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				
				request.setAttribute("month", listToEdit.getOwnerDate().getMonthValue());
				request.setAttribute("date", listToEdit.getOwnerDate().getDayOfMonth());
				request.setAttribute("year", listToEdit.getOwnerDate().getYear());
				
				SetItemHelper sihForItems = new SetItemHelper();
				
				request.setAttribute("allSets", sihForItems.retrieveAllSets());
				
				if (sihForItems.retrieveAllSets().isEmpty()) {
					request.setAttribute("allSets", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
				
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
			
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/addSetsForListServlet").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
