package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

import models.*;
import tests.*;
import java.util.*;

public class EndPanel extends JPanel {
	
	private List<User> users = new ArrayList<>();
	private JList<User> userList = new JList<>();
	
	public EndPanel(Game game){
		setLayout(null);
		users = game.getUsers();
		Collections.sort(users);
		JLabel winner = new JLabel("Winner: "+users.get(0).getUserName());
		winner.setBounds(50,50,100,100);
		add(winner);
		
		userList = new JList<User>(users.toArray(new User[users.size()]));
		userList.setCellRenderer(new UserCellRender());
		
		Box resultBox = Box.createVerticalBox();
		resultBox.setBounds(50,150,700,300);
		resultBox.add(userList);
		add(resultBox);
		
	}
	
	public static class UserCellRender extends JPanel implements ListCellRenderer{
		/**
		 * 
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
			String leftData = ((User)value).getUserName();
			String rightData = ((User)value).getUserScore().toString();
			left.setText(leftData);
			right.setText(rightData);
			right.setHorizontalTextPosition(JLabel.RIGHT);
			
			left.setBackground(list.getBackground());
			left.setForeground(list.getForeground());
			right.setBackground(list.getBackground());
			right.setForeground(list.getForeground());
			
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			return this;
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args){
		Game game = BasicEntities.generateGame();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setSize(800,800);
		JPanel panel = new EndPanel(game);
		frame.add(panel);
		frame.setVisible(true);
		frame.setContentPane(panel);
		
	}
}