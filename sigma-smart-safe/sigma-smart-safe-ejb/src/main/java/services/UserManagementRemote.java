package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.User;

@Remote
public interface UserManagementRemote {
	void addUser(User user);

	void updateUser(User user);

	void deleteUserById(int id);

	void deleteUser(User user);

	User findUserById(int id);

	List<User> findAllUsers();
}
