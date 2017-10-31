package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable

@SuppressWarnings("serial")
public class BookingDetailsId implements Serializable {
	private int equipementId;
	private int roomId;
	@Temporal(TemporalType.DATE)
	private Date dateOfBooking;

	public BookingDetailsId(int equipementId, int roomId) {
		super();
		this.equipementId = equipementId;
		this.roomId = roomId;
		this.dateOfBooking = new Date();
	}

	public BookingDetailsId(int equipementId, int roomId, Date date) {
		super();
		this.equipementId = equipementId;
		this.roomId = roomId;
		this.dateOfBooking = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + equipementId;
		result = prime * result + roomId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingDetailsId other = (BookingDetailsId) obj;
		if (equipementId != other.equipementId)
			return false;
		if (roomId != other.roomId)
			return false;
		return true;
	}

	public BookingDetailsId() {
	}

	public int getEquipementId() {
		return equipementId;
	}

	public void setEquipementId(int equipementId) {
		this.equipementId = equipementId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

}
