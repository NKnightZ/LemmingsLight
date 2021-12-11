package lemmingsLight;

import java.awt.Color;

import javax.swing.JFrame;

import lemmingsLight.model.Game;
import lemmingsLight.view.GameView;

public class App{	
	
	public static void main(String[] args) {
		Game game = new Game();
		GameView view = new GameView(game);
		game.registerObserver(view);
		
		JFrame frame = new JFrame("Lemmings Light");
		frame.setBackground(Color.GRAY);
		frame.setContentPane(view);
		frame.setSize(500, 415);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.run();
	}
}
