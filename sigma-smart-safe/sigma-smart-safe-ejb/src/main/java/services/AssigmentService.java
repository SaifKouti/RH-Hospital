package services;

import javax.ejb.Stateless;

import persistence.Room;
import persistence.User;

/**
 * Session Bean implementation class AssigmentService
 */
@Stateless
public class AssigmentService implements AssigmentServiceRemote, AssigmentServiceLocal {

    /**
     * Default constructor. 
     */
    public AssigmentService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void assignPatientToRoom(User patient, Room room) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignSupervisorToRoom(User supervisor, Room room) {
		// TODO Auto-generated method stub
		
	}

}
