package com.xtendtrading.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.xtendtrading.ibbot.view.component.ImageButton;

public class TestBlurButton {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Blurred Button Hack");
			final JButton button = new ImageButton("A Blurred Button", new ImageIcon(
					"src.images/setting_icon.png"),0,0,0,0);
			JButton control = new JButton("Switch");
			control.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent evt) {
				button.setEnabled(!button.isEnabled());
				}
			});

			frame.getContentPane().add(button);
			frame.getContentPane().add("South",control);
			frame.pack();
		}

}
