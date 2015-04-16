package views;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

import tests.BasicEntities;
import models.*;

public class ScheduleView extends JTabbedPane {

	private Game game;
	private User currentUser;
	private Schedule schedule;
	private JPanel[] panels = new JPanel[9];
	
	public ScheduleView(Game game) {
		this.game = game;
		this.currentUser = game.getUsers().get(game.getActiveUser());
		this.schedule = game.getSchedule();
		
		for(int i=0; i<9; i++) {
			JPanel panel = new JPanel();
			addTab("Round " + (i+1), panel);
			panel.setLayout(null);
			panels[i] = panel;
			
			JLabel userName = new JLabel(currentUser.getUserName());
			JLabel rstrName = new JLabel(currentUser.getRoster().getName());
			Box nameBox = Box.createVerticalBox();
			nameBox.setBounds(50, 50, 150, 60);
			panel.add(nameBox);
			nameBox.add(userName);
			nameBox.add(rstrName);
			
			Box matchBox = Box.createVerticalBox();
			panel.add(matchBox);
			matchBox.setBounds(100,150,700,400);
			
			List<ScheduledMatch> matches = schedule.getMatchesByWeek(i+1);
			JList<ScheduledMatch> matchList = new JList<ScheduledMatch>(matches.toArray(new ScheduledMatch[matches.size()]));
			matchList.setCellRenderer(new MatchCellRender());
			matchList.setVisibleRowCount(10);
			matchList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			matchBox.add(matchList);
			
		}
		
		setSelectedIndex(game.getActiveRound()<0? 0 : game.getActiveRound()-1);
	}
	
	public JPanel[] getPanels() {
		return panels;
	}
	
	public static class MatchCellRender extends JPanel implements ListCellRenderer{
		/**
		 * CELL RENDERER FOR TEAMS
		 */
		private static final long serialVersionUID = 1L;
		JLabel left, middle, right;
	
		public MatchCellRender() {
			GridLayout layout = new GridLayout(1, 3);
			layout.setHgap(10);
			setLayout(layout);
			left = new JLabel();
			middle = new JLabel();
			right = new JLabel();
			left.setOpaque(true);
			middle.setOpaque(true);
			right.setOpaque(true);
			add(left);
			add(middle);
			add(right);
		}
		
		public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus){ 
			String leftData = ((ScheduledMatch)value).getHome().getName();
			String middleData = ((ScheduledMatch)value).getHomeGoals() == null ? "" : ((ScheduledMatch)value).getHomeGoals() + " - " + ((ScheduledMatch)value).getAwayGoals();
			String rightData = ((ScheduledMatch)value).getAway().getName();
			left.setText(leftData);
			middle.setText(middleData);
			right.setText(rightData);
			right.setHorizontalTextPosition(JLabel.RIGHT);
			if(isSelected){
				left.setBackground(list.getBackground());
				left.setForeground(list.getForeground());
				middle.setBackground(list.getBackground());
				middle.setForeground(list.getForeground());
				right.setBackground(list.getBackground());
				right.setForeground(list.getForeground());
			} else {
				left.setBackground(list.getBackground());
				left.setForeground(list.getForeground());
				middle.setBackground(list.getBackground());
				middle.setForeground(list.getForeground());
				right.setBackground(list.getBackground());
				right.setForeground(list.getForeground());
			}
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			return this;
		}
	}
	
	public static void main(String[] args) {
		Game game = BasicEntities.generateGame();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setSize(900,700);
		JTabbedPane panel = new ScheduleView(game);
		frame.add(panel);
		frame.setVisible(true);
		frame.setContentPane(panel);
	}
}
