package lemmingsLight.model;

import java.util.ArrayList;
import java.util.List;

import lemmingsLight.model.element.Element;

public class Entities {
	private List<Element> elements = new ArrayList<Element>();
	private List<Element> elementsToAdd = new ArrayList<Element>();
    public List<Element> getAllElements() {
        return elements;
    }
    public void addElement(Element element) {
    	elementsToAdd.add(element);
    }
    public void enleverElement(Element element) {
    	elements.remove(element);
    }
    public void updateElements() {
    	for (Element el : elements) {
    		if(!el.isDeleted()){
    			el.updateElement();
    		}
    	}
    	for(int i = elements.size() - 1; i >= 0; --i) {
    		if(elements.get(i).isDeleted()) {
    			elements.remove(i);
    		}
    	}
    	for(Element el : elementsToAdd) {
    		elements.add(el);
    	}
    	elementsToAdd.clear();
    }
	public List<Element> getElements() {
		return elements;
	}
}

