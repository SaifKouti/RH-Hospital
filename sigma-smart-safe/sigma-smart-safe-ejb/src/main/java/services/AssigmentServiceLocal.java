package services;

import javax.ejb.Local;

import persistence.Room;
import persistence.User;

@Local
public interface AssigmentServiceLocal {
	void assignPatientToRoom(User patient, Room room);

	void assignSupervisorToRoom(User supervisor, Room room);
}
