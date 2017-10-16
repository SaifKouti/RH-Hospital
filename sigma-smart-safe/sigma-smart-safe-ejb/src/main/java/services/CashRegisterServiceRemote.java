package services;

import javax.ejb.Remote;

@Remote
public interface CashRegisterServiceRemote {
	void validateProductPurchase(String product, Integer quantity);

	void validateFinalPurchase();
}
