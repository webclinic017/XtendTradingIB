package com.xtendtrading.ibbot.view.component;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader extends Component{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3590885179756895984L;
	private BufferedImage img;

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
    
    public ImageLoader(String imagePath) {
    	setImage(imagePath);
    }
    
    public void setImage(String imagePath){
        try {
            img = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
        }
    }

    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }
}
