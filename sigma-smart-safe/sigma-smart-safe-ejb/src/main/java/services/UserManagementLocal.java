package services;

import java.util.List;

import javax.ejb.Local;

import persistence.User;

@Local
public interface UserManagementLocal {
	void addUser(User user);

	void updateUser(User user);

	void deleteUserById(int id);

	void deleteUser(User user);

	User findUserById(int id);

	List<User> findAllUsers();
}
