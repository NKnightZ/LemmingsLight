package lemmingsLight.state;

import lemmingsLight.model.element.Lemmings;

public abstract class LemmingsState {
	protected Lemmings lemmings;
	
	public LemmingsState(Lemmings lemmings) {
		this.lemmings = lemmings;
	}
	
	public abstract States getState();

	public abstract void move();
}
