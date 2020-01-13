package com.xtendtrading.ibbot.mvcframework;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.xtendtrading.ibbot.mvcframework.AbstractController;
import com.xtendtrading.ibbot.mvcframework.AbstractView;
import static com.xtendtrading.ibbot.mvcframework.ComponentFactory.showFrame;

public abstract class AbstractFrame {
	protected final JFrame frame;
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	protected final Map<Class<? extends AbstractView<? extends JComponent>>, AbstractView<? extends JComponent>> views = 
			new HashMap<Class<? extends AbstractView<? extends JComponent>>, AbstractView<? extends JComponent>>();
	protected final Map<Class<? extends AbstractController>, AbstractController> controllers = 
			new HashMap<Class<? extends AbstractController>, AbstractController>();

	public AbstractFrame() {
		registerAllViews();
		registerAllControllers();
		this.frame = layout();
	}

	protected abstract void registerAllViews();
	
	protected abstract void registerAllControllers();
	
	public abstract JFrame layout();
	
	protected void show() {
		showFrame(frame);
	}
	
	@SuppressWarnings("unchecked")
	public <V extends AbstractView<? extends JComponent>> V getView(Class<V> viewClass) {
		return (V) views.get(viewClass);
	}
	
	@SuppressWarnings("unchecked")
	public <V extends AbstractView<JPanel>> InternalFrameView<V> getInternalFrameView(Class<V> viewClass) {
		return (InternalFrameView<V>) views.get(viewClass);
	}
	
	@SuppressWarnings("unchecked")
	public <C extends AbstractController> C getController(Class<C> controllerClass) {
		return (C) controllers.get(controllerClass);
	}
	
	protected void resizeWindow(int x, int y){
		frame.setBounds((screenSize.width-x)/2, (screenSize.height-y)/2, x, y);
	}

	public void showMessage(String string) {
		// TODO Auto-generated method stub
		
	}

}
