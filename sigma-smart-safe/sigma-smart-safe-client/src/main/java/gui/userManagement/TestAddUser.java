package gui.userManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Patient;
import persistence.Responsable;
import services.UserManagementRemote;

public class TestAddUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndi = "sigma-smart-safe-ear/sigma-smart-safe-ejb/UserManagement!services.UserManagementRemote";
		UserManagementRemote userManagementRemote = (UserManagementRemote) context.lookup(jndi);

		Patient patient = new Patient("ali", "123MT");
		Patient patient2 = new Patient("samia", "145FT");

		Responsable responsable = new Responsable("3am sala7", "kol chay");

		userManagementRemote.addUser(responsable);
		userManagementRemote.addUser(patient);
		userManagementRemote.addUser(patient2);

	}

}
