package services;

import java.util.Date;

import javax.ejb.Local;

import persistence.Equipement;
import persistence.Room;

@Local
public interface BookingServiceLocal {
	void bookEquipement(Equipement equipement, Room room, Date startDate, int nbDays);
}
