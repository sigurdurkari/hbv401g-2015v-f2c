package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

import models.*;

public class StandingsView extends JPanel{
	
	private Game game;
	private JList<User> userList;
	private JList<MockTeam> teamList;
	
	public StandingsView(Game game){
		setLayout(null);
		this.game=game;
		
		Box listBox = Box.createHorizontalBox();
		listBox.setBounds(50,150,700,300);
		
		Collections.sort(game.getUsers());
		Collections.sort(game.getTeams());
		userList = new JList<User>(game.getUsers().toArray(new User[game.getUsers().size()]));
		userList.setCellRenderer(new UserCellRender());
		//userList.setBounds(150,150,400,400);
		userList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		teamList = new JList<MockTeam>(game.getTeams().toArray(new MockTeam[game.getTeams().size()]));
		teamList.setCellRenderer(new TeamCellRender());
		teamList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		listBox.add(userList);
		listBox.add(teamList);
		
		add(listBox);
	}
	
	
	
	
	
	public static class UserCellRender extends JPanel implements ListCellRenderer{
		/**
		 * CELL RENDERER FOR USERS
		 */
		private static final long serialVersionUID = 1L;
		JLabel left, right;
	
		public UserCellRender() {
			GridLayout layout = new GridLayout(1, 2);
			layout.setHgap(10);
			setLayout(layout);
			left = new JLabel();
			right = new JLabel();
			left.setOpaque(true);
			right.setOpaque(true);
			add(left);
			add(right);
		}
		
		public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus){ 
			String leftData = ((User)value).getRoster().getName();
			String rightData = ((User)value).getUserScore().toString();
			left.setText(leftData);
			right.setText(rightData);
			right.setHorizontalTextPosition(JLabel.RIGHT);
			if(isSelected){
				left.setBackground(list.getBackground());
				left.setForeground(list.getForeground());
				right.setBackground(list.getBackground());
				right.setForeground(list.getForeground());
			} else {
				left.setBackground(list.getBackground());
				left.setForeground(list.getForeground());
				right.setBackground(list.getBackground());
				right.setForeground(list.getForeground());
			}
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			return this;
		}
	}
	
	public static class TeamCellRender extends JPanel implements ListCellRenderer{
		/**
		 * CELL RENDERER FOR TEAMS
		 */
		private static final long serialVersionUID = 1L;
		JLabel left, right;
	
		public TeamCellRender() {
			GridLayout layout = new GridLayout(1, 2);
			layout.setHgap(10);
			setLayout(layout);
			left = new JLabel();
			right = new JLabel();
			left.setOpaque(true);
			right.setOpaque(true);
			add(left);
			add(right);
		}
		
		public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus){ 
			String leftData = ((MockTeam)value).getName();
			String rightData = ((MockTeam)value).getScore().toString();
			left.setText(leftData);
			right.setText(rightData);
			right.setHorizontalTextPosition(JLabel.RIGHT);
			if(isSelected){
				left.setBackground(list.getBackground());
				left.setForeground(list.getForeground());
				right.setBackground(list.getBackground());
				right.setForeground(list.getForeground());
			} else {
				left.setBackground(list.getBackground());
				left.setForeground(list.getForeground());
				right.setBackground(list.getBackground());
				right.setForeground(list.getForeground());
			}
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			return this;
		}
	}
	
}