package com.xtendtrading.ibbot.mvcframework;

public class AbstractController {
	private final AbstractFrame mainFrame;

	public AbstractController(AbstractFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	protected AbstractFrame getMainFrame() {
		return mainFrame;
	}
}
