package services;

import javax.ejb.Remote;

@Remote
public interface CalculationServiceRemote {

	Integer sum(Integer a, Integer b);

	Integer multiply(Integer a, Integer b);

	Integer substract(Integer a, Integer b);

	Double divide(Integer a, Integer b);

}
