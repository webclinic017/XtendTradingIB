package com.xtendtrading.ibbot.view;

import static com.xtendtrading.ibbot.mvcframework.ComponentFactory.customGridBagPanel;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.mvcframework.AbstractView;
import com.xtendtrading.ibbot.view.include.HeaderSection;

public class MainPanel extends AbstractView<JPanel> {
	private JPanel detailPanel;
	
	public MainPanel(AbstractFrame mainFrame) {
		super(mainFrame);
	}
	
	@Override
	protected JPanel layout() {
		detailPanel = new JPanel(new CardLayout(0,0));
		detailPanel.add("homepage", getMainFrame().getView(HomepagePanel.class).getContentPane());
		detailPanel.add("dashboard", getMainFrame().getView(DashBoardPanel.class).getContentPane());
		//detailPanel.add("home", getMainFrame().getView(HomePanel.class).getContentPane());
		//detailPanel.add("login", getMainFrame().getView(LoginPanel.class).getContentPane());
		detailPanel.add("trading", getMainFrame().getView(TradingPanel.class).getContentPane());
		detailPanel.add("history", getMainFrame().getView(HistoryPanel.class).getContentPane());
		JPanel contentPane = customGridBagPanel(detailPanel,getMainFrame().getView(HeaderSection.class).getContentPane());
		return contentPane;
	}
	
    // ------------ Response Code Goes Here
    public void showPanel(final String panelCode) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				((CardLayout)detailPanel.getLayout()).show(detailPanel, panelCode);
			}
		});
    }
}