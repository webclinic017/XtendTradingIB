package com.xtendtrading.ibbot.controller;

import com.xtendtrading.ibbot.mvcframework.AbstractController;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.view.HomepagePanel;
import com.xtendtrading.ibbot.view.MainPanel;

public class HomepageController extends AbstractController  {
	public HomepageController(AbstractFrame mainFrame) {
		super(mainFrame);
		// TODO Auto-generated constructor stub
	}
	
	public void ConnectingIBGateway(final String ipAddress,final int port, final int clientId){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Boolean isSuccess = getMainFrame().getController(IBController.class).onConnect(ipAddress, port, clientId);
				if(isSuccess){
			    	getMainFrame().getView(HomepagePanel.class).SetStatusAndButton(1, true);
				}
			}
		});
	}
	
	public void DisconnectingIBGateway(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				getMainFrame().getController(IBController.class).onDisconnect();
			    getMainFrame().getView(HomepagePanel.class).SetStatusAndButton(1, false);
			}
		});
	}

    public void ConnectingServerLogin(final String username, final char[] password) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
		        // 1. do server logic
		    	//System.out.println("yihaaa... : "+username+"|"+password.toString());
		    	// 2. do swing response
		    	getMainFrame().getView(HomepagePanel.class).setMessage("You are successfully login.");
		    	Boolean isSuccess = true;
				if(isSuccess){
			    	getMainFrame().getView(HomepagePanel.class).SetStatusAndButton(2, true);
				}
			}
		});
    }

    public void DisconnectingServerLogin() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
		        // 1. do server logic
				
		    	// 2. do swing response
		    	getMainFrame().getView(HomepagePanel.class).setMessage("You have been logout.");
			    getMainFrame().getView(HomepagePanel.class).SetStatusAndButton(2, false);
			}
		});
    }
	
	public void GoToNextPanel(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
		    	getMainFrame().getView(MainPanel.class).showPanel("dashboard");
			}
		});
	}
    
    public void QuitApp(){
    	System.exit(1);
    }
}
