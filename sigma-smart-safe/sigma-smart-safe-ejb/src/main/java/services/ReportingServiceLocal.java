package services;

import javax.ejb.Local;

import persistence.Equipement;
import persistence.Room;
import persistence.TypeOfUser;

@Local
public interface ReportingServiceLocal {
	int findNumberOf(TypeOfUser typeOfUser);

	int findNbEmptyRooms();

	Equipement findTheMostRequestedEquipement();

	Room findTheAkalMostaamalaGhorfa();
}
