package com.xtendtrading.ibbot.view;

import static com.xtendtrading.ibbot.mvcframework.ComponentFactory.button;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.xtendtrading.ibbot.controller.DashBoardController;
import com.xtendtrading.ibbot.helper.TableHelper;
import com.xtendtrading.ibbot.model.GBConstraints;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.mvcframework.AbstractView;
import com.xtendtrading.ibbot.view.component.ImageButton;
import com.xtendtrading.ibbot.view.component.ImageLoader;

public class DashBoardPanel extends AbstractView<JPanel> {
	private JLabel messageLabel;
	private JLabel signalLabel;
	private JLabel stokLabel;
	private JLabel statusLabel;
	private ImageLoader signalStatusImage;
	private JButton resyncButton;
	private JButton moreButton;
	
	private JTable historyTable;

	public DashBoardPanel(AbstractFrame mainFrame) {
		super(mainFrame);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected JPanel layout() {
		JPanel penampung = new JPanel();
		int rowIndex = 0;
		penampung.setOpaque(false);
		penampung.setLayout(new GridBagLayout());

		GBConstraints gbc1 = new GBConstraints(0, rowIndex);
		gbc1.ipadx = 10;
		gbc1.ipady = 10;
		gbc1.setInsets(0, 0, 0, 5);

		GBConstraints gbc2 = new GBConstraints(1, rowIndex);
		gbc2.setFill(2);
		gbc2.ipadx = 10;
		gbc2.setInsets(0, 5, 0, 0);
		rowIndex++;

		GBConstraints gbc3 = new GBConstraints(0, rowIndex);
		gbc3.gridwidth = 2;
		gbc3.setFill(2);
		gbc3.ipadx = 10;
		gbc3.setInsets(0, 5, 0, 0);

		penampung.add(getMainBoxLayout(), gbc1);
		penampung.add(getSideBoxLayout(), gbc2);
		penampung.add(getMessageBoxLayout(), gbc3);
		return penampung;
	}

	private JPanel getMainBoxLayout() {
		JPanel penampung = new JPanel();
		int rowIndex = 0;
		// penampung.setBackground(new Color(0xFF0000));
		penampung.setOpaque(false);
		penampung.setLayout(new GridBagLayout());

		Border bdr = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		Border titlebdr1 = BorderFactory.createTitledBorder(bdr, "");
		penampung.setBorder(titlebdr1);

		int internalside = 0;
		int internaltopbot = 10;
		int externalside = 0;
		int externaltopbot = 10;
		GBConstraints gbc1 = new GBConstraints(0, rowIndex);
		gbc1.setInsets(externaltopbot, externalside, internaltopbot,
				internalside);

		GBConstraints gbc2 = new GBConstraints(1, rowIndex);
		gbc2.setInsets(externaltopbot, internalside, internaltopbot,
				externalside);
		rowIndex++;

		GBConstraints gbc3 = new GBConstraints(0, rowIndex);
		gbc3.setInsets(internaltopbot, externalside, externaltopbot,
				internalside);

		GBConstraints gbc4 = new GBConstraints(1, rowIndex);
		gbc4.setInsets(internaltopbot, internalside, externaltopbot,
				externalside);
		rowIndex++;

		JButton tradebut = new ImageButton(new ImageIcon(
				"src.images/tradebut1.png"), new ImageIcon(
				"src.images/tradebut2.png"), 0, 0);
		JButton signalbut = new ImageButton(new ImageIcon(
				"src.images/signalbut1.png"), new ImageIcon(
				"src.images/signalbut2.png"), 0, 0);
		JButton histbut = new ImageButton(new ImageIcon(
				"src.images/histbut1.png"), new ImageIcon(
				"src.images/histbut2.png"), 0, 0);
		JButton exitbut = new ImageButton(new ImageIcon(
				"src.images/exitbut1.png"), new ImageIcon(
				"src.images/exitbut2.png"), 0, 0);

		tradebut.addActionListener(new doTrading());
		signalbut.addActionListener(new doSignal());
		histbut.addActionListener(new doHistory());
		exitbut.addActionListener(new doExit());

		penampung.add(tradebut, gbc1);
		penampung.add(signalbut, gbc2);
		penampung.add(histbut, gbc3);
		penampung.add(exitbut, gbc4);

		return penampung;
	}

	private JPanel getSideBoxLayout() {
		JPanel penampung = new JPanel();
		// penampung.setBackground(new Color(0xFFFF00));
		penampung.setOpaque(false);
		penampung.setLayout(new GridBagLayout());

		Border bdr = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		Border titlebdr1 = BorderFactory.createTitledBorder(bdr, "");
		penampung.setBorder(titlebdr1);

		int rowIndex = 0;
		GBConstraints gbc1 = new GBConstraints(0, rowIndex);
		rowIndex++;
		GBConstraints gbc2 = new GBConstraints(0, rowIndex);
		rowIndex++;

		penampung.add(getSideSignalBoxLayout(), gbc1);
		penampung.add(getSideHistoryBoxLayout(), gbc2);
		return penampung;
	}

	private JPanel getSideSignalBoxLayout() {
		JPanel penampung = new JPanel();
		penampung.setOpaque(false);
		penampung.setLayout(new GridBagLayout());
		penampung.setPreferredSize(new Dimension(300, 120));

		Border bdr = BorderFactory.createEtchedBorder();
		Border titlebdr1 = BorderFactory.createTitledBorder(bdr,
				"Signal Source");
		penampung.setBorder(titlebdr1);

		int rowIndex = 0;
		GBConstraints gbc1 = new GBConstraints(0, rowIndex);
		gbc1.ipadx = 30;
		gbc1.setFill(1);
		gbc1.setAnchor(4);
		gbc1.setInsets(5, 0, 5, 0);
		JLabel signalNameLabel = new JLabel("Name : ");

		GBConstraints gbc1b = new GBConstraints(1, rowIndex);
		gbc1b.ipadx = 70;
		gbc1b.setFill(1);
		gbc1b.setAnchor(4);
		gbc1b.setInsets(5, 0, 5, 0);
		signalLabel = new JLabel("(not set yet)");

		GBConstraints gbc1c = new GBConstraints(2, rowIndex);
		gbc1c.setInsets(5, 0, 5, 0);
		gbc1c.gridheight = 3;
		signalStatusImage = new ImageLoader("src.images/not_ok_icon2.png");
		rowIndex++;

		GBConstraints gbc2 = new GBConstraints(0, rowIndex);
		gbc2.ipadx = 30;
		gbc2.setFill(1);
		gbc2.setAnchor(4);
		gbc2.setInsets(5, 0, 5, 0);
		JLabel signalStokLabel = new JLabel("Stok : ");

		GBConstraints gbc2b = new GBConstraints(1, rowIndex);
		gbc2b.ipadx = 70;
		gbc2b.setFill(1);
		gbc2b.setAnchor(4);
		gbc2b.setInsets(5, 0, 5, 0);
		stokLabel = new JLabel(" - ");
		rowIndex++;

		GBConstraints gbc3 = new GBConstraints(0, rowIndex);
		gbc3.ipadx = 30;
		gbc3.setFill(1);
		gbc3.setAnchor(4);
		gbc3.setInsets(5, 0, 5, 0);
		JLabel signalStatusLabel = new JLabel("Status : ");

		GBConstraints gbc3b = new GBConstraints(1, rowIndex);
		gbc3b.ipadx = 70;
		gbc3b.setFill(1);
		gbc3b.setAnchor(4);
		gbc3b.setInsets(5, 0, 5, 0);
		statusLabel = new JLabel("not activated");
		rowIndex++;

		penampung.add(signalNameLabel, gbc1);
		penampung.add(signalLabel, gbc1b);
		penampung.add(signalStatusImage, gbc1c);
		penampung.add(signalStokLabel, gbc2);
		penampung.add(stokLabel, gbc2b);
		penampung.add(signalStatusLabel, gbc3);
		penampung.add(statusLabel, gbc3b);
		return penampung;
	}

	private JPanel getSideHistoryBoxLayout() {
		JPanel penampung = new JPanel();
		penampung.setOpaque(false);
		penampung.setLayout(new GridBagLayout());
		penampung.setPreferredSize(new Dimension(300, 120));

		Border bdr = BorderFactory.createEtchedBorder();
		Border titlebdr1 = BorderFactory.createTitledBorder(bdr,
				"Transaction History");
		penampung.setBorder(titlebdr1);

		int rowIndex = 0;
		GBConstraints gbc1 = new GBConstraints(0, rowIndex);
		gbc1.setFill(1);
		gbc1.setAnchor(4);
		gbc1.weightx = 8;
		gbc1.setInsets(0, 0, 0, 0);
		
		GBConstraints gbc1b = new GBConstraints(1, rowIndex);
		gbc1b.gridheight = 2;
		gbc1b.weightx = 2;
		gbc1b.setFill(10);
		gbc1b.setAnchor(6);
		gbc1b.setInsets(0, 10, 0, 0);
		rowIndex++;
		
		GBConstraints gbc2 = new GBConstraints(0, rowIndex);
		gbc2.weightx = 8;
		gbc2.setFill(1);
		gbc2.setInsets(0, 0, 0, 0);
		rowIndex++;

		DefaultTableModel mod = new DefaultTableModel(null,
				TableHelper.getSmallHistoryTableColumnNames());
		historyTable = new JTable(mod);
		
		
		resyncButton = button("Resync", new doResync());
		moreButton = button("More", new doHistory());
        JPanel dashboardPanel_Button = new JPanel();
        dashboardPanel_Button.setLayout(new BorderLayout(0,5));
        dashboardPanel_Button.setOpaque(false);
        dashboardPanel_Button.add(resyncButton,BorderLayout.NORTH);
        dashboardPanel_Button.add(moreButton,BorderLayout.SOUTH);

		penampung.add(historyTable.getTableHeader(), gbc1);

		penampung.add(dashboardPanel_Button, gbc1b);
		penampung.add(historyTable, gbc2);

		refreshTableData();
		return penampung;
	}

	// ------------ Main Functional Method
	private void refreshTableData() {
		final JTable fTable = historyTable;
		Object[][] dummyData = { { "Buy", "100", "KO", "43.54" },
				{ "Sell", "50", "KO", "43.56" },
				{ "Buy", "10000", "AA", "56.22" },
				{ "...", "...", "...", "..." } };
		final Object[][] data = dummyData;
		//final Object[][] data = null;

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				TableHelper.setSmallTableModel(fTable, data);
				TableHelper.adjustColumnPreferredWidths(fTable,0);
				fTable.revalidate();
			}
		});

	}

	private JPanel getMessageBoxLayout() {
		JPanel penampung = new JPanel();
		penampung.setOpaque(false);
		penampung.setLayout(new GridBagLayout());

		Border bdr = BorderFactory.createEtchedBorder();
		Border titlebdr1 = BorderFactory.createTitledBorder(bdr, "");
		penampung.setBorder(titlebdr1);

		messageLabel = new JLabel("");
		messageLabel.setForeground(new Color(0xFF0000));
		penampung.add(messageLabel);
		return penampung;
	}

	// ------------ Request Code Goes Here
	private class doResync implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			refreshTableData();
		}
	}
	
	private class doExit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			getMainFrame().getController(DashBoardController.class)
					.backToLogin();
		}
	}

	private class doSignal implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			getMainFrame().getController(DashBoardController.class)
					.goSignalPanel();
		}
	}

	private class doHistory implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			getMainFrame().getController(DashBoardController.class)
					.goHistoryPanel();
		}
	}

	private class doTrading implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			getMainFrame().getController(DashBoardController.class)
					.goTradingPanel();
		}
	}

	// ------------ Response Code Goes Here
	public void setMessage(final String message) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				messageLabel.setText(message);
			}
		});
	}
}