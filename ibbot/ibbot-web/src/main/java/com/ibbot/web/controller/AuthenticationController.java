package com.ibbot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ibbot.web.constant.ViewName;

@Controller
public class AuthenticationController extends CommonController 
{
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(required=false) String message) 
    {
        return new ModelAndView(ViewName.LOGIN_PAGE, "message", message);
    }
	
	@RequestMapping(value = "/denied")
 	public String denied() 
	{
		return ViewName.ACCESS_DENIED_PAGE;
	}
	
	@RequestMapping(value = "/login/failure")
 	public String loginFailure() 
	{
		String message = "Login Failure!";
		
		return "redirect:/login?message=" + message;
	}
	
	@RequestMapping(value = "/logout/success")
 	public String logoutSuccess() 
	{
		String message = "Logout Success!";
		
		return "redirect:/login?message=" + message;
	}
}
