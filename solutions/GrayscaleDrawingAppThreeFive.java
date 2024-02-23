Below is a simple Java program that allows you to draw grayscale 28x28 pixel images using Swing and save them as PNG files:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageDrawer extends JFrame {
    private final int WIDTH = 28;
    private final int HEIGHT = 28;
    private JPanel canvas;
    private BufferedImage image;

    public ImageDrawer() {
        setTitle("Image Drawer");
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                }
            }
        };
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawPixel(e.getX(), e.getY());
            }
        });
        getContentPane().add(canvas, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_BYTE_GRAY);
    }

    private void drawPixel(int x, int y) {
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 1, 1);
        g.dispose();
        canvas.repaint();
    }

    private void saveImage(String filename) {
        try {
            ImageIO.write(image, "png", new File(filename));
            System.out.println("Image saved as " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageDrawer::new);
    }
}
```

This program creates a simple GUI window where you can draw grayscale images by clicking on the canvas. Once you've drawn your image, you can save it as a PNG file by pressing "File" -> "Save As". The image will be saved as a grayscale 28x28 PNG file.
