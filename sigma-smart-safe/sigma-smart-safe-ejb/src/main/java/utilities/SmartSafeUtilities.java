package utilities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import persistence.Doctor;
import persistence.Equipement;
import persistence.Patient;
import persistence.Responsable;
import persistence.Room;
import services.BasicOpsLocal;

/**
 * Session Bean implementation class SmartSafeUtilities
 */
@Singleton
@LocalBean
@Startup
public class SmartSafeUtilities {
	@EJB
	private BasicOpsLocal basicOpsLocal;

	/**
	 * Default constructor.
	 */
	public SmartSafeUtilities() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		Patient patient = new Patient("azmi", "123MT");
		Patient patient2 = new Patient("nada", "129FT");
		Patient patient3 = new Patient("kouti", "605MT");

		Doctor doctor = new Doctor("sliman", "psychologist");

		Responsable responsable = new Responsable("khalil", "louta");
		Responsable responsable2 = new Responsable("moufida", "elfoo9");

		Room room = new Room(20, "red");
		Room room2 = new Room(30, "green");
		Room room3 = new Room(40, "blue");
		Room room4 = new Room(50, "yellow");
		Room room5 = new Room(60, "black");

		Equipement equipement = new Equipement("scanner");
		Equipement equipement2 = new Equipement("radio");
		Equipement equipement3 = new Equipement("TV");

		basicOpsLocal.addUser(patient);
		basicOpsLocal.addUser(patient2);
		basicOpsLocal.addUser(patient3);
		basicOpsLocal.addUser(doctor);
		basicOpsLocal.addUser(responsable2);
		basicOpsLocal.addUser(responsable);

		basicOpsLocal.saveOrUpdateRoom(room5);
		basicOpsLocal.saveOrUpdateRoom(room4);
		basicOpsLocal.saveOrUpdateRoom(room3);
		basicOpsLocal.saveOrUpdateRoom(room2);
		basicOpsLocal.saveOrUpdateRoom(room);

		basicOpsLocal.saveOrUpdateEqipement(equipement);
		basicOpsLocal.saveOrUpdateEqipement(equipement2);
		basicOpsLocal.saveOrUpdateEqipement(equipement3);

	}

}
