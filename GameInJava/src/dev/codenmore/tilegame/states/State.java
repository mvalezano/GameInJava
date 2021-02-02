package dev.codenmore.tilegame.states;

import java.awt.Graphics;

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
		public abstract void tick();
		
		public abstract void render(Graphics g);
		
	}
