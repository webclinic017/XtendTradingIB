package com.xtendtrading.ibbot.view;

import static com.xtendtrading.ibbot.mvcframework.ComponentFactory.button;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xtendtrading.ibbot.controller.HomeController;
import com.xtendtrading.ibbot.model.GBConstraints;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.mvcframework.AbstractView;
import com.xtendtrading.ibbot.view.component.ImageLoader;

public class HomePanel extends AbstractView<JPanel> {
	private JLabel messageLabel;
	private JButton connectButton;
	private JButton exitButton;
	private JButton helpButton;
	private JButton demoButton;
	private JTextField m_ipAddress;
	private JTextField m_port;
	private JTextField m_clientId;
	
	public HomePanel(AbstractFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	protected JPanel layout() {
		JPanel penampung = new JPanel();
		int rowIndex = 0;
		penampung.setOpaque(false);
		penampung.setLayout(new GridBagLayout());

		GBConstraints gbc1 = new GBConstraints(0, rowIndex);
		gbc1.gridwidth = 4;
		rowIndex++;

		GBConstraints gbc2 = new GBConstraints(0, rowIndex);
		gbc2.setAnchor(4);
		gbc2.setInsets(0, 0, 0, 10);
        
		GBConstraints gbc3 = new GBConstraints(1, rowIndex);
		gbc3.gridheight = 2;
		gbc3.setFill(1);
		gbc3.ipadx = 75;
		gbc3.setInsets(0,10,0,10);
		gbc3.setAnchor(8);

		GBConstraints gbc4 = new GBConstraints(2, rowIndex);
		gbc4.gridheight = 4;
		gbc4.setFill(2);
		gbc4.setAnchor(4);
		gbc4.setInsets(0,10,0,10);

		GBConstraints gbc5 = new GBConstraints(3, rowIndex);
		gbc5.gridheight = 3;
		gbc5.setFill(2);
		gbc5.setAnchor(1);
		gbc4.setInsets(0,10,0,10);
		rowIndex++;

		GBConstraints gbc2b = new GBConstraints(0, rowIndex);
		gbc2b.setAnchor(4);
		gbc2b.setInsets(0, 0, 0, 10);
		rowIndex++;
		
		GBConstraints gbc6 = new GBConstraints(0, rowIndex);
		gbc6.setAnchor(4);
		gbc6.setInsets(0, 0, 0, 10);

		GBConstraints gbc7 = new GBConstraints(1, rowIndex);
		gbc7.setFill(1);
		gbc7.ipadx = 75;
		gbc7.setAnchor(4);
		gbc7.setInsets(0,10,0,10);
		rowIndex++;
		
		GBConstraints gbc8 = new GBConstraints(0, rowIndex);
		gbc8.setAnchor(4);
		gbc8.setInsets(0, 0, 0, 10);

		GBConstraints gbc9 = new GBConstraints(1, rowIndex);
		gbc9.setFill(1);
		gbc9.ipadx = 75;
		gbc9.setAnchor(4);
		gbc9.setInsets(0,10,0,10);

		GBConstraints gbc5b = new GBConstraints(3, rowIndex);
		gbc5b.setAnchor(1);
		rowIndex++;

		GBConstraints gbc10 = new GBConstraints(0, rowIndex);
		gbc10.gridwidth = 4;

	    m_ipAddress = new JTextField();
	    m_port = new JTextField( "7496");
	    m_clientId = new JTextField( "0");
        JLabel label1 = new JLabel( "IP Address");
        JLabel label1b = new JLabel( "(leave blank for local host)");
        JLabel label2 = new JLabel( "Port");
        JLabel label3 = new JLabel( "Client ID");
		messageLabel = new JLabel("");
		connectButton = button("Connect", new attemptConnect());
		
		helpButton = button("Help", new doExit());
		exitButton = button("Exit", new doExit());
		demoButton = button("Demo Only", new demoConnect());
        JPanel panellogin_SOUTH = new JPanel();
        panellogin_SOUTH.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panellogin_SOUTH.setOpaque(false);
        panellogin_SOUTH.add(helpButton);
        panellogin_SOUTH.add(exitButton);
        
		penampung.add(new ImageLoader("src.images/XtendTrading_lar.png"),gbc1);
		penampung.add(label1,gbc2);
		penampung.add(m_ipAddress,gbc3);
		penampung.add(connectButton,gbc4);
		penampung.add(messageLabel,gbc5);
		penampung.add(panellogin_SOUTH,gbc5b);
		penampung.add(label1b,gbc2b);
		penampung.add(label2,gbc6);
		penampung.add(m_port,gbc7);
		penampung.add(label3,gbc8);
		penampung.add(m_clientId,gbc9);
		penampung.add(demoButton,gbc10);

		return penampung;
		
	}
	
    // ------------ Request Code Goes Here
    private class attemptConnect implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	setMessage("Connecting Now...");
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
                getMainFrame().getController(HomeController.class).connectingIBGateway(ip,port,clientId);
        	}
        }
    }
	
    // ------------ Request Code Goes Here
    private class demoConnect implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	getMainFrame().getController(HomeController.class).demoNextPanel();
        }
    }
    
    private class doExit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getMainFrame().getController(HomeController.class).quitApp();
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
    public void disableButtonConnect() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//disable button
			}
		});
    }
}
