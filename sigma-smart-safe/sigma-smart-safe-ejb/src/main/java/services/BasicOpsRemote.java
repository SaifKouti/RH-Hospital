package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Equipement;
import persistence.Room;
import persistence.User;

@Remote
public interface BasicOpsRemote {
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

}
