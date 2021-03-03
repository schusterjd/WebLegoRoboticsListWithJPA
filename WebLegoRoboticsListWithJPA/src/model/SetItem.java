/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Feb 10, 2021
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class SetItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="YEAR")
	private String year;
	
	public SetItem() {
		super();
		
	}
	
	public SetItem(String name, String year) {
		
		super();
		this.name = name;
		this.year = year;
		
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Returns name and year.
	 * @return name and year
	 */
	public String getSetDetails() {
		
		return name + ": " + year;
		
	}
	
	@Override
	public String toString() {
		return "SetItem [id=" + id + ", name=" + name + ", year=" + year + "]";
	}
	
}
