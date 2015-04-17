package views;

import models.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame implements ActionListener {
	
	public enum ActivePanel {
		START_PANEL,MAKE_ROSTER_PANEL,NAVIGATION_BAR,END_GAME;
	}
	
	private ActivePanel activePanel = ActivePanel.START_PANEL;
	private Game game;
	private StartPanel startPanel;
	private MakeRosterPanel makeRosterPanel;
	private JLabel[] nextTurnLabels = new JLabel[14];

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setSize(900,700);
		startPanel = new StartPanel(this);
		add(startPanel);
		setVisible(true);
		//setContentPane(contentPane);
		
		
	}
	
	public void setPanel(JPanel contentPane) {
		//this.contentPane = contentPane;
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(contentPane);
		getContentPane().revalidate();
	}
	
	public void setMakeRosterPanel() {
		/*makeRosterPanel = new MakeRosterPanel();
		setPanel(makeRosterPanel);
		remove(startPanel);
		add(new MakeRosterPanel());*/
		
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		MakeRosterPanel panel = new MakeRosterPanel(game);
		getContentPane().add(panel);
		getContentPane().revalidate();
		
		JButton btn = new JButton("Next turn");
		btn.addActionListener(new MakeRosterPanelListener(game,panel,this));
		btn.setBounds(650,550,150,50);
		panel.add(btn);
	}
	
	public void setNavigationBar() {
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		NavigationBar navigationBar = new NavigationBar(game);
		getContentPane().add(navigationBar);
		getContentPane().revalidate();

		JButton btn1 = new JButton("Next turn");
		btn1.addActionListener(new NavigationBarListener(game,this,nextTurnLabels));
		btn1.setBounds(680,50,150,40);
		navigationBar.getMyRosterView().add(btn1);
		nextTurnLabels[0] = new JLabel("Invalid roster");
		nextTurnLabels[0].setBounds(700,30,150,20);
		nextTurnLabels[0].setVisible(false);
		navigationBar.getMyRosterView().add(nextTurnLabels[0]);
		
		JButton btn2 = new JButton("Next turn");
		btn2.addActionListener(new NavigationBarListener(game,this,nextTurnLabels));
		btn2.setBounds(680,50,150,40);
		navigationBar.getMarketView().add(btn2);
		nextTurnLabels[1] = new JLabel("Invalid roster");
		nextTurnLabels[1].setBounds(700,30,150,20);
		nextTurnLabels[1].setVisible(false);
		navigationBar.getMarketView().add(nextTurnLabels[1]);
		
		JButton btn3 = new JButton("Next turn");
		btn3.addActionListener(new NavigationBarListener(game,this,nextTurnLabels));
		btn3.setBounds(680,50,150,40);
		navigationBar.getStandingsView().add(btn3);
		nextTurnLabels[2] = new JLabel("Invalid roster");
		nextTurnLabels[2].setBounds(700,30,150,20);
		nextTurnLabels[2].setVisible(false);
		navigationBar.getStandingsView().add(nextTurnLabels[2]);
		
		JButton btn4 = new JButton("Next turn");
		btn4.addActionListener(new NavigationBarListener(game,this,nextTurnLabels));
		btn4.setBounds(680,50,150,40);
		navigationBar.getStatisticsView().getRosterPanel().add(btn4);
		nextTurnLabels[3] = new JLabel("Invalid roster");
		nextTurnLabels[3].setBounds(700,30,150,20);
		nextTurnLabels[3].setVisible(false);
		navigationBar.getStatisticsView().getRosterPanel().add(nextTurnLabels[3]);
		
		JButton btn5 = new JButton("Next turn");
		btn5.addActionListener(new NavigationBarListener(game,this,nextTurnLabels));
		btn5.setBounds(680,50,150,40);
		navigationBar.getStatisticsView().getPlayerPanel().add(btn5);
		nextTurnLabels[4] = new JLabel("Invalid roster");
		nextTurnLabels[4].setBounds(700,30,150,20);
		nextTurnLabels[4].setVisible(false);
		navigationBar.getStatisticsView().getPlayerPanel().add(nextTurnLabels[4]);
		
		for(int i=0; i<9; i++) {
			JButton btn = new JButton("Next turn");
			btn.addActionListener(new NavigationBarListener(game,this,nextTurnLabels));
			btn.setBounds(680,50,150,40);
			navigationBar.getScheduleView().getPanels()[i].add(btn);
			nextTurnLabels[5+i] = new JLabel("Invalid roster");
			nextTurnLabels[5+i].setBounds(700,30,150,20);
			nextTurnLabels[5+i].setVisible(false);
			navigationBar.getScheduleView().getPanels()[i].add(nextTurnLabels[5+i]);
		}
	}
	
	public void setEndPanel() {
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(new EndPanel(game));
		getContentPane().revalidate();
	}
	
	public void nextPanel() {
		switch (getActivePanel()){
			case START_PANEL:
				setActivePanel(ActivePanel.MAKE_ROSTER_PANEL);
				setMakeRosterPanel();
				break;
			case MAKE_ROSTER_PANEL:
				game.nextTurn();
				if(game.getActiveRound()>0) {
					setActivePanel(ActivePanel.NAVIGATION_BAR);
					setNavigationBar();
				} else {
					setMakeRosterPanel();
				}
				break;
			case NAVIGATION_BAR:
				game.nextTurn();
				if(game.getActiveRound()>=10) {
					setActivePanel(ActivePanel.END_GAME);
					setEndPanel();
				} else {
					setNavigationBar();
				}
				break;
			case END_GAME:
				break;
		}
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public ActivePanel getActivePanel() {
		return activePanel;
	}

	public void setActivePanel(ActivePanel activePanel) {
		this.activePanel = activePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			nextPanel();
		}
	}
	
	public static class MakeRosterPanelListener implements ActionListener {
		
		private Game game;
		private MakeRosterPanel panel;
		private MainFrame frame;
		
		public MakeRosterPanelListener(Game game, MakeRosterPanel panel, MainFrame frame) {
			this.game = game;
			this.panel = panel;
			this.frame = frame;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(panel.getRoster().isLegal()) {
				panel.updateUserName();
				panel.updateRosterName();
				panel.setActiveUser();
				frame.nextPanel();
				panel = null;
			}
		}
	}
	
	public static class NavigationBarListener implements ActionListener {
		
		private Game game;
		private User currentUser;
		private MainFrame frame;
		private JLabel[] labels;
		
		public NavigationBarListener(Game game, MainFrame frame, JLabel[] labels) {
			this.game = game;
			this.currentUser = game.getUsers().get(game.getActiveUser());
			this.frame = frame;
			this.labels = labels;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(currentUser.getRoster().onFieldIsLegal()) {
				frame.nextPanel();
			} else {
				for(JLabel label : labels) {
					label.setVisible(true);
				}
			}
		}
	}
}
