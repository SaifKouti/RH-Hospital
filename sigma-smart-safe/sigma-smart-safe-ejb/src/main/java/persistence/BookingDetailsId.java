package persistence;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable

@SuppressWarnings("serial")
public class BookingDetailsId implements Serializable {
	private int equipementId;
	private int roomId;

	public BookingDetailsId(int equipementId, int roomId) {
		super();
		this.equipementId = equipementId;
		this.roomId = roomId;
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

}
