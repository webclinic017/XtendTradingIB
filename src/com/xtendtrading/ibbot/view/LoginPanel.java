package com.xtendtrading.ibbot.view;

import static com.xtendtrading.ibbot.mvcframework.ComponentFactory.button;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.xtendtrading.ibbot.controller.IBController;
import com.xtendtrading.ibbot.controller.LoginController;
import com.xtendtrading.ibbot.model.GBConstraints;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.mvcframework.AbstractView;

public class LoginPanel extends AbstractView<JPanel> {

    private JLabel messageLabel;
    private JTextField text1;
    private JPasswordField text2;
	public LoginPanel(AbstractFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	protected JPanel layout() {
		JPanel penampung = new JPanel();
		int rowIndex = 0;
		penampung.setOpaque(false);
		penampung.setLayout(new GridBagLayout());

		GBConstraints gbc2 = new GBConstraints(0, rowIndex);
		gbc2.setAnchor(4);
		gbc2.ipadx = 75;
		gbc2.setInsets(5, 0, 5, 0);
        JLabel label1 = new JLabel("Username :");

		GBConstraints gbc3 = new GBConstraints(1, rowIndex);
		gbc3.setAnchor(6);
		gbc3.ipadx = 75;
		gbc2.setInsets(5, 0, 5, 0);
		text1 = new JTextField(20);
		rowIndex++;

		GBConstraints gbc4 = new GBConstraints(0, rowIndex);
		gbc4.setAnchor(4);
		gbc4.ipadx = 75;
		gbc4.setInsets(5, 0, 5, 0);
        JLabel label2 = new JLabel("Password :");

		GBConstraints gbc5 = new GBConstraints(1, rowIndex);
		gbc5.setAnchor(6);
		gbc5.ipadx = 75;
		gbc5.setInsets(5, 0, 5, 0);
		text2 = new JPasswordField(20);
		rowIndex++;

		GBConstraints gbc6 = new GBConstraints(0, rowIndex);
		gbc6.setAnchor(6);
		gbc6.setInsets(5, 0, 5, 10);
		JButton button1 = button("Login Now", new attemptLogin());
		
		GBConstraints gbc7 = new GBConstraints(1, rowIndex);
		gbc7.setAnchor(4);
		gbc7.setInsets(5, 10, 5, 0);
		JButton button2 = button("Disconnect", new doExit());
		rowIndex++;
		
		GBConstraints gbc8 = new GBConstraints(0, rowIndex);
		gbc8.gridwidth = 2;
		messageLabel = new JLabel();
		rowIndex++;
		
		penampung.add(label1, gbc2);
		penampung.add(text1, gbc3);
		penampung.add(label2, gbc4);
		penampung.add(text2, gbc5);
		penampung.add(button1, gbc6);
		penampung.add(button2, gbc7);
		penampung.add(messageLabel, gbc8);
		return penampung;
	}

    // ------------ Request Code Goes Here
    private class attemptLogin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getMainFrame().getController(LoginController.class).connectingServerLogin(text1.getText(),text2.getPassword());
        }
    }
    
    private class doExit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getMainFrame().getController(IBController.class).onDisconnect();
            getMainFrame().getController(LoginController.class).backToHome();
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
