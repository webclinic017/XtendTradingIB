package com.ibbot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ibbot.domain.member.User;
import com.ibbot.web.constant.ViewName;

@Controller
public class SignalController extends CommonController {
	
    @RequestMapping(value={"/getSignal"}, method = RequestMethod.GET)
    public ModelAndView getSignal() 
    {	
        return new ModelAndView("json/tradingSignalJson");
    }

}
