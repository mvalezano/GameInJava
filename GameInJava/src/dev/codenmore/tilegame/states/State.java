package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;

public abstract class State
	{
		private static State currentState = null;

		public static void setState(State state)
			{
				currentState = state;

			}

		public static State getState()
			{
				return currentState;
			}
//tutto sto codice sopra nella abstract non c'entra un cazzo 
//con il codice sotto (si potrebbe mettere in un altra classe ez)

//CLASS
		protected Handler handler;

		public State(Handler handler)
			{
				this.handler = handler;
			}

		public abstract void tick();

		public abstract void render(Graphics g);

	}
