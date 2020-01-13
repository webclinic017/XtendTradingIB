package com.xtendtrading.ibbot.controller;

import com.xtendtrading.ibbot.mvcframework.AbstractController;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.view.MainPanel;

public class DashBoardController extends AbstractController {

    public DashBoardController(AbstractFrame mainFrame) {
        super(mainFrame);
    }
    
    public void backToLogin(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				getMainFrame().getView(MainPanel.class).showPanel("homepage");
			}
		});
    }
    
    public void goTradingPanel(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				getMainFrame().getView(MainPanel.class).showPanel("trading");
			}
		});
    }
    
    public void goHistoryPanel(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				getMainFrame().getView(MainPanel.class).showPanel("history");
			}
		});
    }
    
    public void goSignalPanel(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				getMainFrame().getView(MainPanel.class).showPanel("trading");
			}
		});
    }
}
