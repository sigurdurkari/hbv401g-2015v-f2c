package views;

import models.*;
import static tests.BasicEntities.*;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import tests.BasicEntities;

public class StartPanel extends JPanel implements ActionListener {
	
	private Integer userCount = 2;
	private MainFrame mainFrame;
	
	public StartPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	
		setLayout(null);
		
		JLabel lblFantasyFootball = new JLabel("Fantasy Football", JLabel.CENTER);
		lblFantasyFootball.setBounds(350, 200, 200, 15);
		lblFantasyFootball.setAlignmentX(CENTER_ALIGNMENT);
		add(lblFantasyFootball);
		
		String[] possibleUserCount= {"2","3","4","5","6"};
		JComboBox selectUserCount = new JComboBox(possibleUserCount);
		selectUserCount.setBounds(425, 250, 50, 20);
		selectUserCount.setAlignmentX(CENTER_ALIGNMENT);
		selectUserCount.addActionListener(this);
		add(selectUserCount);
		
		JButton btnStart = new JButton("Start Game");
		btnStart.setBounds(375, 400, 150, 50);
		btnStart.addActionListener(this);
		add(btnStart);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JComboBox) {
			JComboBox cb = (JComboBox)e.getSource();
			String userCountString = (String)cb.getSelectedItem();
			setUserCount(Integer.parseInt(userCountString));
		} else if(e.getSource() instanceof JButton) {
			startGame();
			mainFrame.nextPanel();
		}
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}
	
	public void startGame() {
		List<MockTeam> teams = generateTeams();
		List<User> users = new ArrayList<>();
		for(int i=0; i<userCount; i++) {
			User u = new User("", new Integer(0), Game.STARTING_CASH, new Roster());
			users.add(u);
		}
		mainFrame.setGame(new Game(users, teams));
	}

}
