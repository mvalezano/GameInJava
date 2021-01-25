package dev.codenmore.tilegame.display;

import javax.swing.JFrame;

public class Display
	{
		public JFrame frame;

		public String title;
		public int width, height;

		public Display(String titolo, int larghezza, int altezza)
			{

				this.title = titolo;
				this.width = larghezza;
				this.height = altezza;

				createDisplay();

			}

		private void createDisplay()
			{
				frame = new JFrame(title);
				frame.setSize(width, height);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}

	}
