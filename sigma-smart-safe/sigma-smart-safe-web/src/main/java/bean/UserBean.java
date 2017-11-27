package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.Patient;
import persistence.Room;
import persistence.User;
import services.BasicOpsLocal;
import services.ReportingServiceLocal;

@ManagedBean
@ViewScoped
public class UserBean {
	private Room roomSelected = new Room();
	private List<Room> emptyRooms = new ArrayList<>();
	private boolean showPatientsList = false;
	private Patient patient = new Patient();
	private List<Patient> patients = new ArrayList<>();

	@EJB
	private BasicOpsLocal basicOpsLocal;
	@EJB
	private ReportingServiceLocal reportingServiceLocal;

	@PostConstruct
	private void init() {
		emptyRooms = reportingServiceLocal.findEmptyRooms();
		List<User> users = basicOpsLocal.findAllUsers();
		for (User u : users) {
			if (u instanceof Patient) {
				if (!patients.contains(u)) {
					patients.add((Patient) u);
				}
			}

		}
	}

	public void doShowPatientsList() {
		showPatientsList = true;
	}

	public void doShowNewPatient() {
		patient = new Patient();
		showPatientsList = true;
	}
	public void doAssignPatientToRoom() {
		//TODO
	}
	public void doSaveOrUpdatePatient() {
		basicOpsLocal.addUser(patient);
		showPatientsList = false;
	}

	public void doDeletePatient() {
		basicOpsLocal.deleteUser(patient);
		showPatientsList = false;
		patients.remove(patient);
		init();
	}

	public void doCancel() {
		patient = new Patient();
		showPatientsList = false;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public boolean isShowPatientsList() {
		return showPatientsList;
	}

	public void setShowPatientsList(boolean showPatientsList) {
		this.showPatientsList = showPatientsList;
	}

	public List<Room> getEmptyRooms() {
		return emptyRooms;
	}

	public void setEmptyRooms(List<Room> emptyRooms) {
		this.emptyRooms = emptyRooms;
	}

	public Room getRoomSelected() {
		return roomSelected;
	}

	public void setRoomSelected(Room roomSelected) {
		this.roomSelected = roomSelected;
	}

}
