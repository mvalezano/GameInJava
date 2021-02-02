package dev.codenmore.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display
	{
		public JFrame frame;
        private Canvas canvas;
        
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
				
				canvas = new Canvas();
				canvas.setPreferredSize(new Dimension(width, height));
				canvas.setMaximumSize(new Dimension(width, height));
				canvas.setMinimumSize(new Dimension(width, height));
				
				frame.add(canvas);
				frame.pack();

			

			}

	}
