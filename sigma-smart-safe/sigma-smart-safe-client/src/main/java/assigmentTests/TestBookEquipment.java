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

		Equipement equipement = new Equipement("mkhadda");
		Equipement equipement2 = basicOpsRemote.findEquipementById(1);
		Equipement equipement3 = basicOpsRemote.findEquipementById(3);

		Room room = basicOpsRemote.findRoomById(1);
		Room room2 = basicOpsRemote.findRoomById(2);
		Room room3 = basicOpsRemote.findRoomById(3);

		bookingServiceRemote.bookEquipement(equipement, room, new Date(), 5);
		bookingServiceRemote.bookEquipement(equipement, room2, new Date(), 5);
		bookingServiceRemote.bookEquipement(equipement2, room2, new Date(), 5);
		bookingServiceRemote.bookEquipement(equipement, room3, new Date(), 5);
		bookingServiceRemote.bookEquipement(equipement2, room3, new Date(), 5);
		bookingServiceRemote.bookEquipement(equipement3, room3, new Date(), 5);
	}
}
