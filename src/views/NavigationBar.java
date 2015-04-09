package views;

import javax.swing.*;
import java.awt.*;
import views.*;


public class NavigationBar extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	

	public NavigationBar() {
		JPanel MyRosterView = new MakeRosterPanel();
		addTab("My Roster",MyRosterView);
		JPanel MyRosterView2 = new MakeRosterPanel();
		addTab("My Roster no 2",MyRosterView2);
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setSize(900,700);
		JTabbedPane panel = new NavigationBar();
		frame.add(panel);
		frame.setVisible(true);
		frame.setContentPane(panel);
	}

}