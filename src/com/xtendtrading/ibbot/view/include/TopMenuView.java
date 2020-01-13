package com.xtendtrading.ibbot.view.include;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.xtendtrading.ibbot.controller.TopMenuController;
import com.xtendtrading.ibbot.mvcframework.AbstractFrame;
import com.xtendtrading.ibbot.mvcframework.AbstractView;

public class TopMenuView extends AbstractView<JMenuBar> {

	private JMenuItem menuL;   
	private JMenuItem menuU;
	private JMenuItem menuE;
	private JMenuItem menuO;
	private JMenuItem menuR;
	private JMenuItem menuS;
	private JMenuItem menuC;
	private JMenuItem menuA;
	private JMenuItem menuV;
	private JMenu menu1;
	private JMenu menu2;
	private JMenu menu3;
	private JMenu menu4;
	private JMenu menu5;
	private JMenu menu6;
	private JMenu menu7;
	
	public TopMenuView(AbstractFrame mainFrame) {
		super(mainFrame);
		// TODO Auto-generated constructor stub
	}

	public JMenuBar getMenuBar() {
		menuL = new JMenuItem("Login");   
		menuU = new JMenuItem("Logout");
		menuE = new JMenuItem("Exit");
		menuO = new JMenuItem("Order");
		menuR = new JMenuItem("Register Here");
		menuS = new JMenuItem("List");
		menuC = new JMenuItem("Change Password");
		menuA = new JMenuItem("Add New");
		menuV = new JMenuItem("View");
        JMenuBar menuBar = new JMenuBar();

        menu1 = new JMenu("File");
        	menu1.setMnemonic(KeyEvent.VK_F);
        	menuBar.add(menu1);
        		menuL.setMnemonic(KeyEvent.VK_L);
        		menu1.add(menuL);
        		menuU.setMnemonic(KeyEvent.VK_U);
	        	menu1.add(menuU);
	        menu1.addSeparator();     
	        	menuE.setMnemonic(KeyEvent.VK_E);
	        	menu1.add(menuE);

        menu2 = new JMenu("Rental");
        	menu2.setMnemonic(KeyEvent.VK_T);
        	menuBar.add(menu2);        
        		menuO.setMnemonic(KeyEvent.VK_O);
	        	menu2.add(menuO);
        
        menu3 = new JMenu("Register");
	        menu3.setMnemonic(KeyEvent.VK_G);
	    	menuBar.add(menu3);
	    		menuR.setMnemonic(KeyEvent.VK_R);
	        	menu3.add(menuR);

        menu4 = new JMenu("Order List");
	        menu4.setMnemonic(KeyEvent.VK_D);
	    	menuBar.add(menu4);
	    		menuS.setMnemonic(KeyEvent.VK_S);
	        	menu4.add(menuS);

        menu5 = new JMenu("Password");
        	menu5.setMnemonic(KeyEvent.VK_P);
	    	menuBar.add(menu5);
	    		menuC.setMnemonic(KeyEvent.VK_C);
	    		menu5.add(menuC);

        menu6 = new JMenu("Film");
        	menu6.setMnemonic(KeyEvent.VK_I);
	    	menuBar.add(menu6);
	    		menuA.setMnemonic(KeyEvent.VK_A);
	    		menu6.add(menuA);

        menu7 = new JMenu("Member");
        	menu7.setMnemonic(KeyEvent.VK_M);
	    	menuBar.add(menu7);
	    		menuV.setMnemonic(KeyEvent.VK_V);
	    		menu7.add(menuV);
	    menuU.setVisible(false);
	    menu2.setVisible(false);
	    menu4.setVisible(false); 
	    menu5.setVisible(false); 
	    menu6.setVisible(false); 
	    menu7.setVisible(false); 
	    
	    menuR.addActionListener(new clickRegisterMenu());
        return menuBar;
	}

	@Override
	protected JMenuBar layout() {
		// TODO Auto-generated method stub
		return null;
	}

	public void switchMenuBar(int itudeh){
		//0 = logout, 1 = member, 2 = staff
		menu1.setVisible(true);
		
    	switch(itudeh){
    	case 0:
    		menu3.setVisible(true);
    		menuL.setVisible(true);
    		menuU.setVisible(false);
    		menu2.setVisible(false);
    		menu4.setVisible(false); 
    		menu5.setVisible(false); 
    		menu6.setVisible(false); 
    		menu7.setVisible(false);
    		break;
    	case 1:
    		menuL.setVisible(false); 
    		menuU.setVisible(true);
    		menu3.setVisible(false);
    		menu2.setVisible(true);
    		menu4.setVisible(true);
    		menu5.setVisible(true);
    		break;
    	case 2:
    		menuL.setVisible(false);
    		menuU.setVisible(true);
    		menu3.setVisible(false);
    		menu5.setVisible(true); 
    		menu6.setVisible(true); 
    		menu7.setVisible(true);
    		break;
    	}
    }
	
	//Action Listener section goes here :
    private class clickRegisterMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getMainFrame().getController(TopMenuController.class).triggerRegisterPanel();
        }
    }

}