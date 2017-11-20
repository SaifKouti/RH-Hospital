package persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import persistence.User;

/**
 * Entity implementation class for Entity: Patient
 *
 */
@Entity

public class Patient extends User implements Serializable {

	
	private String numCnam;
	private static final long serialVersionUID = 1L;

	public Patient() {
		super();
	}  
	

	public Patient(String name, String numCnam, String login, String password) {
		super(name, login, password);
		this.numCnam = numCnam;
	}


	public String getNumCnam() {
		return this.numCnam;
	}

	public void setNumCnam(String numCnam) {
		this.numCnam = numCnam;
	}
   
}
