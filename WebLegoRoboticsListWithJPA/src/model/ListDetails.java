/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Mar 2, 2021
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_details")
public class ListDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String setName;
	@Column(name="OWNER_DATE")
	private LocalDate ownerDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="OWNER_ID")
	private Owner owner;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(name="sets_on_list", joinColumns= {@JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID")}, inverseJoinColumns= {@JoinColumn(name="SET_ID", referencedColumnName="ID", unique=true)})
	private List<SetItem> listOfSets;
	
	public ListDetails() {
		
	}

	public ListDetails(int id, String setName, LocalDate ownerDate, Owner owner, List<SetItem> listOfSets) {
		super();
		this.id = id;
		this.setName = setName;
		this.ownerDate = ownerDate;
		this.owner = owner;
		this.listOfSets = listOfSets;
	}

	public ListDetails(String setName, LocalDate ownerDate, Owner owner, List<SetItem> listOfSets) {
		super();
		this.setName = setName;
		this.ownerDate = ownerDate;
		this.owner = owner;
		this.listOfSets = listOfSets;
	}

	public ListDetails(String setName, LocalDate ownerDate, Owner owner) {
		super();
		this.setName = setName;
		this.ownerDate = ownerDate;
		this.owner = owner;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the setName
	 */
	public String getSetName() {
		return setName;
	}

	/**
	 * @param setName the setName to set
	 */
	public void setSetName(String setName) {
		this.setName = setName;
	}

	/**
	 * @return the ownerDate
	 */
	public LocalDate getOwnerDate() {
		return ownerDate;
	}

	/**
	 * @param ownerDate the ownerDate to set
	 */
	public void setOwnerDate(LocalDate ownerDate) {
		this.ownerDate = ownerDate;
	}

	/**
	 * @return the owner
	 */
	public Owner getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	/**
	 * @return the listOfSets
	 */
	public List<SetItem> getListOfSets() {
		return listOfSets;
	}

	/**
	 * @param listOfSets the listOfSets to set
	 */
	public void setListOfSets(List<SetItem> listOfSets) {
		this.listOfSets = listOfSets;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", setName=" + setName + ", ownerDate=" + ownerDate + ", owner=" + owner
				+ ", listOfSets=" + listOfSets + "]";
	}
	
}
