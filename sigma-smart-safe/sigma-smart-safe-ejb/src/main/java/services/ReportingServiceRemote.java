package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Equipement;
import persistence.Room;
import persistence.TypeOfUser;

@Remote
public interface ReportingServiceRemote {
	int findNumberOf(TypeOfUser typeOfUser);

	int findNbEmptyRooms();

	Equipement findTheMostRequestedEquipement();

	Room findTheAkalMostaamalaGhorfa();

	List<Room> findRoomsBySupervisor(int id);

}
