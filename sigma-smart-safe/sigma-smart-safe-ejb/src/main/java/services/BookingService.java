package services;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.BookingRequestStatus;
import persistence.BookingDetails;
import persistence.Equipement;
import persistence.Room;

/**
 * Session Bean implementation class BookingService
 */
@Stateless
public class BookingService implements BookingServiceRemote, BookingServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private BasicOpsLocal basicOpsLocal;

	/**
	 * Default constructor.
	 */
	public BookingService() {
	}

	@Override
	public void bookEquipement(Equipement equipement, Room room, Date startDate, int nbDays) {
		BookingDetails bookingDetails = new BookingDetails(startDate, nbDays, entityManager.merge(equipement), room);

		entityManager.merge(bookingDetails);
	}

	@Override
	public void treatBookingRequest(BookingDetails bookingDetails, BookingRequestStatus bookingRequestStatus) {
		bookingDetails.setBookingRequestStatus(bookingRequestStatus);

		basicOpsLocal.saveOrUpdateBookinkDetails(bookingDetails);

	}

}
