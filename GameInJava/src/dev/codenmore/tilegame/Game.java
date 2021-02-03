package dev.codenmore.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.SpriteSheet;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.State;

public class Game implements Runnable
	{

		private Display display;
		public int width, height;

		private boolean running = false;
		private Thread thread;
		public String title;

		private BufferStrategy bs;
		private Graphics g;

		// States
		private State gameState;
		private State menuState;

		// private BufferedImage testImage; //carica prova.png
		// private BufferedImage test; // carica spritesheet
		// private SpriteSheet sheet;

		
		//Input
		private KeyManager keyManager;

		public Game(String title, int width, int height)
			{
				this.width = width;
				this.height = height;
				this.title = title;
				keyManager= new KeyManager();
//		run();
			}

		private void init()
			{
				display = new Display(title, width, height);
				display.getFrame().addKeyListener(keyManager);
				Assets.init();

				gameState = new GameState(this);
				menuState = new MenuState(this);
				State.setState(gameState);
				// testImage =
				// ImageLoader.loadImage("C:\\Users\\bra\\git\\GameInJava\\GameInJava\\res\\textures\\Prova.png");
				// test =
				// ImageLoader.loadImage("C:\\Users\\bra\\git\\GameInJava\\GameInJava\\res\\textures\\SpriteSheet.png");
				// sheet = new SpriteSheet(test);
			}

		// int x = 0;

		private void tick()
			{
				// x += 1;
				keyManager.tick();
				if (State.getState() != null)
					State.getState().tick();
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

				if (State.getState() != null)
					State.getState().render(g);

				// g.drawImage(Assets.stone, x, 10, null);
				// g.drawImage(testImage, 20, 20, null); //prova
				// g.drawImage(test, 0, 0, null); //spritesheet
				// g.drawImage(sheet.crop(0, 0, 32, 32), 5, 5, null);//primo quadrato

				// stop here
				bs.show();
				g.dispose();
			}

		public void run()
			{
				init();

				int fps = 60;
				double timePerTick = 1000000000 / fps;// 10^9=nanosecondi
				double delta = 0;
				long now;
				long lastTime = System.nanoTime();// restituisce il tempo in nanosec
				long timer = 0;
				int ticks = 0;

				while (running)
					{
						now = System.nanoTime();
						delta += (now - lastTime) / timePerTick;
						timer += now - lastTime;
						lastTime = now;

						if (delta >= 1)
							{
								tick();
								render();
								ticks++;
								delta--;
							}
						if (timer >= 1000000000)
							{
								System.out.println("Ticks and Frames: " + ticks);
								ticks = 0;
								timer = 0;}
				
					}
				stop();
			}
		//getter
		public KeyManager getKeyManager() {
			return keyManager;
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
