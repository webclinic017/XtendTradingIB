package com.xtendtrading.ibbot.view.component;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6100534518149101889L;

	public ImageButton(String text, ImageIcon icon, int n, int e, int s, int w) {
		//setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
		setIcon(icon);
		setMargin(new Insets(n,e,s,w));
		setIconTextGap(0);
		setText(text);
	}
	public ImageButton(ImageIcon icon, ImageIcon icon2, int top, int side) {
		setSize(icon.getImage().getWidth(null)+top, icon.getImage().getHeight(null)+side);
		setIcon(icon);
		setPressedIcon(icon2);
		setRolloverIcon(icon2);
		setSelectedIcon(icon2);
		setRolloverSelectedIcon(icon2);
		setMargin(new Insets(top,side,top,side));
		setIconTextGap(0);
		setText(null);
		setBorderPainted(false);
		setBorder(null);
        setBorderPainted(false); 
        setContentAreaFilled(false); 
        setFocusPainted(false); 
        setOpaque(false);

	}
	public ImageButton(ImageIcon icon, int top, int side) {
		setSize(icon.getImage().getWidth(null)+top, icon.getImage().getHeight(null)+side);
		setIcon(icon);
		setMargin(new Insets(top,side,top,side));
		setIconTextGap(0);
		setText(null);
	}

	public void paintComponent(Graphics g) {
		if (isEnabled()) {
			super.paintComponent(g);
			return;
		}
		BufferedImage buf = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_RGB);
		super.paintComponent(buf.getGraphics());
		float[] my_kernel = { 0.10f, 0.10f, 0.10f, 0.10f, 0.20f, 0.10f, 0.10f,
				0.10f, 0.10f };
		ConvolveOp op = new ConvolveOp(new Kernel(3, 3, my_kernel));
		Image img = op.filter(buf, null);
		g.drawImage(img, 0, 0, null);

	}

}
