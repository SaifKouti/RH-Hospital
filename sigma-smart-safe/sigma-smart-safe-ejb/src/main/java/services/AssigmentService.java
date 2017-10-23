package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import persistence.Room;
import persistence.User;

/**
 * Session Bean implementation class AssigmentService
 */
@Stateless
public class AssigmentService implements AssigmentServiceRemote, AssigmentServiceLocal {
	@EJB
	private BasicOpsLocal basicOpsLocal;

	@EJB
	private ReportingServiceLocal reportingServiceLocal;

	/**
	 * Default constructor.
	 */
	public AssigmentService() {
	}

	@Override
	public void assignPatientToRoom(User patient, Room room) {
		room.setPatient(patient);
		basicOpsLocal.saveOrUpdateRoom(room);

	}

	@Override
	public void assignSupervisorToRoom(User supervisor, Room room) {
		room.setSupervisor(supervisor);

		basicOpsLocal.saveOrUpdateRoom(room);
	}

	@Override
	public void assingRoomsToSupervise(List<Room> rooms, User superviser) {

		List<Room> oldRooms = reportingServiceLocal.findRoomsBySupervisor(superviser.getId());
		for (Room r : rooms) {
			oldRooms.add(r);
		}
		superviser.linkRoomsToThisUser(oldRooms);

		basicOpsLocal.updateUser(superviser);
	}

}
