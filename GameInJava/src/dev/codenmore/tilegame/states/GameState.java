package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.worlds.World;

public class GameState extends State
	{
		
		private Player player;
		private World world;
		
		public GameState(Game game) {
			super(game);
			player=new Player(game,100,100);
		world= new World("");
		}
		

	@Override
	public void tick()
		{
			world.tick();
			player.tick();
			
		}

	@Override
	public void render(Graphics g)
		{
			world.render(g);
			player.render(g);
			//Tile.tiles[2].render(g, 0, 0);
			//			g.drawImage(Assets.tree,0,0,null);
		}

		
	}
