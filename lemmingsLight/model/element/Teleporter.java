package lemmingsLight.model.element;

import java.awt.Color;

import lemmingsLight.model.Game;

public class Teleporter extends Element {
	private int targetX;
	private int targetY;
	public Teleporter(Game game, int x, int y, int targetX, int targetY) {
		super(game, x, y);
		this.targetX = targetX;
		this.targetY = targetY;
	}
	@Override
	public Color getColor() {
		return Color.CYAN;
	}
	@Override
	public void updateElement() {
		for (Element element : this.getGame().getEntities().getElements()){
			if(element.getType() == Type.Lemmings) {
				Lemmings lemming = (Lemmings)element;
				if(lemming.getX() == getX() && lemming.getY() == getY()) {
					lemming.setX(targetX);
					lemming.setY(targetY);
				}
			}
		}
	}
	@Override
	public Type getType() {
		return Type.Teleporter;
	}
}
