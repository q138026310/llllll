package com.dlts.hrms.mapper;

import java.util.List;

import com.dlts.hrms.entity.User;

public interface UserMapper {
	
	public List<User> find(User user);
	
	public User get(User user);

}
