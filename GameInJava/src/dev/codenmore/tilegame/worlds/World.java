package dev.codenmore.tilegame.worlds;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.utils.Utils;

public class World
	{
private Game game;
		private int width, height;
		private int spawnX, spawnY;
		private int[][] tiles;

		public World(Game game,String path)
			{
				this.game=game;
				loadWorld(path);
		
			}

		public void tick()
			{

			}

		public void render(Graphics g)
			{
				for (int y = 0; y < height; y++)
					{
						for (int x = 0; x < width; x++)
							{
								getTile(x, y).render(g, (int)(x * Tile.TILEWIDTH -game.getGameCamera().getxOffset()),
										(int) (y * Tile.TILEHEIGHT -game.getGameCamera().getyOffset()));
							}
					}
			}

		public Tile getTile(int x, int y)
			{
				Tile t = Tile.tiles[tiles[x][y]];
				if (t == null)
					return Tile.dirtTile;
				return t;
			}

		private void loadWorld(String path)
			{
				String file = Utils.loadFileAsString(path);
				String[] tokens = file.split("\\s+");
				width = Utils.parseInt(tokens[0]);
				height = Utils.parseInt(tokens[1]);
				spawnX = Utils.parseInt(tokens[2]);
				spawnY = Utils.parseInt(tokens[3]);

				tiles = new int[width][height];
				for (int y = 0; y < height; y++)
					{
						for (int x = 0; x < width; x++)
							{
								tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
							}
					}

//				width = 5;
//				height = 5;
//				tiles = new int[width][height];
//
//				for (int x = 0; x < width; x++)
//					{
//						for (int y = 0; y < height; y++)
//							{
//								tiles[x][y] = 1;
//
//							}
//					}
			}

	}