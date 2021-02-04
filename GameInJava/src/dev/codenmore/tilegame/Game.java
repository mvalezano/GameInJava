package dev.codenmore.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.ImageLoader;

public class Game implements Runnable {

	private Display display;
	public int width, height;

	private boolean running = false;
	private Thread thread;
	public String title;

	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage testImage;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
//		run();
	}

	private void init() {
		display = new Display(title, width, height);
		testImage=ImageLoader.loadImage("/textures/test.png");

	}

	private void tick() {

	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// draw here
		g.fillRect(0, 0, width, height);
		// stop here
		bs.show();
		g.dispose();
	}

	public void run() {
		init();

		while (running) {
			tick();
			render();
		}
		stop();
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
