package lemmingsLight.model;

import java.util.ArrayList;
import java.util.List;

import lemmingsLight.model.element.Block;
import lemmingsLight.model.element.Ceiling;
import lemmingsLight.model.element.DestructibleBlock;
import lemmingsLight.model.element.Enter;
import lemmingsLight.model.element.Exit;
import lemmingsLight.model.element.Lave;
import lemmingsLight.model.element.SpecialBlock;
import lemmingsLight.model.element.Teleporter;
import lemmingsLight.state.States;
import lemmingsLight.view.Observer;

public class Game{
	private States curState;
	private Entities entities = new Entities();
	private List<Observer> observers;
	private int score;
	private int nbLemmings;
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	public void unregisterObservser(Observer o) {
		observers.remove(o);
	}
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
	private Exit exit1 = new Exit(this, 14, 13);
	private Exit exit2 = new Exit(this, 23, 13);
	private Enter enter1 = new Enter(this, 3, 1, 2); 	 //2 lemmings
	private Enter enter2 = new Enter(this, 13, 1, 3);	 //3 lemmings

	public Game() {
		observers = new ArrayList<>();
		for (Block block : new Ceiling(this).getListCeiling()) {
			entities.addElement(block);
		}
		//Entrée
		entities.addElement(enter1); 					
		entities.addElement(enter2);
		
		nbLemmings = enter1.getNbLemmings() + enter2.getNbLemmings();

		//Sortie
		entities.addElement(exit1);
		entities.addElement(exit2);

		//Teleporteur
		entities.addElement(new Teleporter(this, 23, 4, 12, 13));
		entities.addElement(new Teleporter(this, 13, 10, 16, 12));
	
		//Sol
	
		for(int i=1; i<9; i++) {
			entities.addElement(new Block(this, i, 14));
		}
		for(int i=9; i<12; i++) {
			entities.addElement(new Lave(this, i, 14));
		}
		for(int i=12; i<16; i++) {
			entities.addElement(new Block(this, i, 14));
		}
		for(int i=16; i<18; i++) {
			entities.addElement(new Lave(this, i, 14));
		}
		for(int i=18; i<24; i++) {
			entities.addElement(new Block(this, i ,14));
		}
		
		//Plateforme, mur et autre element du jeux
		
		for(int i=4; i<6; i++) {
			entities.addElement(new Block(this, 19, i));
			entities.addElement(new Block(this, 20, i));
		}
		
		for(int i=3; i<24; i++) {
			entities.addElement(new Block(this, i, 8)); 
		}
		
		for(int i=11; i<15; i++) {
			entities.addElement(new Block(this, 12, i));
		}
		
		for(int i=11; i<12; i++) {
			entities.addElement(new Block(this, 13, i));
		}

		for(int i=9; i<12; i++) {
			entities.addElement(new Block(this, 14, i));
		}

		for(int i=9; i<14; i++) {
			entities.addElement(new Block(this, 15, i));
		}

		for(int i=5; i<6; i++) {
			entities.addElement(new Block(this, 21, i));
			entities.addElement(new Block(this, 22, i));
			entities.addElement(new Block(this, 23, i));
		}
		
		entities.addElement(new DestructibleBlock(this, 19, 6));
		entities.addElement(new SpecialBlock(this, 19, 7));

		for(int i=6; i<8; i++) {
			entities.addElement(new DestructibleBlock(this, 20, i));
			entities.addElement(new DestructibleBlock(this, 21, i));
			entities.addElement(new DestructibleBlock(this, 22, i));
			entities.addElement(new DestructibleBlock(this, 23, i));
		}
		
		for(int i=8; i<14; i++) {
			entities.addElement(new DestructibleBlock(this, 1, i));
			entities.addElement(new DestructibleBlock(this, 2, i));
		}
		
		for(int i = 1 ; i<11; i++) {
			entities.addElement(new Block(this, i, 5));
		}
		
		entities.addElement(new Block(this, 10, 4));
		entities.addElement(new Block(this, 10, 3));
		
		for(int i=4; i<10; i++) {
			entities.addElement(new DestructibleBlock(this, i, 6));
			entities.addElement(new DestructibleBlock(this, i, 7));
		}
		
		for(int i=20; i<22; i++) {
			entities.addElement(new DestructibleBlock(this, i, 11));
			entities.addElement(new DestructibleBlock(this, i, 12));
			entities.addElement(new DestructibleBlock(this, i, 13));
		}	
		for(int i=20; i<24; i++) {
			entities.addElement(new DestructibleBlock(this, i, 10));
			entities.addElement(new DestructibleBlock(this, i, 9));
		}
		for(int i=3; i<10; i++) {
			entities.addElement(new DestructibleBlock(this, i, 9));
			for(int j = 4; j<9; j++) {
				entities.addElement(new DestructibleBlock(this, j, 10));
			}
		}
		
		for(int i=2; i<5; i++) {
			entities.addElement(new DestructibleBlock(this, 21, i));
		}

		for(int i=20; i<24; i++) {
			entities.addElement(new DestructibleBlock(this, i, 1));
		}
		
		for(int i=16; i<20; i++) {
			entities.addElement(new DestructibleBlock(this, i, 9));
		}	
		for(int i=19; i>15; i--) {
			entities.addElement(new DestructibleBlock(this, i, 10));
		}	
	}
	
	public Exit getExit1() {
		return exit1;
	}
	public Exit getExit2() {
		return exit2;
	}
	public int getScore() {
		return score;
	}
	public States getCurState() {
		return curState;
	}
	public void setCurState(States curState) {
		this.curState = curState;
	}	
	public Entities getEntities() {
		return entities;
	}
	public void setNbLemmings(int nbLemmings) {
		this.nbLemmings = nbLemmings;
	}
	public int getNbLemmings() {
		return nbLemmings;
	}
	public void run() {
		while(true && nbLemmings != 0) {
			notifyObservers();
			entities.updateElements();
			notifyObservers();
			if(nbLemmings == 0) {
				System.out.println("Game Over");
			}
			try {
		    	Thread.sleep(700);
		    } catch (InterruptedException e) {
		    	e.printStackTrace();
		    }
		}
	}
}
