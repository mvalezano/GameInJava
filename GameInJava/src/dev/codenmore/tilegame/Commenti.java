//package dev.codenmore.tilegame;

//import java.awt.Color;

//public class Commenti
	
// il sistema cartesiano in java funziona diverso: 
//		
//		         X
//	0,0	__________________
//		| . 1,1           |
//	Y	|                 | Y
//		|_________________|
//	
//	             X
//	             
//	        Y INCREMENTA VERSO IL BASSO
//	        X INCREMENTA VERSO DESTRA
//		L'ORIGINE DEGLI ASSI è IN ALTO A SINISTRA

//      EPISODIO 6 IN GAME.JAVA NEL RENDER DOPO DRAW HERE

//		g.setColor(Color.red);
//		//ogni disegno dopo setColor sarà rosso
//		g.fillRect(10, 50, 50, 70);
//		g.setColor(Color.green);
//		g.fillRect(0, 0, 10, 10);
//		//(drawrect disegna un rettangolo,fillrect lo disegna pieno)	
//	


//video 8
//
//	sprite sheet 128x128 pixel ogni quadrato 32x32 px
// crop immagini
//video 9
//problema con il tick/render: ritaglia e croppa 
//un botto di volte al secondo le immagini
//quindi si fa in un altra maniera ;)
//creiamo nuova classe Assets (contiene ogni img o suono o musica nel gioco)
//
//
//video 10 game loop timer
//si lavora in game->>tick
//spiegazione fps per chi non sa
//regolazione spostamento immagini
//
//controllare fps: game.java riga 110->>
//non riesco a vederlo sulla console!!agg sbagliat a posizione 
//
//
//
//video 11 
//controllore state serve per gestire i menu del gioco
//in state
//spiegazione override
//
//
//video 12
//entità: qualsiasi cosa nel gioco che non sia un TILE
//OGGETTI
//NEMICI
//GIOCATORE
//
//creiamo delle classi per ogni entità
//entity->creature (che estende la entity class)
//creature->player, slime
//entity->item
//item->arrow, sword
//
//la classe entity contiene tutto ciò che le sottoclassi hanno in comune
//le classi creature,item contengono tutto ciò che le sottoclassi hanno in comune
//e così via
//
//
//1. entity: posizione(x,y), tick, render
//
//2.creature: health(punti vita)
//
//3.player: texture, input(dall'utente)
//
//siccome la classe 3 è sottoclasse di 2 e così via 
//prenderà via via gli attributi delle classi superiori
//
//questo si fa creando una nuova classe che usa extends per estendere la classe "madre"























