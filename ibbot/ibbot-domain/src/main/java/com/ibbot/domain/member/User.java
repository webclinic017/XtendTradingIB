package com.ibbot.domain.member;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ib_users")
public class User 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "state")
	private Integer state;
	
	@Column(name = "is_lock")
	private Boolean isLock;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name = "last_login_date")
	private Date lastLoginDate;
	
	@Column(name = "last_login_from")
	private String lastLoginFrom;
	
	@Column(name = "last_logout_date")
	private Date lastLogoutDate;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "ib_user_roles",
		joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
		inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
	private Role role;
	
	public Long getUserId() 
	{
		return userId;
	}

	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getPhone() 
	{
		return phone;
	}
	
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	
	public String getMobile() 
	{
		return mobile;
	}
	
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public Integer getState() 
	{
		return state;
	}
	
	public void setState(Integer state) 
	{
		this.state = state;
	}
	
	public Boolean getIsLock() 
	{
		return isLock;
	}
	
	public void setIsLock(Boolean isLock) 
	{
		this.isLock = isLock;
	}
	
	public Date getCreatedDate() 
	{
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) 
	{
		this.createdDate = createdDate;
	}
	
	public Date getUpdatedDate() 
	{
		return updatedDate;
	}
	
	public void setUpdatedDate(Date updatedDate) 
	{
		this.updatedDate = updatedDate;
	}
	
	public Date getLastLoginDate() 
	{
		return lastLoginDate;
	}
	
	public void setLastLoginDate(Date lastLoginDate) 
	{
		this.lastLoginDate = lastLoginDate;
	}
	
	public String getLastLoginFrom() 
	{
		return lastLoginFrom;
	}
	
	public void setLastLoginFrom(String lastLoginFrom) 
	{
		this.lastLoginFrom = lastLoginFrom;
	}
	
	public Date getLastLogoutDate() 
	{
		return lastLogoutDate;
	}
	
	public void setLastLogoutDate(Date lastLogoutDate) 
	{
		this.lastLogoutDate = lastLogoutDate;
	}

	public Role getRole() 
	{
		return role;
	}

	public void setRole(Role role) 
	{
		this.role = role;
	}
}
