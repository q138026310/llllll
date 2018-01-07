package com.dlts.hrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlts.hrms.entity.User;
import com.dlts.hrms.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public User login(User pageUser){
		
		String password = pageUser.getPassword();
		
		pageUser.setPassword(null);
		User dbUser = userMapper.get(pageUser);
		
		if( dbUser!=null && !password.equals(dbUser.getPassword()) ){
			dbUser = null;
		}
		
		return dbUser;
	} 
}
