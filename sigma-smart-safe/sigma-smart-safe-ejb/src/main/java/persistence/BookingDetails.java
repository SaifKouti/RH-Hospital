package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: BookinkDetails
 *
 */
@Entity

public class BookingDetails implements Serializable {

	@EmbeddedId
	private BookingDetailsId bookingDetailsId;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	private int nbDate;
	@Enumerated(EnumType.STRING)
	private BookingRequestStatus bookingRequestStatus;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "equipementId", referencedColumnName = "id", insertable = false, updatable = false)
	private Equipement equipement;

	@ManyToOne
	@JoinColumn(name = "roomId", referencedColumnName = "id", insertable = false, updatable = false)
	private Room room;
	private static final long serialVersionUID = 1L;

	public BookingDetails() {
		super();
	}

	public BookingDetails(Date startDate, int nbDate, Equipement equipement, Room room) {
		super();
		this.bookingDetailsId = new BookingDetailsId(equipement.getId(), room.getId());
		this.startDate = startDate;
		this.nbDate = nbDate;
		this.equipement = equipement;
		this.room = room;
		this.bookingRequestStatus = BookingRequestStatus.NEW;
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

	public BookingRequestStatus getBookingRequestStatus() {
		return bookingRequestStatus;
	}

	public void setBookingRequestStatus(BookingRequestStatus bookingRequestStatus) {
		this.bookingRequestStatus = bookingRequestStatus;
	}

}
