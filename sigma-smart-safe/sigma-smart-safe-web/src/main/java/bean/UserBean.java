package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.Patient;
import persistence.Room;
import services.AssigmentServiceLocal;
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
	@EJB
	private AssigmentServiceLocal assigmentServiceLocal;

	@PostConstruct
	private void init() {
		emptyRooms = reportingServiceLocal.findEmptyRooms();
		patients = basicOpsLocal.findAllPatients();
	}

	public void doShowPatientsList() {
		showPatientsList = true;
	}
	public Room dofindRoomByCode(String codeRoom) {
		return basicOpsLocal.findRoomByCodeRoom(codeRoom);
	}

	public void doShowNewPatient() {
		patient = new Patient();
		showPatientsList = true;
	}

	public void doAssignPatientToRoom() {
		assigmentServiceLocal.assignPatientToRoom(patient, roomSelected);
		init();
	}

	public void doSaveOrUpdatePatient() {
		basicOpsLocal.addUser(patient);
		showPatientsList = false;
		init();
	}

	public void doDeletePatient() {
		basicOpsLocal.deleteUser(patient);
		showPatientsList = false;
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
