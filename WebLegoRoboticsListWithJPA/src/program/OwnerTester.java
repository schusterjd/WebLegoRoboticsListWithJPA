/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Mar 2, 2021
 */
package program;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.OwnerHelper;
import model.ListDetails;
import model.Owner;
import model.SetItem;

public class OwnerTester {

	public static void main(String[] args) {

		Owner bill = new Owner("Bill");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		SetItem EV3 = new SetItem("EV3", "2015");
		SetItem RCX = new SetItem("RCX", "1990");
		
		List<SetItem> billsSets = new ArrayList<SetItem>();
		billsSets.add(EV3);
		billsSets.add(RCX);
		
		ListDetails billsList = new ListDetails("Bill's Sets", LocalDate.now(), bill);
		
		ldh.insertNewListDetails(billsList);
		
		List<ListDetails> allLists = ldh.getLists();
		
		for (ListDetails a : allLists) {
			System.out.println(a.toString());
		}
		
	}

}
