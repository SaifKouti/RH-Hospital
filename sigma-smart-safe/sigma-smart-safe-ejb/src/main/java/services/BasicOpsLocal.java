package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import persistence.BookingDetails;
import persistence.Equipement;
import persistence.Room;
import persistence.User;

@Local
public interface BasicOpsLocal {
	void addUser(User user);

	void updateUser(User user);

	void deleteUserById(int id);

	void deleteUser(User user);

	User findUserById(int id);

	List<User> findAllUsers();

	void saveOrUpdateRoom(Room room);

	Room findRoomById(int id);

	void saveOrUpdateEqipement(Equipement equipement);

	Equipement findEquipementById(int id);

	void saveOrUpdateBookinkDetails(BookingDetails bookingDetails);

	BookingDetails findBookinkDetailsById(int equipementId, int roomId, Date dateOfBooking);

	List<BookingDetails> findAllBookinkDetails();

	User login(String login, String password);

	List<Room> findAllRooms();

	List<Equipement> findEquipements();
}
