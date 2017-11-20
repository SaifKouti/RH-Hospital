package persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import persistence.User;

/**
 * Entity implementation class for Entity: Doctor
 *
 */
@Entity

public class Doctor extends User implements Serializable {

	
	private String speciality;
	private static final long serialVersionUID = 1L;

	public Doctor() {
		super();
	}   
	

	public Doctor(String name, String speciality, String login, String password) {
		super(name, login, password);
		this.speciality = speciality;
	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
   
}
