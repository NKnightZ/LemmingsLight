package lemmingsLight.model.element;

import java.awt.Color;

import lemmingsLight.model.Game;
import lemmingsLight.state.BlockerState;
import lemmingsLight.state.BomberState;
import lemmingsLight.state.BuilderState;
import lemmingsLight.state.ClimberState;
import lemmingsLight.state.DiggerState;
import lemmingsLight.state.LemmingsState;
import lemmingsLight.state.MinnerState;
import lemmingsLight.state.NormalState;
import lemmingsLight.state.ParachuterState;
import lemmingsLight.state.States;

public class Lemmings extends Element {
	private int direction = 1;
	private int height;
	private int depth = 0;
	private LemmingsState states;
	private static final Color PURPLE = new Color(102,0,153);
	private static final Color DARK_RED = new Color(204,0,0);

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Lemmings(Game game, int x, int y) {
		super(game, x, y);
		states = new NormalState(this);
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	@Override
	public Color getColor() {
		switch(states.getState()) {
			case PARACHUTEUR:
				return PURPLE;
			case BLOQUEUR:
				return DARK_RED;
			case BOMBEUR:
				return Color.ORANGE;
		default:
			return Color.GREEN;
		}
	}
	@Override
	public void updateElement(){
		states.move();
	}
	@Override
	public Type getType() {
		return Type.Lemmings;
	}
	public void setState(States state) {
		LemmingsState lemmingState;
		switch (state) {
		case NORMAL:
			lemmingState = new NormalState(this);
			break;
		case PARACHUTEUR:
			lemmingState = new ParachuterState(this);
			break;
		case BLOQUEUR:
			lemmingState = new BlockerState(this);
			break;
		case FOREUR:
			lemmingState = new DiggerState(this);
			break;
		case CHARPENTIER:
			lemmingState = new BuilderState(this);
			break;
		case BOMBEUR:
			lemmingState = new BomberState(this);
			break;
		case TUNNELIER:
			lemmingState = new MinnerState(this);
			break;
		case GRIMPEUR:
			lemmingState = new ClimberState(this);
			break;
		default:
			lemmingState = new NormalState(this);
			break;
		}
		this.states = lemmingState;
	}
	
	public void killLemmings() {
		System.out.println("un lemming vient de mourir :(");
		this.delete();
	}

	//detection des obstacles
	
	public boolean hasBlockAt(int x, int y){
		int checkX = this.getX() + x;
		int checkY = this.getY() + y;
		for (Element element : this.getGame().getEntities().getElements()){
			if(element.getType() == Type.Block) {
				if(element.getY() == checkY && element.getX() == checkX){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean hasDestructibleBlockAt(int x, int y){
		int checkX = this.getX() + x;
		int checkY = this.getY() + y;
		for (Element element : this.getGame().getEntities().getElements()){
			if(element.getType() == Type.DestructibleBlock || element.getType() == Type.ExplosiveBlock) {
				if(element.getY() == checkY && element.getX() == checkX){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean hasSpecialBlockAt(int x, int y){
		int checkX = this.getX() + x;
		int checkY = this.getY() + y;
		for (Element element : this.getGame().getEntities().getElements()){
			if(element.getType() == Type.SpecialBlock) {
				if(element.getY() == checkY && element.getX() == checkX){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean hasBlockerAt(int x, int y){
		int checkX = this.getX() + x;
		int checkY = this.getY() + y;
		for (Element element : this.getGame().getEntities().getElements()){
			if(element.getType() == Type.Lemmings) {
				BlockerState lemming = new BlockerState(this);
				if(element.getY() == checkY && element.getX() == checkX && lemming.getState() == States.BLOQUEUR){
					return true;
				}
			}
		}
		return false;
	}
	
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
}

