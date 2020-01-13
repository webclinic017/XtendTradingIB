package com.xtendtrading.ibbot.model;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBConstraints extends GridBagConstraints {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1939295156722830863L;

	public GBConstraints(int x, int y){
		this.gridx = x;
		this.gridy = y;
		
		//default value
		this.fill = GridBagConstraints.NONE;
		this.anchor = GridBagConstraints.CENTER;
		this.insets = new Insets(0,0,0,0);
		this.weightx = 0.0;
		this.weighty = 0.0;
		this.ipadx = 0;
		this.ipady = 0;
		this.gridwidth = 1;
		this.gridheight = 1;
	}
	
	public void setFill(int type){
		switch(type){
			case 1:
				this.fill = GridBagConstraints.HORIZONTAL;
				break;
			case 2:
				this.fill = GridBagConstraints.VERTICAL;
				break;
			case 3:
				this.fill = GridBagConstraints.BOTH;
				break;
			default:
				this.fill = GridBagConstraints.NONE;
				break;
		}
	}
	
	public void setAnchor(int type){
		switch(type){
			case 1:
				this.anchor = GridBagConstraints.FIRST_LINE_START;
				break;
			case 2:
				this.anchor = GridBagConstraints.PAGE_START;
				break;
			case 3:
				this.anchor = GridBagConstraints.FIRST_LINE_END;
				break;
			case 4:
				this.anchor = GridBagConstraints.LINE_START;
				break;
			case 5:
				this.anchor = GridBagConstraints.CENTER;
				break;
			case 6:
				this.anchor = GridBagConstraints.LINE_END;
				break;
			case 7:
				this.anchor = GridBagConstraints.LAST_LINE_START;
				break;
			case 8:
				this.anchor = GridBagConstraints.PAGE_END;
				break;
			case 9:
				this.anchor = GridBagConstraints.LAST_LINE_END;
				break;
			default:
				this.anchor = GridBagConstraints.CENTER;
				break;
		}
	}
	
	public void setInsets(int top, int left, int bottom, int right){
		this.insets = new Insets(top,left,bottom,right);
	}
	
	public void setInsets(int top){
		this.insets = new Insets(top,top,top,top);
	}
	
	public void setInsets(int top, int side){
		this.insets = new Insets(top,side,top,side);
	}
	
	public void setInsets(int top, int side, int bottom){
		this.insets = new Insets(top,side,bottom,side);
	}
}
