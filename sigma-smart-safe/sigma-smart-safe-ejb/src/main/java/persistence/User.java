package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String login;
	private String password;

	@OneToOne(mappedBy = "patient")
	private Room patientsRoom;

	@OneToMany(mappedBy = "supervisor", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Room> supervisedRooms;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	

	public User(String name, String login, String password) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
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

	public void linkRoomsToThisUser(List<Room> rooms) {
		this.supervisedRooms = rooms;
		for (Room r : rooms) {
			r.setSupervisor(this);
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
