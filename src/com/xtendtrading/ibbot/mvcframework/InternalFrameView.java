package com.xtendtrading.ibbot.mvcframework;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import static com.xtendtrading.ibbot.mvcframework.ComponentFactory.internalFrame;

public class InternalFrameView<V extends AbstractView<JPanel>> extends AbstractView<JInternalFrame> {
	private final JDesktopPane desktopPane;
	private final V view;
	private final JInternalFrame internalFrame;
	
	public InternalFrameView(AbstractFrame mainFrame, JDesktopPane desktopPane, V view) {
		super(mainFrame);
		this.desktopPane = desktopPane;
		this.view = view;
		this.internalFrame = internalFrame(view.getContentPane(), view.getClass().getSimpleName());
	}
	
	@Override
	protected JInternalFrame layout() {
		// TODO Auto-generated method stub
		return internalFrame;
	}
	
	public void setTitle(String title) {
		internalFrame.setTitle(title);
	}
	
	public V getView() {
		return view;
	}
	
	public void show() {
		desktopPane.add(internalFrame);
		internalFrame.pack();
		internalFrame.setVisible(true);
		try {
			internalFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {
		}
	}
	
	public void close() {
		internalFrame.dispose();
		desktopPane.remove(internalFrame);
	}
}
