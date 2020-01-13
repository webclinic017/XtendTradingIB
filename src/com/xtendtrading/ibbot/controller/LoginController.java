package com.xtendtrading.ibbot.controller;

import com.xtendtrading.ibbot.mvcframework.AbstractController;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.view.LoginPanel;
import com.xtendtrading.ibbot.view.MainPanel;

public class LoginController extends AbstractController {

    public LoginController(AbstractFrame mainFrame) {
        super(mainFrame);
    }

    public void connectingServerLogin(final String username, final char[] password) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
		        // 1. do server logic
		    	//System.out.println("yihaaa... : "+username+"|"+password.toString());
		    	// 2. do swing response
		    	getMainFrame().getView(LoginPanel.class).setMessage("Successfully Listener");
		    	getMainFrame().getView(MainPanel.class).showPanel("dashboard");
			}
		});
    }
    
    public void backToHome(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				getMainFrame().getView(MainPanel.class).showPanel("home");
			}
		});
    }
}
