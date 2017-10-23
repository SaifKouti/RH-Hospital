package services;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.BookinkDetails;
import persistence.Equipement;
import persistence.Room;

/**
 * Session Bean implementation class BookingService
 */
@Stateless
public class BookingService implements BookingServiceRemote, BookingServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public BookingService() {
	}

	@Override
	public void bookEquipement(Equipement equipement, Room room, Date startDate, int nbDays) {
		BookinkDetails bookinkDetails = new BookinkDetails(startDate, nbDays, entityManager.merge(equipement), room);

		entityManager.persist(bookinkDetails);
	}

}
