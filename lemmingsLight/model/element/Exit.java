package lemmingsLight.model.element;

import java.awt.Color;

import lemmingsLight.model.Game;

public class Exit extends Element {
	private int score = 0;
	public Exit(Game game, int x, int y) {
		super(game, x, y);
	}
	@Override
	public Color getColor() {
		return Color.MAGENTA;
	}
	@Override
	public void updateElement() {
		for (Element element : this.getGame().getEntities().getElements()){
			if(element.getType() == Type.Lemmings) {
				Lemmings lemming = (Lemmings)element;
				if(lemming.getY() == getY() && lemming.getX() == getX()){
					System.out.println("Lemming sortie");
					score++;
					lemming.delete();
					if(lemming.isDeleted()) {
						getGame().setNbLemmings(getGame().getNbLemmings()-1);
					}
				}
			}
		}
	}

	@Override
	public Type getType() {
		return Type.Exit;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
