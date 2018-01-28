

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DialogImage {


    protected static void initUI(String BACKHGROUND_IMAGE_URL) throws MalformedURLException {
        JDialog dialog = new JDialog((Frame) null, DialogImage.class.getSimpleName());
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        final ImageIcon backgroundImage = new ImageIcon(new URL(BACKHGROUND_IMAGE_URL));
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }

            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width = Math.max(backgroundImage.getIconWidth(), size.width);
                size.height = Math.max(backgroundImage.getIconHeight(), size.height);

                return size;
            }
        };
        dialog.add(mainPanel);
        dialog.setSize(400, 300);
        dialog.setVisible(true);
    }


  
        
    }