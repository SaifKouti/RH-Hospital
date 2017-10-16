package services;

import javax.ejb.Stateless;

@Stateless

public class CalculationService implements CalculationServiceRemote, CalculationServiceLocal {

	@Override
	public Integer sum(Integer a, Integer b) {
		return a + b;
	}

	@Override
	public Integer multiply(Integer a, Integer b) {
		return a * b;
	}

	@Override
	public Integer substract(Integer a, Integer b) {
		return a - b;
	}

	@Override
	public Double divide(Integer a, Integer b) {
		Double result = null;
		if (b != 0) {
			result = (new Double(a)) / (new Double(b));
		} else {
			System.out.println("error number given = 0");
		}
		return result;
	}

}
