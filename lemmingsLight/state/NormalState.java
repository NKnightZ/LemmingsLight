package lemmingsLight.state;

import lemmingsLight.model.element.Lemmings;

public class NormalState extends LemmingsState {
	public NormalState(Lemmings lemmings) {
		super(lemmings);
	}
	@Override
	public States getState() {
		return States.NORMAL;
	}
	@Override
	public void move() {
		if(lemmings.hasBlockAt(0, 1) || lemmings.hasDestructibleBlockAt(0, 1)){ //y'a un block sous mes pieds
			if(lemmings.hasBlockAt(lemmings.getDirection(), 0) || lemmings.hasDestructibleBlockAt(lemmings.getDirection(), 0) || lemmings.hasBlockerAt(lemmings.getDirection(), 0) || lemmings.hasSpecialBlockAt(lemmings.getDirection(), 0)){  //y'a un block devant
				if(lemmings.hasBlockAt(lemmings.getDirection(), -1) || lemmings.hasDestructibleBlockAt(lemmings.getDirection(), -1) || lemmings.hasBlockerAt(lemmings.getDirection(), 0) || lemmings.hasDestructibleBlockAt(0, -1)){   
					lemmings.setDirection(lemmings.getDirection() * -1); //trop haut je fais demi tour
				}else{
					lemmings.setX(lemmings.getX() + lemmings.getDirection()); 
					lemmings.setY(lemmings.getY() - 1); //il saute
				}
	  		}else{	         											
		  		lemmings.setX(lemmings.getX() + lemmings.getDirection());
		  	}
			lemmings.setHeight(0);
		}else{ 
			lemmings.setY(lemmings.getY() + 1);
			lemmings.setHeight(lemmings.getHeight() + 1);
			if(lemmings.getHeight()>=5 && (lemmings.hasBlockAt(0, 1) || lemmings.hasDestructibleBlockAt(0, 1))){
				lemmings.killLemmings();
				if(lemmings.isDeleted()) {
					lemmings.getGame().setNbLemmings(lemmings.getGame().getNbLemmings()-1);
				}
			}
	  	}			
	}
}
