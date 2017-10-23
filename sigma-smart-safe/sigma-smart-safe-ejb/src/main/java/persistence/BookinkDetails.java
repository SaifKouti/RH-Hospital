package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: BookinkDetails
 *
 */
@Entity

public class BookinkDetails implements Serializable {

	@EmbeddedId
	private BookingDetailsId bookingDetailsId;
	private Date startDate;
	private int nbDate;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "equipementId", referencedColumnName = "id", insertable = false, updatable = false)
	private Equipement equipement;

	@ManyToOne
	@JoinColumn(name = "roomId", referencedColumnName = "id", insertable = false, updatable = false)
	private Room room;
	private static final long serialVersionUID = 1L;

	public BookinkDetails() {
		super();
	}

	public BookinkDetails(Date startDate, int nbDate, Equipement equipement, Room room) {
		super();
		this.bookingDetailsId = new BookingDetailsId(equipement.getId(), room.getId());
		this.startDate = startDate;
		this.nbDate = nbDate;
		this.equipement = equipement;
		this.room = room;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getNbDate() {
		return this.nbDate;
	}

	public void setNbDate(int nbDate) {
		this.nbDate = nbDate;
	}

	public Equipement getEquipement() {
		return equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
