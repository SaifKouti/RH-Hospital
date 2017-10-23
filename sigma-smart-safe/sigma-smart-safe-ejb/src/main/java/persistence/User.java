package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToOne(mappedBy="patient")
	private Room patientsRoom;
	
	@OneToMany(mappedBy="supervisor")
	private List<Room> supervisedRooms;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Room getPatientsRoom() {
		return patientsRoom;
	}

	public void setPatientsRoom(Room patientsRoom) {
		this.patientsRoom = patientsRoom;
	}

	public List<Room> getSupervisedRooms() {
		return supervisedRooms;
	}

	public void setSupervisedRooms(List<Room> supervisedRooms) {
		this.supervisedRooms = supervisedRooms;
	}

	

}
