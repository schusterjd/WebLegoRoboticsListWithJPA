/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Feb 10, 2021
 */
package program;

import java.util.List;
import java.util.Scanner;

import controller.SetItemHelper;
import model.SetItem;

public class Menu {

	static Scanner in = new Scanner(System.in);
	static SetItemHelper sih = new SetItemHelper();
	
	public static void main(String[] args) {
		
		// Menu
		boolean con = false;
		while (!con) {
			
			System.out.println("Select an item:");
			System.out.println("a -- Add an item");
			System.out.println("e -- Edit an item");
			System.out.println("d -- Delete an item");
			System.out.println("v -- View the list");
			System.out.println("x -- Exit the program");
			System.out.print("Choice: ");
			String choice = in.nextLine();
			
			if (choice.equals("a")) {
				addSet();
			} else if (choice.equals("e")) {
				editSet();
			} else if (choice.equals("d")) {
				deleteSet();
			} else if (choice.equals("v")) {
				viewSets();
			} else if (choice.equals("x")) {
				
				exitProgram();
				con = true;
				System.out.println("Program closed");
				
			} else {
				System.out.println("Error! Not a choice!");
			}
			
		}

	}

	/**
	 * Closes program
	 */
	private static void exitProgram() {

		System.out.println("Closing program...");
		sih.cleanUp();
		
	}

	/**
	 * Displays all sets.
	 */
	private static void viewSets() {

		List<SetItem> allSets = sih.retrieveAllSets();
		for (SetItem singleSet : allSets) {
			System.out.println(singleSet.getSetDetails());
		}
		
	}

	/**
	 * Deletes set.
	 */
	private static void deleteSet() {

		System.out.print("Enter the set to delete: ");
		String set = in.nextLine();
		System.out.print("Enter the year to delete: ");
		String year = in.nextLine();
		SetItem toRemove = new SetItem(set, year);
		sih.deleteSet(toRemove);
		
	}

	/**
	 * Edits a set.
	 */
	private static void editSet() {

		// Gather search preference
		System.out.println("How would you like to search?");
		System.out.println("s : Search by Set");
		System.out.println("y : Search by Year");
		String choice = in.nextLine();
		
		// Search for set
		List<SetItem> locatedSets = null;
		boolean con = false;
		while (!con) {
			
			if (choice.equals("s")) {
				
				System.out.print("Enter the set name: ");
				String setName = in.nextLine();
				locatedSets = sih.searchByName(setName);
				con = true;
				
			} else if (choice.equals("y")) {
				
				System.out.print("Enter the year: ");
				String setYear = in.nextLine();
				locatedSets = sih.searchByYear(setYear);
				con = true;
				
			} else {
				
				System.out.print("Error! Not a choice! Try again:");
				choice = in.nextLine();
				
			}
			
		}
		
		// Update set if found
		if (!locatedSets.isEmpty()) {
			
			System.out.println("Founds Results.");
			for (SetItem i : locatedSets) {
				System.out.println(i.getId() + " : " + i.toString());
			}
			
			System.out.print("Which ID to edit: ");
			int idEdit = in.nextInt();
			
			SetItem edit = sih.searchById(idEdit);
			System.out.println("Retrieved " + edit.getName() + " from " + edit.getYear());
			System.out.println("s : Update Set");
			System.out.println("y : Update Year");
			System.out.print("Choice: ");
			in.nextLine();
			String update = in.nextLine();
			
			con = false;
			while (!con) {
				
				if (update.equals("s")) {
					
					System.out.print("New Set: ");
					String newSet = in.nextLine();
					edit.setName(newSet);
					con = true;
					
				} else if (update.equals("y")) {
					
					System.out.print("New Year: ");
					String newYear = in.nextLine();
					edit.setYear(newYear);
					con = true;
					
				} else {
					
					System.out.print("Error! Not a choice! Try again: ");
					update = in.nextLine();
					in.nextLine();
					
				}
			
			}
			
			sih.updateSet(edit);
			
		} else {
			System.out.println("No results");
		}
		
	}

	/**
	 * Add set.
	 */
	private static void addSet() {

		System.out.print("Enter a set: ");
		String set = in.nextLine();
		System.out.print("Enter the release year: ");
		String year = in.nextLine();
		SetItem add = new SetItem(set, year);
		sih.insertSet(add);
		
	}

}
