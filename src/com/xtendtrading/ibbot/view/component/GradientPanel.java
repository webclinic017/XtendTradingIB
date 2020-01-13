package com.xtendtrading.ibbot.view.component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GradientPanel extends JPanel {

	private static final long serialVersionUID = 4956235790555760872L;
	private Color color1;
	private Color color2;
	private int gradientMode;
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(color1==null){
        	color1 = new Color(0xF6F3EF);
        }
        if(color2==null){
        	color2 = new Color(0xCCC8C0);
        }
        int w = getWidth();
        int h = getHeight();
        
        int gradx;
        int grady;
        switch(gradientMode){
        case 1 :
        	gradx = 0;
        	grady = h;
        	break;
        case 2 :
        	gradx = w;
        	grady = h;
        	break;
        default :
        	gradx = 0;
        	grady = h;
        	break;
        }
        
        GradientPaint gp = new GradientPaint(
            0, 0, color1, gradx, grady, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
    
    public void setColor1(Color col){
    	color1 = col;
    }
    
    public void setColor2(Color col){
    	color2 = col;
    }
    public void setGradientMode(int gm){
    	gradientMode = gm;
    }
}
