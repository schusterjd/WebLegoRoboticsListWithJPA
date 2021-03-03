/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Feb 10, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.SetItem;

public class SetItemHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("LegoRoboticsList");
	
	public SetItemHelper() {
			
	}
	
	/**
	 * Adds set.
	 * @param x set to add
	 */
	public void insertSet(SetItem x) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(x);
		em.getTransaction().commit();
		em.close();
		
	}
	
	/**
	 * Searches for set by name.
	 * @param setName name of set
	 * @return set
	 */
	public List<SetItem> searchByName(String setName) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SetItem> typedQuery = em.createQuery("SELECT i FROM SetItem i WHERE i.name = :selectedName", SetItem.class);
		typedQuery.setParameter("selectedName", setName);
		
		List<SetItem> locatedSets = typedQuery.getResultList();
		em.close();
		return locatedSets;
		
	}
	
	/**
	 * Searches for set by year.
	 * @param setYear year of set
	 * @return set
	 */
	public List<SetItem> searchByYear(String setYear) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SetItem> typedQuery = em.createQuery("SELECT i FROM SetItem i WHERE i.year = :selectedYear", SetItem.class);
		typedQuery.setParameter("selectedYear", setYear);
		
		List<SetItem> locatedSets = typedQuery.getResultList();
		em.close();
		return locatedSets;
		
	}
	
	/**
	 * Searches for set by ID.
	 * @param setId id of set
	 * @return set
	 */
	public SetItem searchById(int setId) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		SetItem located = em.find(SetItem.class, setId);
		em.close();
		return located;
		
	}
	
	/**
	 * Updates set
	 * @param setToEdit set to update
	 */
	public void updateSet(SetItem setToEdit) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(setToEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	/**
	 * Deletes set.
	 * @param x set to remove
	 */
	public void deleteSet(SetItem x) {
		
		// Find set
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SetItem> typedQuery = em.createQuery("SELECT i FROM SetItem i WHERE i.name = :selectedName and i.year = :selectedYear", SetItem.class);
		
		typedQuery.setParameter("selectedName", x.getName());
		typedQuery.setParameter("selectedYear", x.getYear());
		
		typedQuery.setMaxResults(1);
		
		SetItem result = typedQuery.getSingleResult();
		
		// Delete set
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	/**
	 * Retrieves all sets.
	 * @return all sets 
	 */
	public List<SetItem> retrieveAllSets() {
		
		EntityManager em = emfactory.createEntityManager();
		List<SetItem> allSets = em.createQuery("SELECT i FROM SetItem i").getResultList();
		return allSets;
		
	}
	
	/**
	 * Closes emfactory.
	 */
	public void cleanUp() {
		
		emfactory.close();
		
	}

}
