package lemmingsLight.model.element;

import java.awt.Color;

import lemmingsLight.model.Game;

public class Enter extends Element {
	private int nbLemmings;
	public Enter(Game game, int x, int y, int counter) {
		super(game, x, y);
		this.addSmall(new SmallEnter(game, x, y+1, true, counter));
		nbLemmings = counter;
	}
	private void addSmall(SmallEnter se) {
		this.getGame().getEntities().addElement(se);
	}
	@Override
	public Color getColor() {
		return Color.BLUE;
	}
	@Override
	public void updateElement() {}
	@Override
	public Type getType() {
		return Type.Enter;
	}
	public int getNbLemmings() {
		return nbLemmings;
	}
}
