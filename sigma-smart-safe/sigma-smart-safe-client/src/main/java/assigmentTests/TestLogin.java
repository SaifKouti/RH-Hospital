package assigmentTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.User;
import services.AssigmentServiceRemote;
import services.BasicOpsRemote;
import services.BookingServiceRemote;
import services.ReportingServiceRemote;

public class TestLogin {
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

		User user = basicOpsRemote.login("s", "s");

		System.out.println(user.getName());
	}
}
