package dev.local.multidatasource.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import dev.local.multidatasource.model.User;

@Mapper
public interface UserMapper {
	User getUserById(@Param("id") int id);
}
