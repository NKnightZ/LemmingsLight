package lemmingsLight.state;

import lemmingsLight.model.element.Lemmings;

public class ParachuterState extends LemmingsState{
	public ParachuterState(Lemmings lemmings) {
		super(lemmings);
	}

	@Override
	public States getState() {
		return States.PARACHUTEUR;
	}

	@Override
	public void move() {
		if(lemmings.hasBlockAt(0, 1) || lemmings.hasDestructibleBlockAt(0, 1)) {
			lemmings.setState(States.NORMAL);
		}else{
			lemmings.setY(lemmings.getY() + 1);
		}
	}
}

