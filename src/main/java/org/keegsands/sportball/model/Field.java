package org.keegsands.sportball.model;

import jakarta.persistence.*;

@Entity
@Table(name = "field")
public class Field extends AbstractNamedEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Get the id of the entity
	 * 
	 * @return int id of the entity
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the id on the entity
	 * 
	 * @param id
	 *            int
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns a String with the id and name
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "id=" + getId() + ", name=" + getName();
	}

}
