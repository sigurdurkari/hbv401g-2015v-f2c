package views;

import models.*;
import java.util.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartGameView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartGameView frame = new StartGameView();
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
	public StartGameView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int userCount = 4;
				List<Team> teams = new ArrayList<>();
				List<User> users = new ArrayList<>();
				for(int i=0; i<userCount; i++) {
					User u = new User(new Integer(0), Game.STARTING_CASH, new Roster());
					users.add(u);
				}
				Game game = new Game(users, teams);
			}
		});
		btnStart.setBounds(164, 168, 117, 25);
		contentPane.add(btnStart);
		
		JLabel lblFantasyFootball = new JLabel("Fantasy Football");
		lblFantasyFootball.setBounds(162, 72, 133, 15);
		contentPane.add(lblFantasyFootball);
	}
}
