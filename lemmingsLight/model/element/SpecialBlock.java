package lemmingsLight.model.element;

import java.awt.Color;

import lemmingsLight.model.Game;

public class SpecialBlock extends Element {

	public SpecialBlock(Game game, int x, int y) {
		super(game, x, y);
	}

	@Override
	public Color getColor() {
		return Color.PINK;
	}

	@Override
	public void updateElement() {		
	}

	@Override
	public Type getType() {
		return Type.SpecialBlock;
	}
}
