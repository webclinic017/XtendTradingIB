package com.xtendtrading.ibbot.controller;

import com.xtendtrading.ibbot.mvcframework.AbstractController;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.view.MainPanel;

public class HomeController extends AbstractController  {
	public HomeController(AbstractFrame mainFrame) {
		super(mainFrame);
		// TODO Auto-generated constructor stub
	}
	
	public void connectingIBGateway(final String ipAddress,final int port, final int clientId){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				getMainFrame().getController(IBController.class).onConnect(ipAddress, port, clientId);
			}
		});
	}
	
	public void demoNextPanel(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
		    	getMainFrame().getView(MainPanel.class).showPanel("login");
			}
		});
	}
    
    public void quitApp(){
    	System.exit(1);
    }
}
