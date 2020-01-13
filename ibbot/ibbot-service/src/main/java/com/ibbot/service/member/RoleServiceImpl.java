package com.ibbot.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.ibbot.domain.member.Role;
import com.ibbot.repository.member.RoleRepository;

public class RoleServiceImpl implements RoleService
{
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role getRole(long id) throws DataAccessException 
	{
		return roleRepository.findOne(id);
	}
}
