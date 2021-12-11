package lemmingsLight.model.element;

import java.awt.Color;

import lemmingsLight.model.Game;

public class Lave extends Element{
	public Lave(Game game, int x, int y) {
		super(game, x, y);
	}
	@Override
	public Color getColor() {
		return Color.RED;
	}
	@Override
	public void updateElement() {
		for (Element element : this.getGame().getEntities().getElements()){
			if(element.getType() == Type.Lemmings) {
				Lemmings lemming = (Lemmings)element;
				if(lemming.getX() == getX() && lemming.getY() == getY()) {
					lemming.killLemmings();
					if(lemming.isDeleted()) {
						getGame().setNbLemmings(getGame().getNbLemmings()-1);
					}
				}
			}
		}
	}
	@Override
	public Type getType() {
		return Type.Lave;
	}
}
