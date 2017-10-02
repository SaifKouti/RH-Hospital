package services;

import javax.ejb.Local;

@Local
public interface CalculationServiceLocal {
	Integer sum(Integer a, Integer b);
}
