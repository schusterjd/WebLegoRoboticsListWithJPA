package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.Owner;
import model.SetItem;

/**
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		SetItemHelper sih = new SetItemHelper();
		OwnerHelper oh = new OwnerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = ldh.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String ownerName = request.getParameter("ownerName");
		Owner newOwner = oh.findOwner(ownerName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		try {
			
			String[] selectedSets = request.getParameterValues("allSetsToAdd");
			List<SetItem> selectedSetsInList = new ArrayList<SetItem>();
			
			for (int i = 0; i < selectedSets.length; i++) {
				
				System.out.println(selectedSets[i]);
				SetItem c = sih.searchById(Integer.parseInt(selectedSets[i]));
				selectedSetsInList.add(c);
				
			}
			listToUpdate.setListOfSets(selectedSetsInList);
			
		} catch (NullPointerException ex) {
			
			List<SetItem> selectedSetsInList = new ArrayList<SetItem>();
			listToUpdate.setListOfSets(selectedSetsInList);
			
		}
		
		listToUpdate.setSetName(newListName);
		listToUpdate.setOwnerDate(ld);
		listToUpdate.setOwner(newOwner);
		
		ldh.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
