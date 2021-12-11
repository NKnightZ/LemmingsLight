package lemmingsLight.state;

import lemmingsLight.model.element.Lemmings;

public class ClimberState extends LemmingsState{

	public ClimberState(Lemmings lemmings) {
		super(lemmings);
	}

	@Override
	public States getState() {
		return States.GRIMPEUR;
	}
	
	@Override
	public void move() {		
		if(lemmings.hasBlockAt(0, 1) || lemmings.hasDestructibleBlockAt(0, 1)){
			if(lemmings.hasBlockAt(lemmings.getDirection(), 0) || lemmings.hasDestructibleBlockAt(lemmings.getDirection(), 0) || lemmings.hasSpecialBlockAt(lemmings.getDirection(), 0)){
				while(lemmings.hasBlockAt(lemmings.getDirection(), 0) || lemmings.hasDestructibleBlockAt(lemmings.getDirection(), 0) || lemmings.hasSpecialBlockAt(lemmings.getDirection(), 0)) {
					lemmings.setY(lemmings.getY() -1);
				}
				lemmings.setX(lemmings.getX() + lemmings.getDirection());
			}
			lemmings.setState(States.NORMAL);
		}
	}
}
