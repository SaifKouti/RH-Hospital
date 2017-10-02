package services;

import javax.ejb.Stateless;

@Stateless

public class CalculationService implements CalculationServiceRemote, CalculationServiceLocal {

	@Override
	public Integer sum(Integer a, Integer b) {
		return a + b;
	}

}
