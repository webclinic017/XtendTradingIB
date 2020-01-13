package com.ibbot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ibbot.domain.member.User;
import com.ibbot.service.member.UserService;
import com.ibbot.web.constant.ViewName;

@Controller
public class HomeController extends CommonController 
{
	@Autowired
	private UserService userService;
	
    @RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView getHomePage() 
    {
    	User user = userService.getUser(1L);
    	
        return new ModelAndView(ViewName.HOME_PAGE, "user", user);
    }
    
    @RequestMapping(value="/user")
	public String getUserPage() 
    {
		return ViewName.USER_PAGE;
	}
	
	@RequestMapping(value="/admin")
	public String getAdminPage() 
	{
		return ViewName.ADMIN_PAGE;
	}
}