package com.xtendtrading.ibbot.controller;

import com.xtendtrading.ibbot.mvcframework.AbstractController;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;

public class TopMenuController extends AbstractController {

	public TopMenuController(AbstractFrame mainFrame) {
		super(mainFrame);
	}

    public void triggerRegisterPanel() {
    	//something Register here
        //getMainFrame().getView(TopMenuView.class).switchMenuBar(1);
    }
}
