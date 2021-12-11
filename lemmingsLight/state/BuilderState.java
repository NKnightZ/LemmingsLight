package lemmingsLight.state;

import lemmingsLight.model.element.DestructibleBlock;
import lemmingsLight.model.element.Lemmings;

public class BuilderState extends LemmingsState{
	private int height = 0;
	private int i = 1;
	private int j = 0;
	public BuilderState(Lemmings lemmings) {
		super(lemmings);
	}

	@Override
	public States getState() {
		return States.CHARPENTIER;
	}
	
	@Override
	public void move() {
		if(lemmings.hasBlockAt(0, 1) || lemmings.hasDestructibleBlockAt(0, 1)){
			while(height != 5) {
				if(lemmings.getDirection() == 1){
					if(lemmings.hasDestructibleBlockAt(5, -1) || lemmings.hasBlockAt(5, -1)){
						lemmings.getGame().getEntities().addElement(new DestructibleBlock(lemmings.getGame(), lemmings.getX()+i,lemmings.getY()+j));
						i++;
						j--;
						height++;
						if(height > 2) {
							break;
						}
					}
					if(lemmings.hasDestructibleBlockAt(4, -1) || lemmings.hasBlockAt(4, -1)){
						lemmings.getGame().getEntities().addElement(new DestructibleBlock(lemmings.getGame(), lemmings.getX()+i,lemmings.getY()+j));
						i++;
						j--;
						height++;
						if(height > 2) {
							break;
						}
					}
					if(lemmings.hasDestructibleBlockAt(3, -1) || lemmings.hasBlockAt(3, -1)) {
						lemmings.getGame().getEntities().addElement(new DestructibleBlock(lemmings.getGame(), lemmings.getX()+i,lemmings.getY()+j));
						i++;
						j--;
						height++;
						if(height > 1) {
							break;
						}
					}
					if(lemmings.hasDestructibleBlockAt(2, -1) || lemmings.hasBlockAt(2, -1)) {
						lemmings.getGame().getEntities().addElement(new DestructibleBlock(lemmings.getGame(), lemmings.getX()+i,lemmings.getY()+j));
						i++;
						j--;
						height++;
						if(height > 0) {
							break;
						}
					}
					if(lemmings.hasDestructibleBlockAt(1, -1) || lemmings.hasBlockAt(1, -1)) {
						break;
					}
					lemmings.getGame().getEntities().addElement(new DestructibleBlock(lemmings.getGame(), lemmings.getX()+i,lemmings.getY()+j));
					i++;
					j--;
					height++;
				}
				if(lemmings.getDirection() == -1){
					if(lemmings.hasDestructibleBlockAt(-5, -1) || lemmings.hasBlockAt(-5, -1)){
						lemmings.getGame().getEntities().addElement(new DestructibleBlock(lemmings.getGame(), lemmings.getX()-i,lemmings.getY()+j));
						i++;
						j--;
						height++;
						if(height > 2) {
							break;
						}
					}
					if(lemmings.hasDestructibleBlockAt(-4, -1) || lemmings.hasBlockAt(-4, -1)){
						lemmings.getGame().getEntities().addElement(new DestructibleBlock(lemmings.getGame(), lemmings.getX()-i,lemmings.getY()+j));
						i++;
						j--;
						height++;
						if(height > 2) {
							break;
						}
					}
					if(lemmings.hasDestructibleBlockAt(-3, -1) || lemmings.hasBlockAt(-3, -1)) {
						lemmings.getGame().getEntities().addElement(new DestructibleBlock(lemmings.getGame(), lemmings.getX()-i,lemmings.getY()+j));
						i++;
						j--;
						height++;
						if(height > 1) {
							break;
						}
					}
					if(lemmings.hasDestructibleBlockAt(-2, -1) || lemmings.hasBlockAt(-2, -1)) {
						lemmings.getGame().getEntities().addElement(new DestructibleBlock(lemmings.getGame(), lemmings.getX()+i,lemmings.getY()+j));
						i++;
						j--;
						height++;
						if(height > 0) {
							break;
						}
					}
					if(lemmings.hasDestructibleBlockAt(-1, -1) || lemmings.hasBlockAt(-1, -1)) {
						break;
					}
					lemmings.getGame().getEntities().addElement(new DestructibleBlock(lemmings.getGame(), lemmings.getX()-i,lemmings.getY()+j));
					i++;
					j--;
					height++;
				}
			}
			lemmings.setState(States.NORMAL);
			i = 1;
			j = 0;	
			height = 0;
		}
	}
}

