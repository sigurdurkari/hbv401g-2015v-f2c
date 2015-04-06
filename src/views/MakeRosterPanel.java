package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import models.*;


public class MakeRosterPanel extends JPanel implements ActionListener {
	
	private String user;
	private String rosterName;
	private List<MockPlayer> playersList = new ArrayList<>();
	private DefaultListModel<MockPlayer> rosterModel = new DefaultListModel<>();
	private JList<MockPlayer> roster = new JList<MockPlayer>(rosterModel);
	private JList<MockPlayer> players = new JList<MockPlayer>();
	

	public MakeRosterPanel() {
		setLayout(null);
		JButton selectBtn = new JButton("Select player");
		selectBtn.addActionListener(this);
		JButton deselectBtn = new JButton("Deselect player");
		deselectBtn.addActionListener(this);
		JTextField userName = new JTextField("nafn notanda");
		JTextField rstrName = new JTextField("nafn liðs");
		Box nameBox = Box.createVerticalBox();
		nameBox.setBounds(50, 50, 150, 60);
		add(nameBox);
		nameBox.add(userName);
		nameBox.add(rstrName);
		
		Box rosterBox = Box.createHorizontalBox();
		rosterBox.setBounds(50,150,550,300);
		add(rosterBox);
		
		
		Box rosterBoxL = Box.createVerticalBox();
		Box rosterBoxR = Box.createVerticalBox();
		
		
		rosterBox.add(rosterBoxL);
		rosterBox.add(rosterBoxR);

		//test stuff
		MockTeam team1 = new MockTeam("Liverpool");
		for(int i=0; i<20; i++) {
			team1.addPlayer(new MockPlayer("LiverpoolPlayer" + i, "Liverpool", Roster.positions[i%4], 100*(i%6 + 1)));
		}
		MockTeam team2 = new MockTeam("Manchester United");
		for(int i=0; i<20; i++) {
			team2.addPlayer(new MockPlayer("UnitedPlayer" + i, "Manchester United", Roster.positions[(i+1)%4], 100*(i%7 + 1)));
		}

		playersList = team1.getPlayers();
		
		players = new JList<MockPlayer>(playersList.toArray(new MockPlayer[playersList.size()]));
		
		JScrollPane rosterScroll = new JScrollPane();
		JScrollPane playersScroll = new JScrollPane();
		
		rosterScroll.getViewport().add(roster);
		playersScroll.getViewport().add(players);
		playersScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		
		players.setCellRenderer(new PlayerCellRender());
		players.setVisibleRowCount(15);
		roster.setCellRenderer(new PlayerCellRender());
		roster.setVisibleRowCount(15);
		
		players.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		roster.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		

		rosterBoxL.add(rosterScroll);
		rosterBoxL.add(deselectBtn);
		deselectBtn.setAlignmentX(CENTER_ALIGNMENT);
		rosterBoxR.add(playersScroll);
		rosterBoxR.add(selectBtn);
		selectBtn.setAlignmentX(CENTER_ALIGNMENT);
		
		
	}
	
	public String getUserName(){
		return user;
	}
	
	public String getRosterName(){
		return rosterName;
	}
	
	public List<MockPlayer> getRoster(){
		List<MockPlayer> list = new ArrayList<>();
		for(int i=0;i<rosterModel.getSize();i++ ){
			list.add(rosterModel.getElementAt(i));
		}
		return list;
	}
	
	public void setUserName(String name){
		user=name;
	}
	
	public void setRosterName(String name){
		rosterName=name;
	}
	
	
	public static class PlayerCellRender extends JPanel implements ListCellRenderer{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JLabel left, right;
	
		public PlayerCellRender() {
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton btn = (JButton)e.getSource();
			if(btn.getText().equals("Select player")) {
				rosterModel.addElement(players.getSelectedValue());
			} else {
				rosterModel.removeElement(roster.getSelectedValue());
			}
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
	

