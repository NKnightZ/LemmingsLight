package lemmingsLight.state;

import java.util.List;

import lemmingsLight.model.element.Element;
import lemmingsLight.model.element.Lemmings;
import lemmingsLight.model.element.Type;

public class BomberState extends LemmingsState{
	private int steps = 3;
	public BomberState(Lemmings lemmings) {
		super(lemmings);
	}

	@Override
	public States getState() {
		return States.BOMBEUR;
	}
	
	public void blast() {
		List<Element> list = lemmings.getGame().getEntities().getElements();
		
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()+1 && element.getX() == lemmings.getX() && element.getType() == Type.DestructibleBlock) { //le block sous mes pieds					
				element.delete();
				break;
			}
		}
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()+2 && element.getX() == lemmings.getX() && element.getType() == Type.DestructibleBlock) { //le block sous mes pieds	profondeur 2				
				element.delete();
				break;
			}
		}
		
		//------------------------------------
		
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()+1 && element.getX() == lemmings.getX()-1 && element.getType() == Type.DestructibleBlock) { //block au sol mais derriere mois
				element.delete();
				break;
			}
		}
		
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()+2 && element.getX() == lemmings.getX()-1 && element.getType() == Type.DestructibleBlock) { //block au sol mais derriere mois profondeur 2
				element.delete();
				break;
			}
		}
		//------------------------------------
		
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()+1 && element.getX() == lemmings.getX()+1 && element.getType() == Type.DestructibleBlock) { //block au sol devant moi
				element.delete();
				break;
			}
		}
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()+1 && element.getX() == lemmings.getX()+2 && element.getType() == Type.DestructibleBlock) { //block au sol loin devant moi de 2 cases
				element.delete();
				break;
			}
		}
		//------------------------------------
				
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY() && element.getX() == lemmings.getX()-2 && element.getType() == Type.DestructibleBlock) { //block derriere moi de 2 case
				element.delete();
				break;
			}
		}
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY() && element.getX() == lemmings.getX()-3 && element.getType() == Type.DestructibleBlock) { //block derriere moi de 3 case
				element.delete();
				break;
			}
		}
		//------------------------------------
				
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()-1 && element.getX() == lemmings.getX()-2 && element.getType() == Type.DestructibleBlock) { //block en haut de moi et derriere moi de 2 case
				element.delete();
				break;
			}
		}
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()-1 && element.getX() == lemmings.getX()-3 && element.getType() == Type.DestructibleBlock) { 
				element.delete();
				break;
			}
		}
		//------------------------------------
				
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()-2 && element.getX() == lemmings.getX() && element.getType() == Type.DestructibleBlock) { 
				element.delete();
				break;
			}
		}
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()-3 && element.getX() == lemmings.getX() && element.getType() == Type.DestructibleBlock) {
				element.delete();
				break;
			}
		}
		//------------------------------------
				
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()-3 && element.getX() == lemmings.getX()-1 && element.getType() == Type.DestructibleBlock) { 
				element.delete();
				break;
			}
		}
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()-2 && element.getX() == lemmings.getX()-1 && element.getType() == Type.DestructibleBlock) { 
				element.delete();
				break;
			}
		}
		//------------------------------------
				
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()-1 && element.getX() == lemmings.getX()-1 && element.getType() == Type.DestructibleBlock) { 
				element.delete();
				break;
			}
		}
		
		for (int i = list.size() - 1; i >= 0; --i) {
			Element element = list.get(i);
			if(element.getY() == lemmings.getY()-2 && element.getX() == lemmings.getX()-2 && element.getType() == Type.DestructibleBlock) { 
				element.delete();
				break;
			}
		}
		lemmings.delete();
		if(lemmings.isDeleted()) {
			lemmings.getGame().setNbLemmings(lemmings.getGame().getNbLemmings()-1);
		}
	}
	
	@Override
	public void move() {
		if(lemmings.hasBlockAt(0, 1) || lemmings.hasDestructibleBlockAt(0, 1)){
			if(lemmings.hasBlockAt(lemmings.getDirection(), 0) || lemmings.hasDestructibleBlockAt(lemmings.getDirection(), 0)){  //y'a un block devant
				if(lemmings.hasBlockAt(lemmings.getDirection(), -1) || lemmings.hasDestructibleBlockAt(lemmings.getDirection(), -1)){   
					lemmings.setDirection(lemmings.getDirection() * -1); //demi-tour
					steps--;
					if(steps == 0){
						blast();
					}
				}else{
					lemmings.setX(lemmings.getX() + lemmings.getDirection());
					lemmings.setY(lemmings.getY() - 1);
					steps--;
					if(steps == 0){
						blast();
					}
				}														
	  		}else{	         													
		  		lemmings.setX(lemmings.getX() + lemmings.getDirection());
				steps--;
				if(steps == 0){
					blast();
				}
		  	}
		}else{
			lemmings.setY(lemmings.getY() + 1);
			steps--;
			if(steps == 0){
				blast();
			}
		}
	}
}

