package lemmingsLight.state;

import java.util.List;

import lemmingsLight.model.element.Element;
import lemmingsLight.model.element.Lemmings;
import lemmingsLight.model.element.Type;

public class DiggerState extends LemmingsState{

	public DiggerState(Lemmings lemmings) {
		super(lemmings);
	}

	@Override
	public States getState() {
		return States.FOREUR;
	}
	
	public void creuser(Type type, Type type2) {
		List<Element> list = lemmings.getGame().getEntities().getElements();
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()+1 && element.getX() == lemmings.getX() && element.getType() == type) {
				element.delete();
				break;
			}
		}
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()+1 && element.getX() == lemmings.getX() && element.getType() == type2) {
				element.delete();
				lemmings.killLemmings();
				break;
			}
		}
	}
	
	@Override
	public void move() {
		if(lemmings.hasDestructibleBlockAt(0, 1)){ 
			while(lemmings.hasDestructibleBlockAt(0, 1)) {
				creuser(Type.DestructibleBlock, Type.ExplosiveBlock); //les blocs explosives ne fonctionne pas mais on peut aussi bien passer en parametre un bloc special qui fait appaitre d'autre block
				lemmings.setY(lemmings.getY()+1);
				lemmings.setDepth(lemmings.getDepth()+1);
				if(lemmings.getDepth() == 5) {
					break;
				}	
			}
		}else if(lemmings.hasBlockAt(0, 1)) {
			System.out.println("impossible à creuser");
			lemmings.setState(States.NORMAL);
		}
		lemmings.setState(States.NORMAL);
	}
}




