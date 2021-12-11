package lemmingsLight.model.element;

import java.awt.Color;

import lemmingsLight.model.Game;

public class SmallEnter extends Element{
	private int x, y;
	private int time = 0;
	private int counter;
	private boolean generator;
	public SmallEnter(Game game, int x, int y, boolean generator, int counter) {
		super(game, x, y);
		this.x = x;
		this.y = y;
		this.generator = generator;
		this.counter = counter;
	}
	@Override
	public Color getColor() {
		return Color.BLUE;
	}
	@Override
	public void updateElement() {
		if(!generator) {
			return;
		}
		if(counter <= 0) {
			return;
		}
		time++;
		if(time > 3) {
			this.getGame().getEntities().addElement(new Lemmings(this.getGame(), x,y+1));
			counter--;
			time = 0;
		}
	}
	public int getCounter() {
		return counter;
	}
	@Override
	public Type getType() {
		return Type.SmallEnter;
	}
}
