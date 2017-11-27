package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Equipement;
import persistence.Room;
import persistence.TypeOfUser;

@Local
public interface ReportingServiceLocal {
	long findNumberOf(TypeOfUser typeOfUser);

	long findNbEmptyRooms();

	Equipement findTheMostRequestedEquipement();

	Room findTheAkalMostaamalaGhorfa();

	List<Room> findRoomsBySupervisor(int id);
	
	List<Room> findEmptyRooms();
	
	
}
