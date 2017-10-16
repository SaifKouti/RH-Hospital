package services;

import java.util.Map;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class CashRegisterService
 */
@Stateful
public class CashRegisterService implements CashRegisterServiceRemote, CashRegisterServiceLocal {
	private Map<String, Integer> products;

	/**
	 * Default constructor.
	 */
	public CashRegisterService() {
	}

	public Map<String, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<String, Integer> products) {
		this.products = products;
	}

	@Override
	public void validateProductPurchase(String product, Integer quantity) {
		products.put(product, quantity);
	}

	@Override
	public void validateFinalPurchase() {
		for (Map.Entry<String, Integer> entry : products.entrySet()) {
			System.out.println(entry.getKey() + "/" + entry.getValue());
		}

	}

}
