package lemmingsLight.view;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import lemmingsLight.controller.MyMouse;
import lemmingsLight.model.Game;
import lemmingsLight.model.element.Element;
import lemmingsLight.state.States;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ConcurrentModificationException;

public class GameView extends JComponent implements Observer{
	private static final long serialVersionUID = 1L;
	private Game game;
    private int size = 20;
	private JPanel panCom = new JPanel(); 
	private int score;
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	
	private JButton b1 = new JButton("normal");
	private JButton b2 = new JButton("bloquer"); 
	private JButton b3 = new JButton("creuser"); 
	private JButton b4 = new JButton("tunnel");
	private JButton b5 = new JButton("bombe");
	private JButton b6 = new JButton("escalier"); 
	private JButton b7 = new JButton("grimper");
	private JButton b8 = new JButton("parachute");
	
	public GameView(Game game) {
		this.game = game;
		//MOUSE
		addMouseListener(new MyMouse(this));
		
	    //PANNEAU DE CONTROLE	
	    
	    panCom.setBounds(0, 320, 500, 200); 
	    panCom.setBackground(Color.DARK_GRAY);
	    add(panCom);
	  	
	    b1.addActionListener(e->game.setCurState(States.NORMAL));
		b2.addActionListener(e->game.setCurState(States.BLOQUEUR));
		b3.addActionListener(e->game.setCurState(States.FOREUR));
		b4.addActionListener(e->game.setCurState(States.TUNNELIER));
		b5.addActionListener(e->game.setCurState(States.BOMBEUR));
		b6.addActionListener(e->game.setCurState(States.CHARPENTIER));
        b7.addActionListener(e->game.setCurState(States.GRIMPEUR));
        b8.addActionListener(e->game.setCurState(States.PARACHUTEUR));
        
        panCom.add(b1);
        panCom.add(b2);
        panCom.add(b3);
        panCom.add(b4);
        panCom.add(b5);
        panCom.add(b6);
        panCom.add(b7);
        panCom.add(b8);
	}
	
    @Override
    public void paint(Graphics g) {
    	super.paint(g);
    	try {
    		for (Element el : game.getEntities().getElements()) {
    	        g.setColor(el.getColor());
    	        g.fillRect(size * el.getX(), size * el.getY(), size, size);
    		}
    	}catch(ConcurrentModificationException e) {
    		System.out.println("Exception catched !");
    	}
		this.score = game.getExit1().getScore() + game.getExit2().getScore();
		if(game.getNbLemmings() == 0) {
			g.setColor(Color.WHITE);
			g.drawString("Game Over", 410, size*19);
		}
        g.setColor(Color.WHITE);
		g.drawString("Score: " + score, size, size*19);
    }
    @Override
    public void update() {
        repaint();
    }
}

