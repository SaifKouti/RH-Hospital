package assigmentTests;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Room;
import persistence.User;
import services.AssigmentServiceRemote;
import services.BasicOpsRemote;
import services.BookingServiceRemote;
import services.ReportingServiceRemote;

public class TestAssignRoomsToSuperviser {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("sigma-smart-safe-ear/sigma-smart-safe-ejb/BasicOps!services.BasicOpsRemote");
		AssigmentServiceRemote assigmentServiceRemote = (AssigmentServiceRemote) context
				.lookup("sigma-smart-safe-ear/sigma-smart-safe-ejb/AssigmentService!services.AssigmentServiceRemote");
		BookingServiceRemote bookingServiceRemote = (BookingServiceRemote) context
				.lookup("sigma-smart-safe-ear/sigma-smart-safe-ejb/BookingService!services.BookingServiceRemote");
		ReportingServiceRemote reportingServiceRemote = (ReportingServiceRemote) context
				.lookup("sigma-smart-safe-ear/sigma-smart-safe-ejb/ReportingService!services.ReportingServiceRemote");

		Room room = basicOpsRemote.findRoomById(1);
		Room room2 = basicOpsRemote.findRoomById(2);
		Room room3 = basicOpsRemote.findRoomById(3);

		List<Room> rooms = new ArrayList<>();
		rooms.add(room);
		rooms.add(room2);
		rooms.add(room3);

		for (Room r : rooms) {
			User supervisor = basicOpsRemote.findUserById(6);
			assigmentServiceRemote.assignSupervisorToRoom(supervisor, r);
		}

	}
}
