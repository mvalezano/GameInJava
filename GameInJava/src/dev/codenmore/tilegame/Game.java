package dev.codenmore.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.SpriteSheet;

public class Game implements Runnable
	{

		private Display display;
		public int width, height;

		private boolean running = false;
		private Thread thread;
		public String title;

		private BufferStrategy bs;
		private Graphics g;

		// private BufferedImage testImage; //carica prova.png
		private BufferedImage test; // carica spritesheet
		private SpriteSheet sheet;

		public Game(String title, int width, int height)
			{
				this.width = width;
				this.height = height;
				this.title = title;
//		run();
			}

		private void init()
			{
				display = new Display(title, width, height);
				// testImage =
				// ImageLoader.loadImage("C:\\Users\\bra\\git\\GameInJava\\GameInJava\\res\\textures\\Prova.png");
				test = ImageLoader
						.loadImage("C:\\Users\\bra\\git\\GameInJava\\GameInJava\\res\\textures\\SpriteSheet.png");
				sheet = new SpriteSheet(test);
			}

		private void tick()
			{

			}

		private void render()
			{
				bs = display.getCanvas().getBufferStrategy();
				if (bs == null)
					{
						display.getCanvas().createBufferStrategy(3);
						return;
					}
				g = bs.getDrawGraphics();
				// Clear screen (pulisce lo schermo ogni volta)
				g.clearRect(0, 0, width, height);

				// Draw Here!

				// g.drawImage(testImage, 20, 20, null); //prova
				// g.drawImage(test, 0, 0, null); //spritesheet
				g.drawImage(sheet.crop(0, 0, 32, 32), 5, 5, null);//primo quadrato
				
				// stop here
				bs.show();
				g.dispose();
			}

		public void run()
			{
				init();

				while (running)
					{
						tick();
						render();
					}
				stop();
			}

		public synchronized void start()
			{
				if (running)
					return;
				running = true;
				thread = new Thread(this);
				thread.start();
			}

		public synchronized void stop()
			{
				if (!running)
					return;
				running = false;
				try
					{
						thread.join();
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}

			}
	}
