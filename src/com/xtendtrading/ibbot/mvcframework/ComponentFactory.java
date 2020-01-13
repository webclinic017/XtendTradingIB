package com.xtendtrading.ibbot.mvcframework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import com.xtendtrading.ibbot.model.GBConstraints;
import com.xtendtrading.ibbot.view.component.GradientPanel;

public class ComponentFactory {
	public static JFrame frame(String title, JComponent contentPane, JMenuBar menuBar) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (title != null) frame.setTitle(title);
		if (menuBar != null) frame.setJMenuBar(menuBar);
		if (contentPane != null) frame.getContentPane().add(contentPane, BorderLayout.CENTER);
		frame.setPreferredSize(new Dimension(600, 375));
		frame.setMinimumSize(new Dimension(600, 375));

		return frame;
	}

	public static JFrame showFrame(JFrame frame) {
		frame.pack();
		centerFrame(frame);
		frame.setVisible(true);
		return frame;
	}
	
	public static JFrame centerFrame(JFrame frame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width) frameSize.width = screenSize.width;
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		return frame;
	}
	
	public static JPanel panel(LayoutManager layoutManager, String title) {
		JPanel panel = new JPanel();
		if (layoutManager != null) panel.setLayout(layoutManager);
		if (title != null) panel.setBorder(new TitledBorder(title));
		return panel;
	}
	
	public static JLabel label(String text, Font font) {
		JLabel label = new JLabel();
		if (text != null) label.setText(text);
		if (font != null) label.setFont(font);
		return label;
	}
	
	public static JButton button(String label, ActionListener actionListener) {
		JButton button = new JButton();
		if (label != null) button.setText(label);
		if (actionListener != null) button.addActionListener(actionListener);
		return button;
	}
	
	public static JPanel buttons(JButton... buttons) {
		JPanel panel = panel(new FlowLayout(), null);
		for (JButton button : buttons) panel.add(button);
		return panel;
	}
	
	public static JTable table(TableModel tableModel) {
		JTable table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if (tableModel != null) table.setModel(tableModel);
		return table;
	}
	
	public static JInternalFrame internalFrame(JComponent contentPane, String title) {
		JInternalFrame internalFrame = new JInternalFrame();
		internalFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		internalFrame.setResizable(true);
		internalFrame.setClosable(true);
		internalFrame.setMaximizable(true);
		internalFrame.setIconifiable(true);
		internalFrame.setPreferredSize(new Dimension(600, 400));
		if (contentPane != null) internalFrame.setContentPane(new JScrollPane(contentPane));
		if (title != null) internalFrame.setTitle(title);
		return internalFrame;
	}

	public static JTree tree(TreeModel treeModel, MouseListener mouseListener) {
		JTree tree = new JTree();
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		if (treeModel != null) tree.setModel(treeModel);
		if (mouseListener != null) tree.addMouseListener(mouseListener);
		return tree;
	}
	
	public static JPopupMenu popupMenu(Action... actions) {
		JPopupMenu popupMenu = new JPopupMenu();
		for (Action action : actions) {
			popupMenu.add(action);			
		}
		return popupMenu;
	}
	
	public static JPanel customGridBagPanel(JPanel content, JPanel headerSection){
		GradientPanel contentPane = new GradientPanel();
		contentPane.setColor1(new Color(0xF6F3EF));
		contentPane.setColor2(new Color(0xCCC8C0));
		contentPane.setGradientMode(2);
		contentPane.setLayout(new GridBagLayout());
		int rowIndex = 0;

		GBConstraints gbc1 = new GBConstraints(0, rowIndex);
		gbc1.setFill(3);
		gbc1.setAnchor(2);
		gbc1.weightx = 0.5;
		gbc1.gridwidth = 3;
		rowIndex++;
		
		GBConstraints gbc2 = new GBConstraints(0, rowIndex);
		gbc2.setFill(3);
		gbc2.weightx = 0.5;
		JPanel leftSidebar = new JPanel();
		leftSidebar.setOpaque(false);

		GBConstraints gbc3 = new GBConstraints(2, rowIndex);
		gbc3.setFill(3);
		gbc3.weightx = 0.5;
		JPanel rightSidebar = new JPanel();
		rightSidebar.setOpaque(false);

		GBConstraints gbcM = new GBConstraints(1, rowIndex);
		gbcM.setAnchor(2);
		rowIndex++;

		GBConstraints gbc4 = new GBConstraints(0, rowIndex);
		gbc4.setFill(3);
		gbc4.setAnchor(8);
		gbc4.setInsets(0, 10, 10, 10);
		gbc4.weightx = 0.5;
		gbc4.weighty = 0.5;
		gbc4.gridwidth = 3;
		rowIndex++;

		JPanel footerSection = new JPanel();
		footerSection.setOpaque(false);
		
		content.setOpaque(false);

		contentPane.add(headerSection, gbc1);
		contentPane.add(leftSidebar, gbc2);
		contentPane.add(content, gbcM);
		contentPane.add(rightSidebar, gbc3);
		contentPane.add(footerSection, gbc4);
		
		return contentPane;
	}
	
	public void adjustColumnPreferredWidths(JTable table) {
		// strategy - get max width for cells in column and
		// make that the preferred width
		TableColumnModel columnModel = table.getColumnModel();
		for (int col = 0; col < table.getColumnCount(); col++) {

			int maxwidth = 0;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer rend = table.getCellRenderer(row, col);
				Object value = table.getValueAt(row, col);
				Component comp = rend.getTableCellRendererComponent(table,
						value, false, false, row, col);
				maxwidth = Math
						.max(comp.getPreferredSize().width, maxwidth);
			} // for row
			TableColumn column = columnModel.getColumn(col);
			column.setPreferredWidth(maxwidth);
		} // for col
	}
}