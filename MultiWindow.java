import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MultiWindow {
	private JFrame startFrame;
	private JLabel welcomeText;

	public MultiWindow() {
		startFrame = new JFrame("Image Example");
		startFrame.setSize(400, 200);
		welcomeText = new JLabel("Welcome to the Image Example", JLabel.CENTER);

		startFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		startFrame.add(welcomeText);
		startFrame.setVisible(true);
	}

	public static void main(String[] args) {
		MultiWindow mWin = new MultiWindow();
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(0, 2, 10, 10));


		addImageWithButton(p, "Ragdoll.jpg", "Ragdoll");
		addImageWithButton(p, "AmericanShort.jpg", "American Short Hair");
		addImageWithButton(p, "Bombay.jpg", "Bombay");
		addImageWithButton(p, "Birman.jpg", "Birman");
		addImageWithButton(p, "Chartreux.jpg", "Chartreux");
		addImageWithButton(p, "", "Source: https://www.purina.com/cats/cat-breeds?page=1");


		f.add(p);
		f.pack();
		f.setVisible(true);
	}

	private static void addImageWithButton(JPanel panel, String imagePath, String description) {
		ImageIcon icon = new ImageIcon(imagePath);
		JButton button = new JButton("View " + description);
		button.addActionListener(e -> {
			JFrame imageFrame = new JFrame(description);
			imageFrame.setSize(400, 400);

			JLabel imageLabel = new JLabel(icon);
			JLabel descriptionLabel = new JLabel(description, JLabel.CENTER);

			imageFrame.setLayout(new BorderLayout());
			imageFrame.add(imageLabel, BorderLayout.CENTER);
			imageFrame.add(descriptionLabel, BorderLayout.SOUTH);

			imageFrame.setVisible(true);
		});

		panel.add(button);
	}
}
