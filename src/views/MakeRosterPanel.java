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
		rosterBox.setBounds(50,100,500,500);
		add(rosterBox);
		
		//test stuff
		MockPlayer[] playerArray= new MockPlayer[20];
		for(int i=0; i<20; i++) {
			playerArray[i]=new MockPlayer("LiverpoolPlayer" + i, "Liverpool", Roster.positions[i%4], 100*(i%6 + 1));
		}
		MockTeam team2 = new MockTeam("Manchester United");
		for(int i=0; i<20; i++) {
			team2.addPlayer(new MockPlayer("UnitedPlayer" + i, "Manchester United", Roster.positions[(i+1)%4], 100*(i%7 + 1)));
		}
		
		//MockPlayer[] plrs = team2.getPlayers().toArray(); 

		JList<MockPlayer> roster = new JList<MockPlayer>(playerArray);
		JList<MockPlayer> players = new JList<MockPlayer>(playerArray);
		
		players.setCellRenderer(new MyCellRenderer());
		roster.setCellRenderer(new MyCellRenderer());
		
		rosterBox.add(roster);
		rosterBox.add(players);
		
		
		
	}
	
	public static class MyCellRenderer extends JPanel implements ListCellRenderer{
		JLabel left, right;
	
		MyCellRenderer() {
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
			String leftData = ((MockPlayer)value).getName();
			String rightData = ((MockPlayer)value).getPrice().toString();
			left.setText(leftData);
			right.setText(rightData);
			right.setHorizontalTextPosition(JLabel.RIGHT);
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
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setSize(800,800);
		JPanel panel = new MakeRosterPanel();
		frame.add(panel);
		frame.setVisible(true);
		frame.setContentPane(panel);
		
	}
}
	

