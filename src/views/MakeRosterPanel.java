package views;

import java.awt.*;
import javax.swing.*;
import models.*;


public class MakeRosterPanel extends JPanel {
	
	private String user;
	private String rosterName;
	private Roster finalRoster;
	
	/**
	 * Create the panel.
	 */
	public MakeRosterPanel() {
		setLayout(null);
		JButton nextButton = new JButton("next user");
		JTextField userName = new JTextField("nafn notanda");
		JTextField rstrName = new JTextField("nafn liðs");
		Box nameBox = Box.createVerticalBox();
		nameBox.setBounds(50, 50, 150, 60);
		add(nameBox);
		nameBox.add(userName);
		nameBox.add(rstrName);
		
		Box rosterBox = Box.createHorizontalBox();
		rosterBox.setBounds(50,225,500,500);
		add(rosterBox);
		
		//testdót
		MockTeam team1 = new MockTeam("Liverpool");
		for(int i=0; i<20; i++) {
			team1.addPlayer(new MockPlayer("LiverpoolPlayer" + i, "Liverpool", Roster.positions[i%4], 100*(i%6 + 1)));
		}
		team1.addPlayer(new MockPlayer("Andy Carroll", "Liverpool", PlayerPosition.FORWARD, 50000000));
		
		
		
		
		JList roster = new JList();
		JList players = new JList();
		
		
		
	}
	
	public static class MyCellRenderer extends JPanel implements ListCellRenderer{
		JLabel left, right;
	
		MyCellRenderer() {
			setLayout(new GridLayout(1, 2));
			left = new JLabel();
			right = new JLabel();
			left.setOpaque(true);
			right.setOpaque(true);
			add(left);
			add(right);
		}
		
		public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus){ 
			String leftData = (Player)value.getName();
			String rightData = ((Player)value).getPrice();
			left.setText(leftData);
			right.setText(rightData);
			if(isSelected){
				left.setBackground(list.getSelectionBackground());
				left.setForeground(list.getSelectionForeground());
				right.setBackground(list.getSelectionBackground());
				right.setForeground(list.getSelectionForeground());
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
	
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		JPanel panel = new MakeRosterPanel();
		frame.add(panel);
		frame.setVisible(true);
		frame.setContentPane(panel);
		
	}
}
	

