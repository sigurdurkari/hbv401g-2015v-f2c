package views;

import models.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
	
	public enum ActivePanel {
		START_PANEL,MAKE_ROSTER_PANEL,NAVIGATION_BAR,END_GAME;
	}
	
	private ActivePanel activePanel = ActivePanel.START_PANEL;
	private Game game;
	private StartPanel startPanel;
	private MakeRosterPanel makeRosterPanel;

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
		setPanel(makeRosterPanel);*/
		remove(startPanel);
		add(new MakeRosterPanel());
	}
	
	public void setNavigationBar() {
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(new NavigationBar(game));
		getContentPane().revalidate();
	}
	
	public void nextPanel() {
		switch (getActivePanel()){
			case START_PANEL:
				setActivePanel(ActivePanel.MAKE_ROSTER_PANEL);
				setMakeRosterPanel();
				break;
			case MAKE_ROSTER_PANEL:
				game.setActiveUser(makeRosterPanel.getUser());
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
				if(game.getActiveRound()>0) {
					setActivePanel(ActivePanel.END_GAME);
					setPanel(new EndPanel(game));
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

	
}
