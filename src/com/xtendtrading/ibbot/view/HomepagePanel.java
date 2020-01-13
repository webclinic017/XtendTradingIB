package com.xtendtrading.ibbot.view;

import static com.xtendtrading.ibbot.mvcframework.ComponentFactory.button;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.xtendtrading.ibbot.controller.HomepageController;
import com.xtendtrading.ibbot.model.GBConstraints;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.mvcframework.AbstractView;
import com.xtendtrading.ibbot.view.component.ImageLoader;
import com.xtendtrading.ibbot.view.component.ImagePanel;

public class HomepagePanel extends AbstractView<JPanel> {
	private JLabel messageLabel;
    
	private JButton connectButton;
	private JButton disconnectButton;
	private JButton loginButton;
	private JButton logoutButton;
	private JButton exitButton;
	private JButton helpButton;
	private JButton continueButton;
	private JButton demoButton;
	
	private JTextField m_ipAddress;
	private JTextField m_port;
	private JTextField m_clientId;
    private JTextField text1;
    private JPasswordField text2;
    
    private ImageLoader statusImage1;
    private ImageLoader statusImage2;
    
    private Boolean status1 = false;
    private Boolean status2 = false;

	public HomepagePanel(AbstractFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	protected JPanel layout() {
		//JPanel penampung = new JPanel();
		ImagePanel penampung = new ImagePanel(new
				ImageIcon("src.images/XtendTrading_lar.png").getImage());
		penampung.setOpaque(false);
		//penampung.setBackground(new Color(0xFF0000));
		penampung.setLayout(new GridBagLayout());
		
		JPanel subPenampung1 = new JPanel();
		subPenampung1.setLayout(new GridBagLayout());
		JPanel subPenampung2 = new JPanel();
		subPenampung2.setLayout(new GridBagLayout());
		JPanel subPenampung3 = new JPanel();
		subPenampung3.setLayout(new GridBagLayout());
		JPanel subPenampung4 = new JPanel();
		subPenampung4.setLayout(new GridBagLayout());

        Border bdr = BorderFactory.createEtchedBorder();
        Border titlebdr = BorderFactory.createTitledBorder(bdr, "TWS / IB Gateway Connect");
        Border titlebdr2 = BorderFactory.createTitledBorder(bdr, "XtendTrading.com Connect");
        Border titlebdr3 = BorderFactory.createTitledBorder(bdr, "Status");
        Border titlebdr4 = BorderFactory.createTitledBorder(bdr, "Status");
        subPenampung1.setBorder(titlebdr);
        subPenampung2.setBorder(titlebdr2);
        subPenampung3.setBorder(titlebdr3);
        subPenampung4.setBorder(titlebdr4);

		//TWS / IB Gateway Connect
		int rowIndex = 0;

		GBConstraints agbc2 = new GBConstraints(0, rowIndex);
		agbc2.setAnchor(4);
		agbc2.setInsets(0, 0, 0, 5);
        JLabel label1 = new JLabel( "IP Address :");
        
		GBConstraints agbc3 = new GBConstraints(1, rowIndex);
		agbc3.setFill(1);
		agbc3.ipadx = 75;
		agbc3.setInsets(0,10,0,10);
		agbc3.setAnchor(8);
	    m_ipAddress = new JTextField();

		GBConstraints agbc4 = new GBConstraints(2, rowIndex);
		agbc4.gridheight = 3;
		agbc4.setFill(2);
		agbc4.setAnchor(4);
		agbc4.setInsets(0,10,0,10);
		connectButton = button("Connect", new RequestConnect());
		disconnectButton = button("Disconnect", new RequestDisconnect());
		disconnectButton.setEnabled(false);
		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.setOpaque(false);
		buttonPanel1.setLayout(new GridBagLayout());
		buttonPanel1.add(connectButton,new GBConstraints(0, 0));
		buttonPanel1.add(disconnectButton,new GBConstraints(0, 1));

		/*
		GBConstraints agbc5 = new GBConstraints(3, rowIndex);
		agbc5.gridheight = 3;
		agbc5.setFill(2);
		agbc5.setAnchor(1);
		agbc5.setInsets(0,10,0,10);
		rowIndex++;

		GBConstraints agbc2b = new GBConstraints(0, rowIndex);
		agbc2b.setAnchor(4);
		agbc2b.setInsets(0, 0, 0, 10);
		*/
		rowIndex++;
		
		GBConstraints agbc6 = new GBConstraints(0, rowIndex);
		agbc6.setAnchor(4);
		agbc6.setInsets(0, 0, 0, 5);
        JLabel label2 = new JLabel( "Port :");

		GBConstraints agbc7 = new GBConstraints(1, rowIndex);
		agbc7.setFill(1);
		agbc7.setAnchor(4);
		agbc7.setInsets(0,10,0,10);
	    m_port = new JTextField( "7496");
		rowIndex++;
		
		GBConstraints agbc8 = new GBConstraints(0, rowIndex);
		agbc8.setAnchor(4);
		agbc8.setInsets(0, 0, 0, 5);
        JLabel label3 = new JLabel( "Client ID :");

		GBConstraints agbc9 = new GBConstraints(1, rowIndex);
		agbc9.setFill(1);
		agbc9.setAnchor(4);
		agbc9.setInsets(0,10,0,10);
	    m_clientId = new JTextField( "0");

		//GBConstraints agbc10 = new GBConstraints(0, rowIndex);
		//agbc10.gridwidth = 4;
        
        subPenampung1.add(label1,agbc2);
        subPenampung1.add(m_ipAddress,agbc3);
        subPenampung1.add(buttonPanel1,agbc4);
        //subPenampung1.add(messageLabel,agbc5);
        subPenampung1.add(label2,agbc6);
        subPenampung1.add(m_port,agbc7);
        subPenampung1.add(label3,agbc8);
        subPenampung1.add(m_clientId,agbc9);

        rowIndex = 0;
		GBConstraints agbc11 = new GBConstraints(0, rowIndex);
		agbc11.setAnchor(4);
		agbc11.setFill(2);
		agbc11.setInsets(0, 0, 0, 5);
		statusImage1 = new ImageLoader("src.images/not_ok_icon2.png");
		rowIndex++;
        subPenampung3.add(statusImage1,agbc11);
        
		//XtendTrading.com Connect
        rowIndex = 0;
		GBConstraints bgbc2 = new GBConstraints(0, rowIndex);
		bgbc2.setAnchor(4);
		bgbc2.setInsets(0, 0, 0, 5);
        JLabel label4 = new JLabel("Username :");

		GBConstraints bgbc3 = new GBConstraints(1, rowIndex);
		bgbc3.setFill(1);
		bgbc3.setAnchor(4);
		bgbc3.ipadx = 75;
		bgbc2.setInsets(0, 0, 0, 0);
		text1 = new JTextField(10);

		GBConstraints bgbc6 = new GBConstraints(3, rowIndex);
		bgbc6.setAnchor(6);
		bgbc6.setInsets(5, 10, 5, 10);
		bgbc6.gridheight = 2;
		bgbc6.setFill(2);
		loginButton = button("Login Now", new RequestLogin());
		logoutButton = button("Logout", new RequestLogout());
		logoutButton.setEnabled(false);
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setOpaque(false);
		buttonPanel2.setLayout(new GridBagLayout());
		buttonPanel2.add(loginButton,new GBConstraints(0, 0));
		buttonPanel2.add(logoutButton,new GBConstraints(0, 1));
		rowIndex++;

		GBConstraints bgbc4 = new GBConstraints(0, rowIndex);
		bgbc4.setAnchor(4);
		bgbc4.setInsets(0, 0, 0, 5);
        JLabel label5 = new JLabel("Password :");

		GBConstraints bgbc5 = new GBConstraints(1, rowIndex);
		bgbc5.setAnchor(6);
		bgbc5.ipadx = 75;
		bgbc5.setInsets(0, 0, 0, 0);
		bgbc5.setFill(1);
		text2 = new JPasswordField(10);
		rowIndex++;
		
		/*
		GBConstraints bgbc8 = new GBConstraints(0, rowIndex);
		bgbc8.gridwidth = 3;
		messageLabel2 = new JLabel("haiz kaco kaco");
		rowIndex++;
		*/
		
		subPenampung2.add(label4, bgbc2);
		subPenampung2.add(text1, bgbc3);
		subPenampung2.add(label5, bgbc4);
		subPenampung2.add(text2, bgbc5);
		subPenampung2.add(buttonPanel2, bgbc6);
		//subPenampung2.add(messageLabel2, bgbc8);

        rowIndex = 0;
		GBConstraints bgbc9 = new GBConstraints(0, rowIndex);
		bgbc9.setAnchor(4);
		bgbc9.setFill(2);
		bgbc9.setInsets(0, 0, 0, 5);
		statusImage2 = new ImageLoader("src.images/not_ok_icon2.png");
		rowIndex++;
        subPenampung4.add(statusImage2,bgbc9);
		
		helpButton = button("Help", new doExit());
		exitButton = button("Exit", new doExit());
		demoButton = button("Demo Only", new demoConnect());
		continueButton = button("Continue", new demoConnect());
		continueButton.setEnabled(false);
        JPanel panellogin_SOUTH = new JPanel();
        panellogin_SOUTH.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panellogin_SOUTH.setOpaque(false);
        panellogin_SOUTH.add(demoButton);
        panellogin_SOUTH.add(continueButton);
        panellogin_SOUTH.add(helpButton);
        panellogin_SOUTH.add(exitButton);

		GBConstraints tgbc1 = new GBConstraints(0, 0);
		tgbc1.setFill(3);
		tgbc1.setAnchor(2);
		tgbc1.setInsets(0, 0, 10, 0);
		
		GBConstraints tgbc1b = new GBConstraints(1, 0);
		tgbc1b.setFill(3);
		tgbc1b.setAnchor(2);
		tgbc1b.setInsets(0, 0, 10, 0);
		
		GBConstraints tgbc2 = new GBConstraints(0, 1);
		tgbc2.setFill(3);
		tgbc2.setAnchor(2);
		tgbc2.setInsets(0, 0, 10, 0);
		
		GBConstraints tgbc2b = new GBConstraints(1, 1);
		tgbc2b.setFill(3);
		tgbc2b.setAnchor(2);
		tgbc2b.setInsets(0, 0, 10, 0);
		
		GBConstraints tgbc3 = new GBConstraints(0, 2);
		tgbc3.gridwidth = 2;
		tgbc3.setFill(3);
		tgbc3.setInsets(0, 0, 10, 0);
		
		GBConstraints tgbc4 = new GBConstraints(0, 3);
		tgbc4.gridwidth = 2;
		tgbc4.setFill(3);
		tgbc4.setInsets(0, 0, 10, 0);
		
		messageLabel = new JLabel("Welcome to XtendTrading.com Automatic Robot.");
		messageLabel.setForeground(new Color(0xFF0000));
		
        penampung.add(subPenampung1,tgbc1);
        penampung.add(subPenampung3,tgbc1b);
        penampung.add(subPenampung2,tgbc2);
        penampung.add(subPenampung4,tgbc2b);
        penampung.add(panellogin_SOUTH,tgbc3);
        penampung.add(messageLabel,tgbc4);

		return penampung;
	}
	
    // ------------ Request Code Goes Here
    private class RequestConnect implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	setMessage("Searching for IB Gateway / Trader WorkStation Now...");
        	String ip = m_ipAddress.getText();
        	int port = 4001;
        	int clientId = 0;
        	Boolean isValid = true;
        	if("".equals(m_port.getText())){
        		setMessage("Port must not be empty. Default port is 4001.");
        		isValid = false;
        	}else{
        		port = Integer.parseInt(m_port.getText());
        	}

        	if("".equals(m_clientId.getText())){
        		setMessage("Client ID must not be empty. Default Client ID is 0.");
        		isValid = false;
        	}else{
        		clientId = Integer.parseInt(m_clientId.getText());
        	}
        	if(isValid){
                getMainFrame().getController(HomepageController.class).ConnectingIBGateway(ip,port,clientId);
        	}
        	//*/
        }
    }
    
    private class RequestDisconnect implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getMainFrame().getController(HomepageController.class).DisconnectingIBGateway();
        }
    }
    
    private class RequestLogin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	setMessage("Attempting to connect XtendTrading.com...");
        	Boolean isValid = true;
        	String username = text1.getText().trim();
    		char[] password = text2.getPassword();
        	if("".equals(username)){
        		setMessage("Please fill in your username.");
        		isValid = false;
        	}else{
        		if(password.length == 0){
            		setMessage("Please fill in your password.");
            		isValid = false;
        		}
        	}
        	if(isValid){
                getMainFrame().getController(HomepageController.class).ConnectingServerLogin(username,password);
        	}
            Arrays.fill(password, '0');
            text2.selectAll();
        }
    }
    
    private class RequestLogout implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getMainFrame().getController(HomepageController.class).DisconnectingServerLogin();
        }
    }

    private class doExit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getMainFrame().getController(HomepageController.class).QuitApp();
        }
    }
	
    private class demoConnect implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	getMainFrame().getController(HomepageController.class).GoToNextPanel();
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
    public void SetStatusAndButton(final int statusType, final Boolean status) {
		if(statusType == 1){
			setStatus1(status);
		}else if(statusType == 2){
			setStatus2(status);
		}
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				if(getStatus1()){
					statusImage1.setImage("src.images/ok_icon2.png");
					connectButton.setEnabled(false);
					disconnectButton.setEnabled(true);
					statusImage1.repaint();
				}else{
					statusImage1.setImage("src.images/not_ok_icon2.png");
					connectButton.setEnabled(true);
					disconnectButton.setEnabled(false);
					continueButton.setEnabled(false);
					statusImage1.repaint();
				}
				if(getStatus2()){
					statusImage2.setImage("src.images/ok_icon2.png");
					loginButton.setEnabled(false);
					logoutButton.setEnabled(true);
					statusImage2.repaint();
				}else{
					statusImage2.setImage("src.images/not_ok_icon2.png");
					loginButton.setEnabled(true);
					logoutButton.setEnabled(false);
					continueButton.setEnabled(false);
					statusImage2.repaint();
				}
				RevalidateContinueButton();
			}
		});
    }
    public void RevalidateContinueButton(){
		continueButton.setEnabled(false);
		if(getStatus1() && getStatus2()){
			continueButton.setEnabled(true);
		}
    }

	public void setStatus1(Boolean status1) {
		this.status1 = status1;
	}

	public Boolean getStatus1() {
		return status1;
	}

	public void setStatus2(Boolean status2) {
		this.status2 = status2;
	}

	public Boolean getStatus2() {
		return status2;
	}
}
