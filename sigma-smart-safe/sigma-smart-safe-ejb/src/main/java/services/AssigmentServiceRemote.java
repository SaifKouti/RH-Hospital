package services;

import javax.ejb.Remote;

import persistence.Room;
import persistence.User;

@Remote
public interface AssigmentServiceRemote {
	void assignPatientToRoom(User patient, Room room);

	void assignSupervisorToRoom(User supervisor, Room room);
}
