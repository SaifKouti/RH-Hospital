package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.BookingDetails;
import persistence.Equipement;
import persistence.Room;
import persistence.TypeOfUser;

/**
 * Session Bean implementation class ReportingService
 */
@Stateless
public class ReportingService implements ReportingServiceRemote, ReportingServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private BasicOpsLocal basicOpsLocal;

	/**
	 * Default constructor.
	 */
	public ReportingService() {
	}

	@Override
	public long findNumberOf(TypeOfUser typeOfUser) {
		long nb = 0;
		switch (typeOfUser) {
		case DOCTOUR:
			String jpql = "SELECT COUNT(u)   FROM Doctor u ";
			Query query = entityManager.createQuery(jpql);

			nb = (long) query.getSingleResult();
			break;
		case KAWED:
			String jpql2 = "SELECT COUNT(u)   FROM Responsable u ";
			Query query2 = entityManager.createQuery(jpql2);

			nb = (long) query2.getSingleResult();
			break;
		case MRIDH:
			String jpql3 = "SELECT COUNT(u)   FROM Patient u ";
			Query query3 = entityManager.createQuery(jpql3);

			nb = (long) query3.getSingleResult();
			break;

		default:
			break;
		}

		return nb;

	}

	@Override
	public long findNbEmptyRooms() {
		String jpql = "SELECT COUNT(z)FROM Room z WHERE z.patient IS NULL";
		Query query = entityManager.createQuery(jpql);

		return (long) query.getSingleResult();
	}

	@Override
	public Equipement findTheMostRequestedEquipement() {
		Equipement equipement = null;
		List<BookingDetails> bookingDetails = basicOpsLocal.findAllBookinkDetails();
		int nbRequest = 0;

		return equipement;
	}

	@Override
	public Room findTheAkalMostaamalaGhorfa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> findRoomsBySupervisor(int id) {
		String jpql = "SELECT z FROM Room z WHERE z.supervisor.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);

		return query.getResultList();
	}

	@Override
	public List<Room> findEmptyRooms() {
		String jpql = "SELECT z FROM Room z WHERE z.patient IS NULL";
		Query query = entityManager.createQuery(jpql);

		return query.getResultList();
	}

}
