package dev.local.multidatasource.service;

import dev.local.multidatasource.model.User;

public interface UserService {
	public User getUserFromPeopleById(int id);

	public User getUserFromPersonById(int id);
}
