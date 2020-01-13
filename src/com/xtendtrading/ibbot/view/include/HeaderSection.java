package com.xtendtrading.ibbot.view.include;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.xtendtrading.ibbot.model.GBConstraints;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.mvcframework.AbstractView;
import com.xtendtrading.ibbot.view.component.GradientPanel;
import com.xtendtrading.ibbot.view.component.ImageButton;

public class HeaderSection extends AbstractView<GradientPanel> {

	public HeaderSection(AbstractFrame mainFrame) {
		super(mainFrame);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4956235790555760872L;
	private ImageButton settingButton;
	private ImageButton aboutButton;


	@Override
	protected GradientPanel layout() {
		GradientPanel penampung = new GradientPanel();
		penampung.setColor1(new Color(0xF6F3EF));
		penampung.setColor2(new Color(0xCCC8C0));
		penampung.setLayout(new GridBagLayout());

		GBConstraints gbc0 = new GBConstraints(0, 0);
		gbc0.setAnchor(6);
		gbc0.ipadx = 395;
		gbc0.setFill(1);
		gbc0.weightx = 1;
		JLabel leftText = new JLabel("");

		GBConstraints gbc1 = new GBConstraints(1, 0);
		gbc1.setAnchor(6);

		GBConstraints gbc3 = new GBConstraints(2, 0);
		gbc3.setAnchor(6);
		gbc3.setInsets(0, 20, 0, 20);

		penampung.add(leftText, gbc0);

		settingButton = new ImageButton("Setting", new ImageIcon(
				"src.images/setting_icon.png"), 10, 0, 10, 0);
		penampung.add(settingButton, gbc1);

		aboutButton = new ImageButton(new ImageIcon(
				"src.images/XtendTrading_sm.png"), 0, 5);
		aboutButton.addActionListener(new showAboutUsDialog()); 
		penampung.add(aboutButton, gbc3);
		disableSettingButton();
		return penampung;
	}

	public void disableSettingButton() {
		settingButton.setEnabled(false);
	}

	public void enableSettingButton() {
		settingButton.setEnabled(true);
	}
    
    private class showAboutUsDialog implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
    		javax.swing.SwingUtilities.invokeLater(new Runnable() {
    			@Override
    			public void run() {
    				//JOptionPane.showMessageDialog(getMainFrame().layout(), "Click OK after you read this", "Click OK", JOptionPane.INFORMATION_MESSAGE);
    				getMainFrame().showMessage("Click OK after you read this");
    			}
    		});
        }
    }
}
