package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.BookingDetails;
import persistence.BookingDetailsId;
import persistence.Equipement;
import persistence.Patient;
import persistence.Room;
import persistence.User;

/**
 * Session Bean implementation class BasicOps
 */
@Stateless
public class BasicOps implements BasicOpsRemote, BasicOpsLocal {

	/**
	 * Default constructor.
	 */
	public BasicOps() {
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addUser(User user) {
		entityManager.merge(user);

	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void deleteUserById(int id) {
		entityManager.remove(findUserById(id));
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(entityManager.merge(user));
	}

	@Override
	public User findUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> findAllUsers() {
		String jpql = "SELECT u FROM User u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Room findRoomById(int id) {
		return entityManager.find(Room.class, id);
	}

	@Override
	public Equipement findEquipementById(int id) {
		return entityManager.find(Equipement.class, id);
	}

	@Override
	public void saveOrUpdateRoom(Room room) {
		entityManager.merge(room);
	}

	@Override
	public void saveOrUpdateEqipement(Equipement equipement) {
		entityManager.merge(equipement);
	}

	@Override
	public void saveOrUpdateBookinkDetails(BookingDetails bookingDetails) {
		entityManager.merge(bookingDetails);
	}

	@Override
	public BookingDetails findBookinkDetailsById(int equipementId, int roomId, Date dateOfBooking) {
		return entityManager.find(BookingDetails.class, new BookingDetailsId(equipementId, roomId, dateOfBooking));
	}

	@Override
	public List<BookingDetails> findAllBookinkDetails() {
		String jpql = "SELECT u FROM BookingDetails u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public void saveOrUpdateEquipement(Equipement equipement) {
		entityManager.merge(equipement);

	}

	@Override
	public User login(String login, String password) {
		User user = null;
		String jpql = "SELECT u FROM User u WHERE u.login=:login AND u.password=:password";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.err.println(e);
		}
		return user;
	}

	@Override
	public List<Room> findAllRooms() {
		return entityManager.createQuery("SELECT r FROM Room r").getResultList();
	}

	@Override
	public List<Equipement> findEquipements() {
		return entityManager.createQuery("SELECT r FROM Equipement r").getResultList();
	}

	@Override
	public List<Patient> findAllPatients() {
		return entityManager.createQuery("SELECT r FROM Patient r", Patient.class).getResultList();
	}
}
