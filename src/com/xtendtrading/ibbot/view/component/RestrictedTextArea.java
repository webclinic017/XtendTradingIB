package com.xtendtrading.ibbot.view.component;

import javax.swing.JTextArea;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.DocumentFilter;

public class RestrictedTextArea extends JTextArea{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8836515511513486349L;
    private DefaultStyledDocument doc;
	private int characterLimit = 100;

	public RestrictedTextArea(){
	}
	
	public RestrictedTextArea(int limitSize){
        doc = new DefaultStyledDocument();
        this.characterLimit = limitSize;
        doc.setDocumentFilter(new Field1Listener(limitSize));
        super.setDocument(doc);
	}
	
	@Override
	public void setText(String text){
		if(text.length() > this.characterLimit){
			text = text.substring(this.characterLimit);
		}
		super.setText(text);
	}
	
	private class Field1Listener extends DocumentFilter
	{
		private int characterLimit = 100;
		
		public Field1Listener(int i){
			this.characterLimit = i;
		}
		@Override
		public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException
		{
			if(fb.getDocument().getLength()+string.length()>characterLimit)
			{
				return;
			}
			fb.insertString(offset, string, attr);
		}
		
		@Override
		public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException 
		{  
			fb.remove(offset, length);
		}

		@Override
		public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)throws BadLocationException
		{
			if(fb.getDocument().getLength()+text.length()>characterLimit)
			{
				return;
			}
			fb.insertString(offset, text, attrs);
		}
	}
}
