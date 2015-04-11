package views;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import views.*;
import tests.*;
import models.*;


public class NavigationBar extends JTabbedPane implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private MyRosterView myRosterView;
	

	public NavigationBar(Game game) {
		myRosterView = new MyRosterView(game);
		addTab("My Roster",myRosterView);
		JPanel marketView = new MarketView(game);
		addTab("Market", marketView);
		JPanel standingsView = new StandingsView(game);
		addTab("Standings",standingsView);
		JTabbedPane statisticsView = new StatisticsView(game);
		addTab("Statistics", statisticsView);

		addChangeListener(this);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		myRosterView.refresh();
	}
	
	public static void main(String[] args){
		Game game = BasicEntities.generateGame();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setSize(900,700);
		JTabbedPane panel = new NavigationBar(game);
		frame.add(panel);
		frame.setVisible(true);
		frame.setContentPane(panel);
	}

}