package services;

import java.util.Date;

import javax.ejb.Remote;

import persistence.BookingRequestStatus;
import persistence.BookingDetails;
import persistence.Equipement;
import persistence.Room;

@Remote
public interface BookingServiceRemote {
	void bookEquipement(Equipement equipement, Room room, Date startDate, int nbDays);

	void treatBookingRequest(BookingDetails bookingDetails, BookingRequestStatus bookingRequestStatus);
}
