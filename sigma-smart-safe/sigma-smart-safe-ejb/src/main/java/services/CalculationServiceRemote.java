package services;

import javax.ejb.Remote;

@Remote
public interface CalculationServiceRemote {

	Integer sum(Integer a, Integer b);

}
