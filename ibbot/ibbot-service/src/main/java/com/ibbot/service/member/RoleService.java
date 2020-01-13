package com.ibbot.service.member;

import org.springframework.dao.DataAccessException;

import com.ibbot.domain.member.Role;

public interface RoleService 
{
	Role getRole(long id) throws DataAccessException;
}
