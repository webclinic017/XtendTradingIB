package com.ibbot.domain.member;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ib_roles")
public class Role 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long roleId;
	
	@Column(name = "code")
	@NotEmpty
	private String code;
	
	@Column(name = "name")
	@NotEmpty
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "ib_user_roles",
			joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
			inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")})
	private List<User> users;
	
	public Long getRoleId() 
	{
		return roleId;
	}

	public void setRoleId(Long roleId) 
	{
		this.roleId = roleId;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setCode(String code) 
	{
		this.code = code;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}

	public List<User> getUsers() 
	{
		return users;
	}

	public void setUsers(List<User> users) 
	{
		this.users = users;
	}
}
