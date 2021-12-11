package lemmingsLight.model.element;

import java.awt.Color;

import lemmingsLight.model.Game;

public class DestructibleBlock extends Element{
	private static final Color BROWN = new Color(102,51,0);

	public DestructibleBlock(Game game, int x, int y) {
		super(game, x, y);
	}

	@Override
	public Color getColor() {
		return BROWN;
	}

	@Override
	public void updateElement() {}

	@Override
	public Type getType() {
		return Type.DestructibleBlock;
	}

}
