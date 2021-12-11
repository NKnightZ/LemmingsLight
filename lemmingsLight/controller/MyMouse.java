package lemmingsLight.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import lemmingsLight.model.element.Element;
import lemmingsLight.model.element.Lemmings;
import lemmingsLight.model.element.Type;
import lemmingsLight.view.GameView;

public class MyMouse extends MouseAdapter {
	private GameView view;
	public MyMouse(GameView view) {
		this.view = view;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		for (Element element : this.view.getGame().getEntities().getElements()) {
			if(element.getType() == Type.Lemmings) {
				if(e.getY()/20 == element.getY() && e.getX()/20 == element.getX()) {
					((Lemmings)element).setState(view.getGame().getCurState());
					break;	
				} 
			}
		}
	}
}
