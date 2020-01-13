package com.xtendtrading.ibbot.view;

import static com.xtendtrading.ibbot.mvcframework.ComponentFactory.button;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.xtendtrading.ibbot.controller.DashBoardController;
import com.xtendtrading.ibbot.helper.TableHelper;
import com.xtendtrading.ibbot.model.GBConstraints;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.mvcframework.AbstractView;

public class HistoryPanel extends AbstractView<JPanel> {
	private JTable transactionHistoryTable;
	private JButton resyncButton;
	private JButton moreButton;

	public HistoryPanel(AbstractFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	protected JPanel layout() {
		JPanel penampung = new JPanel();
		penampung.setOpaque(false);
		penampung.setLayout(new GridBagLayout());

		Border bdr = BorderFactory.createEtchedBorder();
		Border titlebdr1 = BorderFactory.createTitledBorder(bdr, "");
		penampung.setBorder(titlebdr1);

		int rowIndex = 0;
		GBConstraints gbc1 = new GBConstraints(0, rowIndex);
		// gbc1.setFill(1);
		// gbc1.setAnchor(4);
		// gbc1.weightx = 8;
		gbc1.setInsets(0, 0, 0, 0);

		GBConstraints gbc1b = new GBConstraints(1, rowIndex);
		// gbc1b.gridheight = 2;
		// gbc1b.weightx = 2;
		// gbc1b.setFill(10);
		// gbc1b.setAnchor(6);
		gbc1b.setInsets(0, 10, 0, 0);
		rowIndex++;

		GBConstraints gbc2 = new GBConstraints(0, rowIndex);
		// gbc2.weightx = 8;
		// gbc2.setFill(1);
		gbc2.setInsets(0, 0, 0, 0);
		rowIndex++;

		DefaultTableModel mod = new DefaultTableModel(null,
				TableHelper.getCompleteHistoryTableColumnNames());
		transactionHistoryTable = new JTable(mod);
		JScrollPane transactionHistoryPane = new JScrollPane(transactionHistoryTable,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		resyncButton = button("Resync", new doReturnDashboard());
		moreButton = button("More", new doReturnDashboard());
		JPanel dashboardPanel_Button = new JPanel();
		dashboardPanel_Button.setLayout(new BorderLayout(0, 5));
		dashboardPanel_Button.setOpaque(false);
		dashboardPanel_Button.add(resyncButton, BorderLayout.NORTH);
		dashboardPanel_Button.add(moreButton, BorderLayout.SOUTH);

		//penampung.add(transactionHistoryTable.getTableHeader(), gbc1);
		// penampung.add(dashboardPanel_Button, gbc1b);
		//penampung.add(transactionHistoryTable, gbc2);
		penampung.add(transactionHistoryPane, gbc1);

		refreshTableData();
		return penampung;
	}

	// ------------ Main Functional Method
	private void refreshTableData() {
		final JTable fTable = transactionHistoryTable;
		Object[][] dummyData = {
				{ "Buy", "100", "KO", "Stock", "43.54", "USD", "SMART",
						"2013-12-24 20:48:23.00" },
				{ "Sell", "50", "KO", "Stock", "43.54", "USD", "SMART",
						"2013-12-24 20:48:23.00" },
				{ "Buy", "10000", "AA", "Stock", "56.22", "USD", "SMART",
						"2013-12-24 20:48:23.00" } };
		final Object[][] data = dummyData;
		// final Object[][] data = null;

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				TableHelper.setCompleteTableModel(fTable, data);
				TableHelper.adjustColumnPreferredWidths(fTable, 10);
				fTable.revalidate();
			}
		});

	}

	// ------------ Request Code Goes Here
	private class doReturnDashboard implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			getMainFrame().getController(DashBoardController.class)
					.backToLogin();
		}
	}

}
