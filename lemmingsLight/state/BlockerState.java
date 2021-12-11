package lemmingsLight.state;

import lemmingsLight.model.element.Lemmings;

public class BlockerState extends LemmingsState{
	public BlockerState(Lemmings lemmings) {
		super(lemmings);
	}
	@Override
	public States getState() {
		return States.BLOQUEUR;
	}
	@Override
	public void move() {
		if(lemmings.hasBlockAt(0, 1) || lemmings.hasDestructibleBlockAt(0, 1)){ 
			//je ne bouge pas
		}else{	        
			lemmings.setY(lemmings.getY() + 1);
			lemmings.setHeight(lemmings.getHeight() + 1);
			if(lemmings.getHeight()>5 && lemmings.hasBlockAt(0, 1)){
				lemmings.killLemmings();
			}
	  	}	
	}
}

