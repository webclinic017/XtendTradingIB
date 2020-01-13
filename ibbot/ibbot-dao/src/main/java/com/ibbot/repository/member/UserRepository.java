package com.ibbot.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibbot.domain.member.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	User findByUsername(String username);
}
