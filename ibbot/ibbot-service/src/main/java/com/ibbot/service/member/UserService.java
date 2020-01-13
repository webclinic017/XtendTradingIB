package com.ibbot.service.member;

import org.springframework.dao.DataAccessException;

import com.ibbot.domain.member.User;

public interface UserService 
{
	User getUser(long id) throws DataAccessException;
}
