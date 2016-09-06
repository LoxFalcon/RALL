/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorconeventos;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Arturo
 */
public class ImageLoader extends JPanel {

    private String filePath;
    private Image image;

    public ImageLoader() {
        
    }

    public ImageLoader(String path) {
        filePath = path;
        image = new ImageIcon(getClass().getResource(filePath)).getImage();
    }

    public ImageLoader(Image image) {
        if (image != null) {
            this.image = image;
        }
    }

    public void setImage(String filePath) {
        this.filePath = filePath;
        if (this.filePath != null) {
            image = new ImageIcon(
                    getClass().getResource(this.filePath)
            ).getImage();
        } else {
            image = null;
        }

        repaint();
    }

    public void setImage(Image nuevaImagen) {
        image = nuevaImagen;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
        } else {
            setOpaque(true);
        }
        super.paint(g);
    }

}
