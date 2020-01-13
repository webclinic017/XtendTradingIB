package com.ibbot.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ibbot.domain.member.User;
import com.ibbot.repository.member.UserRepository;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUser(long id) throws DataAccessException 
	{
		return userRepository.findOne(id);
	}
}
