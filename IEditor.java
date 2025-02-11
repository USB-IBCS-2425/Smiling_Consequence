import java.awt.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.*;

class ImageEditing {
    private JFrame startFrame;
    private JLabel welcomeText;
    public ImageIcon icon;
    public BufferedImage im, originalIm;
    public JLabel lab;
    public JButton contrastButton;
    public JButton highlightButton;
    public JButton resetButton;
    public JButton blurButton;
    public JButton rotateButton;
    public JButton edgeButton;
    public JFrame f;
    public JPanel p;

    public ImageEditing() {
        startFrame = new JFrame("Image Editor");
        startFrame.setSize(400, 500);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setLayout(new GridLayout(7, 1));

        welcomeText = new JLabel("Welcome to the Image Editor", JLabel.CENTER);
        startFrame.add(welcomeText);

        contrastButton = new JButton("Contrast");
        contrastButton.setActionCommand("CONTRAST");
        contrastButton.addActionListener(new ButtonClickListener());
        startFrame.add(contrastButton);

        highlightButton = new JButton("Highlight Red");
        highlightButton.setActionCommand("HIGHLIGHT");
        highlightButton.addActionListener(new ButtonClickListener());
        startFrame.add(highlightButton);

        resetButton = new JButton("Reset");
        resetButton.setActionCommand("RESET");
        resetButton.addActionListener(new ButtonClickListener());
        startFrame.add(resetButton);

        blurButton = new JButton("Blur");
        blurButton.setActionCommand("BLUR");
        blurButton.addActionListener(new ButtonClickListener());
        startFrame.add(blurButton);

        rotateButton = new JButton("Rotate");
        rotateButton.setActionCommand("ROTATE");
        rotateButton.addActionListener(new ButtonClickListener());
        startFrame.add(rotateButton);

        edgeButton = new JButton("Edge Detection");
        edgeButton.setActionCommand("EDGE");
        edgeButton.addActionListener(new ButtonClickListener());
        startFrame.add(edgeButton);

        try {
            im = ImageIO.read(new File("Cat.jpg"));
            originalIm = ImageIO.read(new File("Cat.jpg")); 
        } catch (IOException e) {
            System.out.println("Error reading image: " + e.getMessage());
        }

        icon = new ImageIcon(im);
        f = new JFrame();
        p = new JPanel();
        lab = new JLabel(icon);
        p.add(lab);
        f.add(p);
        f.pack();
        f.setVisible(true);

        startFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            if (command.equals("CONTRAST")) {
                applyContrast();
            } else if (command.equals("HIGHLIGHT")) {
                applyHighlight();
            } else if (command.equals("RESET")) {
                resetImage();
            } else if (command.equals("BLUR")) {
                applyBlur();
            } else if (command.equals("ROTATE")) {
                rotateImage();
            } else if (command.equals("EDGE")) {
                applyEdgeDetection();
            }
            updateImage();
        }
    }

    private void applyContrast() {
        int width = im.getWidth();
        int height = im.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = im.getRGB(i, j);
                Color color = new Color(rgb);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                
                if (r < 128){
                    r = r-20;
                } 
                else {
                    r=r+20;
                }
                if (g < 128){
                    g = g-20;
                } 
                else {
                    g=g+20;
                }
                if (b < 128){
                    b = b-20;
                } 
                else {
                    b=b+20;
                }

                
                r = Math.max(0, Math.min(255, r));
                g = Math.max(0, Math.min(255, g));
                b = Math.max(0, Math.min(255, b));
                
                im.setRGB(i, j, new Color(r, g, b).getRGB());
            }
        }
    }

    private void applyHighlight() {
        int width = im.getWidth();
        int height = im.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = im.getRGB(i, j);
                Color color = new Color(rgb);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                
                if (r >= g && r >= b) {
                    im.setRGB(i, j, rgb);
                } else {
                    int gray = (r + g + b) / 3;
                    im.setRGB(i, j, new Color(gray, gray, gray).getRGB());
                }
            }
        }
    }

    private void resetImage() {
        im = new BufferedImage(originalIm.getWidth(), originalIm.getHeight(), originalIm.getType());
        Graphics g = im.getGraphics();
        g.drawImage(originalIm, 0, 0, null);
        g.dispose();
    }

    private void applyBlur() {
        int width = im.getWidth();
        int height = im.getHeight();
        BufferedImage blurred = new BufferedImage(width, height, im.getType());
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                int sumR = 0, sumG = 0, sumB = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        Color color = new Color(im.getRGB(i + x, j + y));
                        sumR += color.getRed();
                        sumG += color.getGreen();
                        sumB += color.getBlue();
                    }
                }
                int r = sumR / 9;
                int g = sumG / 9;
                int b = sumB / 9;
                blurred.setRGB(i, j, new Color(r, g, b).getRGB());
            }
        }
        im = blurred;
    }

    private void rotateImage() {
        int width = im.getWidth();
        int height = im.getHeight();
        BufferedImage rotated = new BufferedImage(width, height, im.getType());
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                rotated.setRGB(width - i - 1, height - j - 1, im.getRGB(i, j));
            }
        }
        im = rotated;
    }

    private void applyEdgeDetection() {
        int width = im.getWidth();
        int height = im.getHeight();
        BufferedImage edgeImage = new BufferedImage(width, height, im.getType());
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                int color1 = im.getRGB(i, j);
                int color2 = im.getRGB(i + 1, j);
                if (Math.abs(color1 - color2) > 300) {
                    edgeImage.setRGB(i, j, Color.BLACK.getRGB());
                } else {
                    edgeImage.setRGB(i, j, Color.WHITE.getRGB());
                }
            }
        }
        im = edgeImage;
    }

    private void updateImage() {
        icon = new ImageIcon(im);
        lab.setIcon(icon);
        lab.repaint();
    }

    public static void main(String[] args) {
        new ImageEditing();
    }
}

