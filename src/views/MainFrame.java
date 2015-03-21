package views;

import models.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
	
	public enum ActivePanel {
		START_PANEL,MAKE_ROSTER_PANEL,NAVIGATION_BAR,END_GAME;
	}
	
	private ActivePanel activePanel = ActivePanel.START_PANEL;
	private Game game;

	private JPanel contentPane;
	private StartPanel startPanel;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		startPanel = new StartPanel(this);
		setPanel(startPanel.createStartPanel());
	}
	
	public void setPanel(JPanel contentPane) {
		this.contentPane = contentPane;
		setContentPane(contentPane);
	}
	
	public void nextPanel() {
		switch (getActivePanel()){
			case START_PANEL:
				setActivePanel(ActivePanel.MAKE_ROSTER_PANEL);
			case MAKE_ROSTER_PANEL:
				setActivePanel(ActivePanel.NAVIGATION_BAR);
			case NAVIGATION_BAR:
				setActivePanel(ActivePanel.END_GAME);
			case END_GAME:
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
