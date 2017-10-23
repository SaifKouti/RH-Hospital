package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	/**
	 * Default constructor.
	 */
	public ReportingService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int findNumberOf(TypeOfUser typeOfUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findNbEmptyRooms() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Equipement findTheMostRequestedEquipement() {
		// TODO Auto-generated method stub
		return null;
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

}
