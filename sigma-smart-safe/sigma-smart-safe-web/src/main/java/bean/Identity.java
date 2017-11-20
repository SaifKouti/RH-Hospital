package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistence.Doctor;
import persistence.Patient;
import persistence.Responsable;
import persistence.User;
import services.BasicOpsLocal;

@ManagedBean
@SessionScoped
public class Identity {
	private User user = new User();
	private boolean loggedIn = false;

	@EJB
	private BasicOpsLocal basicOpsLocal;

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = basicOpsLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			loggedIn = true;
			if (userLoggedIn instanceof Doctor) {
				navigateTo = "/pages/doctor/home?faces-redirect=true";
			} else if (userLoggedIn instanceof Patient) {
				navigateTo = "/pages/patient/home?faces-redirect=true";
			} else if (userLoggedIn instanceof Responsable) {
				navigateTo = "/pages/responsable/home?faces-redirect=true";
			}
		} else {
			navigateTo = "/horror?faces-redirect=true";
		}

		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
