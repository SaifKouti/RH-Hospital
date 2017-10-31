package assigmentTests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.BookingDetails;
import persistence.BookingRequestStatus;
import services.AssigmentServiceRemote;
import services.BasicOpsRemote;
import services.BookingServiceRemote;
import services.ReportingServiceRemote;

public class TestTreatBookingEquipment {
	public static void main(String[] args) throws NamingException, ParseException {

		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("sigma-smart-safe-ear/sigma-smart-safe-ejb/BasicOps!services.BasicOpsRemote");
		AssigmentServiceRemote assigmentServiceRemote = (AssigmentServiceRemote) context
				.lookup("sigma-smart-safe-ear/sigma-smart-safe-ejb/AssigmentService!services.AssigmentServiceRemote");
		BookingServiceRemote bookingServiceRemote = (BookingServiceRemote) context
				.lookup("sigma-smart-safe-ear/sigma-smart-safe-ejb/BookingService!services.BookingServiceRemote");
		ReportingServiceRemote reportingServiceRemote = (ReportingServiceRemote) context
				.lookup("sigma-smart-safe-ear/sigma-smart-safe-ejb/ReportingService!services.ReportingServiceRemote");

		BookingDetails bookingDetails = basicOpsRemote.findBookinkDetailsById(1, 1,
				new SimpleDateFormat("yyyy-MM-dd").parse("2017-10-26"));
		
		bookingServiceRemote.treatBookingRequest(bookingDetails, BookingRequestStatus.ACCEPTED);
	}
}
