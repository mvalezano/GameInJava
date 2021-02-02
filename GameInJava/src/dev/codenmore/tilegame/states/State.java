package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;

public abstract class State
	{
private static State currentState=null;
public static void setState(State state) {
	currentState=state;

}
public static State getState() {
	return currentState;
}
//tutto sto codice sopra nella abstract non c'entra un cazzo 
//con il codice sotto (si potrebbe mettere in un altra classe ez)


//CLASS
		protected Game game;

		public State(Game game) {
			this.game= game;
		}

		public abstract void tick();
		
		public abstract void render(Graphics g);
		
	}
