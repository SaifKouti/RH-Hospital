package assigmentTests;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Equipement;
import persistence.Room;
import services.AssigmentServiceRemote;
import services.BasicOpsRemote;
import services.BookingServiceRemote;
import services.ReportingServiceRemote;

public class TestBookEquipment {
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

		Equipement equipement = new Equipement("scanner");
		
		Room room = basicOpsRemote.findRoomById(1);
		
		bookingServiceRemote.bookEquipement(equipement, room, new Date(), 5);
	}
}