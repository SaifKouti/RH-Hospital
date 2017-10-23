package services;

import javax.ejb.Stateless;

import persistence.Equipement;
import persistence.Room;
import persistence.TypeOfUser;

/**
 * Session Bean implementation class ReportingService
 */
@Stateless
public class ReportingService implements ReportingServiceRemote, ReportingServiceLocal {

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

}
