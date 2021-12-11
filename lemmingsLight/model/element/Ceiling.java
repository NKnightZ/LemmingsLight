package lemmingsLight.model.element;

import java.util.ArrayList;
import java.util.List;

import lemmingsLight.model.Game;

public class Ceiling {
	
	private ArrayList<Block> listCeiling = new ArrayList<>();
	
	public Ceiling(Game game) {
		for(int i = 0; i<25; i++) {
			listCeiling.add(new Block(game, i, 0));
		}
		for(int i = 0; i<16; i++) {
			listCeiling.add(new Block(game, 0, i));
		}
		for(int i = 0; i<16; i++) {
			listCeiling.add(new Block(game, 24, i));
		}
		for(int i = 0; i<25; i++) {
			listCeiling.add(new Block(game, i, 15));
		}
	}

	public List<Block> getListCeiling() {
		return listCeiling;
	}
}
