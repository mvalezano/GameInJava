package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.gfx.Assets;

public class GameState extends State
	{
		
		public GameState() {
			
		}

	@Override
	public void tick()
		{
			
			
		}

	@Override
	public void render(Graphics g)
		{
			g.drawImage(Assets.tree,0,0,null);
		}

		
		
		
	}
