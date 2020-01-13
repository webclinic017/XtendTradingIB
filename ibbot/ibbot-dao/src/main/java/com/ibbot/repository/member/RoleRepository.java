package com.ibbot.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibbot.domain.member.Role;

public interface RoleRepository extends JpaRepository<Role, Long> 
{

}
