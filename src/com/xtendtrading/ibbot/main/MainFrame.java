package com.xtendtrading.ibbot.main;

import static com.xtendtrading.ibbot.mvcframework.ComponentFactory.frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.xtendtrading.ibbot.controller.DashBoardController;
import com.xtendtrading.ibbot.controller.HomeController;
import com.xtendtrading.ibbot.controller.HomepageController;
import com.xtendtrading.ibbot.controller.IBController;
import com.xtendtrading.ibbot.controller.LoginController;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.view.DashBoardPanel;
import com.xtendtrading.ibbot.view.HistoryPanel;
import com.xtendtrading.ibbot.view.HomepagePanel;
import com.xtendtrading.ibbot.view.MainPanel;
import com.xtendtrading.ibbot.view.TradingPanel;
import com.xtendtrading.ibbot.view.include.HeaderSection;

public class MainFrame extends AbstractFrame{
	@Override
	protected void registerAllViews() {
		//Views which inside MainPanel must be putted first before MainPanel
		//views.put(LoginPanel.class, new LoginPanel(this));
		//views.put(HomePanel.class, new HomePanel(this));
		views.put(HomepagePanel.class, new HomepagePanel(this));
		views.put(DashBoardPanel.class, new DashBoardPanel(this));
		views.put(HeaderSection.class, new HeaderSection(this));
		views.put(TradingPanel.class, new TradingPanel(this));
		views.put(HistoryPanel.class, new HistoryPanel(this));
		
		views.put(MainPanel.class, new MainPanel(this));
		//views.put(TopMenuView.class, new TopMenuView(this));
	}
	
	@Override
	protected void registerAllControllers() {
		controllers.put(LoginController.class, new LoginController(this));
		controllers.put(HomeController.class, new HomeController(this));
		controllers.put(IBController.class, new IBController(this));
		controllers.put(DashBoardController.class, new DashBoardController(this));
		controllers.put(HomepageController.class, new HomepageController(this));
		//controllers.put(TopMenuController.class, new TopMenuController(this));
	}
	
	@Override
	public JFrame layout() {
		//return frame("XtendTrading Trading Platform", getView(MainPanel.class).getContentPane(), getView(TopMenuView.class).getMenuBar());
		return frame("XtendTrading Trading Platform", getView(MainPanel.class).getContentPane(), null);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainFrame mainFrame = new MainFrame();
				mainFrame.show();
				mainFrame.resizeWindow(600, 375);
			}
		});
	}

	@Override
	public void showMessage(final String text){
		final JFrame layout = this.layout();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JOptionPane.showMessageDialog(layout, text,
						  "Click OK", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

}