package lemmingsLight.state;

import java.util.List;

import lemmingsLight.model.element.DestructibleBlock;
import lemmingsLight.model.element.Element;
import lemmingsLight.model.element.Lemmings;
import lemmingsLight.model.element.Type;

public class MinnerState extends LemmingsState{

	public MinnerState(Lemmings lemmings) {
		super(lemmings);
	}
	
	@Override
	public States getState() {
		return States.TUNNELIER;
	}

	public void minning(Type type) {
		List<Element> list = lemmings.getGame().getEntities().getElements();
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY() && element.getX() == lemmings.getX()+1 && element.getType() == type) {
				element.delete();
				break;
			}
		}
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY() && element.getX() == lemmings.getX()-1 && element.getType() == type) {
				element.delete();
				break;
			}
		}
	}
	
	@Override
	public void move() {
		if(lemmings.hasBlockAt(0, 1) || lemmings.hasDestructibleBlockAt(0, 1)){ 
			if(lemmings.hasSpecialBlockAt(lemmings.getDirection(), 0)) {
				lemmings.getGame().getEntities().addElement(new DestructibleBlock(lemmings.getGame(), 16, 13));
				lemmings.getGame().getEntities().addElement(new DestructibleBlock(lemmings.getGame(), 17, 13));
				minning(Type.SpecialBlock);
				lemmings.setX(lemmings.getX() + 1);
			}
			while(lemmings.hasDestructibleBlockAt(lemmings.getDirection(), 0)) {
				minning(Type.DestructibleBlock);
				lemmings.setX(lemmings.getX() + lemmings.getDirection());
			}
			lemmings.setState(States.NORMAL);
		}
	}
}
