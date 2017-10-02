package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.CalculationServiceRemote;

public class TestCalculationService {

	public static void main(String[] args) throws NamingException {
		// creation of the naming context
		Context context;
		// initiate the naming context with the JNDI directory
		context = new InitialContext();
		// request for proxy injection from the container with the loocup method
		// and through the business interface Remote
		String jndiName = "sigma-smart-safe-ear/sigma-smart-safe-ejb/CalculationService!services.CalculationServiceRemote";
		CalculationServiceRemote calculationServiceRemote = (CalculationServiceRemote) context.lookup(jndiName);
		// call the services
		System.out.println(calculationServiceRemote.sum(1, 8));
	}

}
