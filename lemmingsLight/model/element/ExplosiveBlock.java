package lemmingsLight.model.element;

import java.awt.Color;

import lemmingsLight.model.Game;

public class ExplosiveBlock extends Element{

	public ExplosiveBlock(Game game, int x, int y) {
		super(game, x, y);
	}

	@Override
	public Color getColor() {
		return Color.WHITE;
	}

	@Override
	public void updateElement() {}

	@Override
	public Type getType() {
		return Type.ExplosiveBlock;
	}

}
