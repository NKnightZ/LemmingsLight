package lemmingsLight.model.element;

import java.awt.Color;

import lemmingsLight.model.Game;

public abstract class Element {
    private int x, y;
    private boolean deleted = false;
    private Game game;
    public Element(Game game, int x, int y) {
    	this.game = game;
        this.x = x;
        this.y = y;
    }
    public abstract Color getColor();
    public abstract void updateElement();
    public abstract Type getType();
    
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void delete() {
    	this.deleted = true;
    }
    public boolean isDeleted() {
    	return this.deleted;
    }
    public Game getGame() {
    	return this.game;
    }
}
