package com.xtendtrading.ibbot.view;

import static com.xtendtrading.ibbot.mvcframework.ComponentFactory.button;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ib.client.Contract;
import com.ib.client.Order;
import com.xtendtrading.ibbot.controller.IBController;
import com.xtendtrading.ibbot.model.GBConstraints;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.mvcframework.AbstractView;

public class TradingPanel extends AbstractView<JPanel>{
	private JButton submitButton;
	private JButton backButton;
	private JTextField idField;
	private JTextField symbolField;
	private JTextField secTypeField;
	private JTextField exchangeField;
	private JTextField primaryExchField;
	private JTextField currencyField;
	private JTextField actionField;
	private JTextField quantityField;
	private JTextField orderTypeField;
	private JTextField limitPriceField;
	private JTextField aucPriceField;

	public TradingPanel(AbstractFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	protected JPanel layout() {
		JPanel penampung = new JPanel();
		int rowIndex = 0;
		penampung.setOpaque(false);
		penampung.setLayout(new GridBagLayout());
        JLabel label1 = new JLabel( "Id");
        JLabel label2 = new JLabel( "Symbol");
        JLabel label3 = new JLabel( "Security Type");
        JLabel label4 = new JLabel( "Exchange");
        JLabel label5 = new JLabel( "Primary Exchange");
        JLabel label6 = new JLabel( "Currency");
        JLabel label7 = new JLabel( "Action");
        JLabel label8 = new JLabel( "Total Order Size");
        JLabel label9 = new JLabel( "Order Type");
        JLabel label10 = new JLabel( "Limit Price");
        JLabel label11 = new JLabel( "Aux Price");
        idField = new JTextField( "1");
    	symbolField = new JTextField( "KO");
    	secTypeField = new JTextField( "STK");
    	exchangeField = new JTextField( "SMART");
    	primaryExchField = new JTextField( "ISLAND");
    	currencyField = new JTextField( "USD");
    	actionField = new JTextField( "BUY");
    	quantityField = new JTextField( "10");
    	orderTypeField = new JTextField( "LMT");
    	limitPriceField = new JTextField( "41.15");
    	aucPriceField = new JTextField( "0.0");

    	backButton = button("Back", null);
		submitButton = button("Submit", new doSubmit());

		GBConstraints gbc1a = new GBConstraints(0, rowIndex);
		gbc1a.setAnchor(4);
		GBConstraints gbc1b = new GBConstraints(1, rowIndex);
		gbc1b.setFill(1);
		rowIndex++;
		GBConstraints gbc2a = new GBConstraints(0, rowIndex);
		gbc2a.setAnchor(4);
		GBConstraints gbc2b = new GBConstraints(1, rowIndex);
		gbc2b.setFill(1);
		rowIndex++;
		GBConstraints gbc3a = new GBConstraints(0, rowIndex);
		gbc3a.setAnchor(4);
		GBConstraints gbc3b = new GBConstraints(1, rowIndex);
		gbc3b.setFill(1);
		rowIndex++;
		GBConstraints gbc4a = new GBConstraints(0, rowIndex);
		gbc4a.setAnchor(4);
		GBConstraints gbc4b = new GBConstraints(1, rowIndex);
		gbc4b.setFill(1);
		rowIndex++;
		GBConstraints gbc5a = new GBConstraints(0, rowIndex);
		gbc5a.setAnchor(4);
		GBConstraints gbc5b = new GBConstraints(1, rowIndex);
		gbc5b.setFill(1);
		rowIndex++;
		GBConstraints gbc6a = new GBConstraints(0, rowIndex);
		gbc6a.setAnchor(4);
		GBConstraints gbc6b = new GBConstraints(1, rowIndex);
		gbc6b.setFill(1);
		rowIndex++;
		GBConstraints gbc7a = new GBConstraints(0, rowIndex);
		gbc7a.setAnchor(4);
		GBConstraints gbc7b = new GBConstraints(1, rowIndex);
		gbc7b.setFill(1);
		rowIndex++;
		GBConstraints gbc8a = new GBConstraints(0, rowIndex);
		gbc8a.setAnchor(4);
		GBConstraints gbc8b = new GBConstraints(1, rowIndex);
		gbc8b.setFill(1);
		rowIndex++;
		GBConstraints gbc9a = new GBConstraints(0, rowIndex);
		gbc9a.setAnchor(4);
		GBConstraints gbc9b = new GBConstraints(1, rowIndex);
		gbc9b.setFill(1);
		rowIndex++;
		GBConstraints gbc10a = new GBConstraints(0, rowIndex);
		gbc10a.setAnchor(4);
		GBConstraints gbc10b = new GBConstraints(1, rowIndex);
		gbc10b.setFill(1);
		rowIndex++;
		GBConstraints gbc11a = new GBConstraints(0, rowIndex);
		gbc11a.setAnchor(4);
		GBConstraints gbc11b = new GBConstraints(1, rowIndex);
		gbc11b.setFill(1);
		rowIndex++;
		GBConstraints gbc12a = new GBConstraints(0, rowIndex);
		GBConstraints gbc12b = new GBConstraints(1, rowIndex);
		rowIndex++;

		penampung.add(label1,gbc1a);
		penampung.add(idField,gbc1b);
		penampung.add(label2,gbc2a);
		penampung.add(symbolField,gbc2b);
		penampung.add(label3,gbc3a);
		penampung.add(secTypeField,gbc3b);
		penampung.add(label4,gbc4a);
		penampung.add(exchangeField,gbc4b);
		penampung.add(label5,gbc5a);
		penampung.add(primaryExchField,gbc5b);
		penampung.add(label6,gbc6a);
		penampung.add(currencyField,gbc6b);
		penampung.add(label7,gbc7a);
		penampung.add(actionField,gbc7b);
		penampung.add(label8,gbc8a);
		penampung.add(quantityField,gbc8b);
		penampung.add(label9,gbc9a);
		penampung.add(orderTypeField,gbc9b);
		penampung.add(label10,gbc10a);
		penampung.add(limitPriceField,gbc10b);
		penampung.add(label11,gbc11a);
		penampung.add(aucPriceField,gbc11b);
		penampung.add(backButton,gbc12a);
		penampung.add(submitButton,gbc12b);
		return penampung;
	}
	
    // ------------ Request Code Goes Here
    private class doSubmit implements ActionListener {
    	
		@Override
		public void actionPerformed(ActionEvent arg0) {
	        try {
	        	String id = idField.getText();
	        	String symbol = symbolField.getText();
	        	String secType = secTypeField.getText();
	        	String exchange = exchangeField.getText();
	        	String primaryExch = primaryExchField.getText();
	        	String currency = currencyField.getText();
	        	String action = actionField.getText();
	        	String quantity = quantityField.getText();
	        	String orderType = orderTypeField.getText();
	        	String limitPrice = limitPriceField.getText();
	        	String aucPrice = aucPriceField.getText();
	        	
		        Order order = new Order();
		        order.m_action = action;
		        order.m_totalQuantity = Integer.parseInt(quantity);
		        order.m_orderType = orderType;
		        order.m_lmtPrice = Double.parseDouble(limitPrice);
		        order.m_auxPrice = Double.parseDouble(aucPrice);
		        Contract contract = new Contract(0,symbol,secType,"",0.0,"","",exchange,currency,"",null,primaryExch,false,"","");
		        
		        getMainFrame().getController(IBController.class).placeOrder(Integer.parseInt(id),order,contract);
	        }
	        catch( Exception e) {
	        	e.printStackTrace();
	            return;
	        }
		}
    }

}
