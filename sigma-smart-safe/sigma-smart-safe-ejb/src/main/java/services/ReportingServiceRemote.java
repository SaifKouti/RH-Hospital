package services;

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

}
