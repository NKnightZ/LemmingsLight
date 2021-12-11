package lemmingsLight.model.element;

import java.awt.Color;

import lemmingsLight.model.Game;

public class Block extends Element {
	public Block(Game game, int x, int y) {
		super(game, x, y);
	}
	@Override
	public Color getColor() {
		return Color.BLACK;
	}
	@Override
	public void updateElement() {}
	@Override
	public Type getType() {
		return Type.Block;
	}
}

