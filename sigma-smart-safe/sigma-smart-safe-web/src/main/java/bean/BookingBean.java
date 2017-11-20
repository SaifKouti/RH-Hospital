package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.Equipement;
import persistence.Room;
import services.BasicOpsLocal;
import services.BookingServiceLocal;

@ManagedBean
@ViewScoped
public class BookingBean {
	private Date startDate;
	private int nbDays;
	private int idEquipementSelected;
	private List<Equipement> equipements = new ArrayList<>();
	private boolean showDetails = false;
	private Room roomSelected = new Room();
	private List<Room> rooms = new ArrayList<>();
	@EJB
	BasicOpsLocal basicOpsLocal;
	@EJB
	private BookingServiceLocal bookingServiceLocal;

	@PostConstruct
	public void init() {
		equipements = basicOpsLocal.findEquipements();
		rooms = basicOpsLocal.findAllRooms();
	}

	public void doSelect() {
		showDetails = true;
	}

	public void doCancel() {
		showDetails = false;
	}

	public void doBookEquipement() {
		Equipement equipement = basicOpsLocal.findEquipementById(idEquipementSelected);
		;
		bookingServiceLocal.bookEquipement(equipement, roomSelected, startDate, nbDays);
		showDetails = false;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Room getRoomSelected() {
		return roomSelected;
	}

	public void setRoomSelected(Room roomSelected) {
		this.roomSelected = roomSelected;
	}

	public boolean isShowDetails() {
		return showDetails;
	}

	public void setShowDetails(boolean showDetails) {
		this.showDetails = showDetails;
	}

	public List<Equipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}

	public int getIdEquipementSelected() {
		return idEquipementSelected;
	}

	public void setIdEquipementSelected(int idEquipementSelected) {
		this.idEquipementSelected = idEquipementSelected;
	}

	public int getNbDays() {
		return nbDays;
	}

	public void setNbDays(int nbDays) {
		this.nbDays = nbDays;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
