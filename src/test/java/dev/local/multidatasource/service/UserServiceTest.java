package dev.local.multidatasource.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dev.local.multidatasource.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	public void testGetUserFromPersonById() {
		int id = 1;

		User user = userService.getUserFromPersonById(id);

		assertEquals("Tom", user.getFirstName());
	}

	@Test
	public void testGetUserFromPeopleById() {
		int id = 1;
		User user = userService.getUserFromPeopleById(id);

		assertEquals("Tommy", user.getFirstName());
	}

}
