package com.xtendtrading.ibbot.helper;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableHelper {
	private static String[] smallHistoryTableColumnNames = { "Action", "Qty",
			"Symbol", "Price" };
	private static String[] completeHistoryTableColumnNames = { "Action",
			"Quantity", "Symbol", "Description", "Price", "Currency",
			"Exchange", "Time" };

	public static void adjustColumnPreferredWidths(JTable table, int padding) {
		// strategy - get max width for cells in column and
		// make that the preferred width
		TableColumnModel columnModel = table.getColumnModel();
		TableColumnModel headerColumnModel = table.getTableHeader()
				.getColumnModel();
		TableCellRenderer headerRend = table.getTableHeader()
				.getDefaultRenderer();
		Object headerValue, value;
		Component headerComp, comp;
		int maxwidth;
		for (int col = 0; col < table.getColumnCount(); col++) {
			headerValue = headerColumnModel.getColumn(col).getHeaderValue();
			headerComp = headerRend.getTableCellRendererComponent(table,
					headerValue, false, false, 0, col);
			maxwidth = 0;
			maxwidth = headerComp.getPreferredSize().width;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer rend = table.getCellRenderer(row, col);
				value = table.getValueAt(row, col);
				comp = rend.getTableCellRendererComponent(table, value, false,
						false, row, col);
				maxwidth = Math.max(comp.getPreferredSize().width, maxwidth);
			} // for row
			TableColumn column = columnModel.getColumn(col);
			column.setPreferredWidth(maxwidth + padding);
		} // for col
	}

	public static void setSmallTableModel(JTable table, Object[][] dataTable) {
		DefaultTableModel mod = new DefaultTableModel(dataTable,
				TableHelper.getSmallHistoryTableColumnNames());
		table.setModel(mod);
	}

	public static void setCompleteTableModel(JTable table, Object[][] dataTable) {
		DefaultTableModel mod = new DefaultTableModel(dataTable,
				TableHelper.getCompleteHistoryTableColumnNames());
		table.setModel(mod);
	}

	public static String[] getSmallHistoryTableColumnNames() {
		return smallHistoryTableColumnNames;
	}

	public static String[] getCompleteHistoryTableColumnNames() {
		return completeHistoryTableColumnNames;
	}

}
