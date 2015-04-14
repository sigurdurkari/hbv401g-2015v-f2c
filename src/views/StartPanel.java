package views;

import models.*;
import static tests.BasicEntities.*;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StartPanel implements ActionListener {
	
	private Integer userCount = 2;
	private MainFrame mainFrame;
	
	public StartPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public JPanel createStartPanel() {
		JPanel startPanel = new JPanel();
		startPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		startPanel.setLayout(null);
		
		JLabel lblFantasyFootball = new JLabel("Fantasy Football", JLabel.CENTER);
		lblFantasyFootball.setBounds(125, 70, 200, 15);
		startPanel.add(lblFantasyFootball);
		
		String[] possibleUserCount= {"2","3","4","5","6"};
		JComboBox selectUserCount = new JComboBox(possibleUserCount);
		selectUserCount.setBounds(200, 130, 50, 20);
		selectUserCount.setSize(70,40);
		selectUserCount.addActionListener(this);
		startPanel.add(selectUserCount);
		
		JButton btnStart = new JButton("Start Game");
		btnStart.setBounds(165, 170, 120, 40);
		btnStart.addActionListener(this);
		startPanel.add(btnStart);
		
		return startPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JComboBox) {
			JComboBox cb = (JComboBox)e.getSource();
			String userCountString = (String)cb.getSelectedItem();
			setUserCount(Integer.parseInt(userCountString));
		} else if(e.getSource() instanceof JButton) {
			mainFrame.setGame(startGame());
			mainFrame.nextPanel();
		}
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}
	
	public Game startGame() {
		List<MockTeam> teams = generateTeams();
		List<User> users = new ArrayList<>();
		for(int i=0; i<userCount; i++) {
			User u = new User("", new Integer(0), Game.STARTING_CASH, new Roster());
			users.add(u);
		}
		return new Game(users, teams);
	}

}
