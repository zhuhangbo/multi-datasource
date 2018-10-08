package dev.local.multidatasource.service.impl;

import org.springframework.stereotype.Service;

import dev.local.multidatasource.configuration.datasource.DataSourceEnum;
import dev.local.multidatasource.configuration.datasource.TargetDataSource;
import dev.local.multidatasource.dao.mapper.UserMapper;
import dev.local.multidatasource.model.User;
import dev.local.multidatasource.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	@TargetDataSource(DataSourceEnum.PEOPLE_DS)
	public User getUserFromPeopleById(int id) {
		return userMapper.getUserById(id);
	}

	@Override
	public User getUserFromPersonById(int id) {
		return userMapper.getUserById(id);
	}

}
