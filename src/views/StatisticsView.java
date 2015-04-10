package views;

import javax.swing.*;

import tests.BasicEntities;

import java.awt.*;

import models.*;

public class StatisticsView extends JPanel {

	private Game game;
	private User currentUser;
	private UserStats userStats;
	private JList<UserStats.PlayerStats> playerStatsList = new JList<>();
	
	public StatisticsView(Game game) {
		this.game = game;
		this.currentUser = game.getUsers().get(game.getActiveUser());
		this.userStats = currentUser.getUserStats();
		setLayout(null);
		
		JLabel userName = new JLabel(currentUser.getUserName());
		JLabel rstrName = new JLabel(currentUser.getRoster().getName());
		Box nameBox = Box.createVerticalBox();
		nameBox.setBounds(50, 50, 150, 60);
		add(nameBox);
		nameBox.add(userName);
		nameBox.add(rstrName);
		
		Box rosterBox = Box.createVerticalBox();
		rosterBox.setBounds(50,120,800,400);
		add(rosterBox);
		
		playerStatsList = new JList<UserStats.PlayerStats>(userStats.getPlayerStats().toArray(new UserStats.PlayerStats[userStats.getPlayerStats().size()]));
		
		JScrollPane rosterScroll = new JScrollPane();
		rosterScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		rosterScroll.getViewport().add(playerStatsList);
		playerStatsList.setCellRenderer(new StatsCellRender());
		playerStatsList.setVisibleRowCount(20);
		playerStatsList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		UserStats.PlayerStats[] columns = new UserStats.PlayerStats[1];
		columns[0] = new UserStats.PlayerStats(new MockPlayer("Player"));
		for(int i=1; i<=10; i++) {
			columns[0].setWeekStats(i,"Round " + i);
		}
		columns[0].setTotalScore("Total score");
		JList<UserStats.PlayerStats> columnList = new JList<UserStats.PlayerStats>(columns);
		
		JScrollPane columnScroll = new JScrollPane();
		columnScroll.getViewport().add(columnList);
		columnList.setCellRenderer(new StatsCellRender());
		columnList.setVisibleRowCount(1);
		columnList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		UserStats.PlayerStats[] totalScore = new UserStats.PlayerStats[1];
		totalScore[0] = new UserStats.PlayerStats(new MockPlayer("Total per round"));
		for(int i=1; i<=10; i++) {
			totalScore[0].setWeekStats(i,"" + userStats.getScoreByRound()[i-1]);
		}
		totalScore[0].setTotalScore("" + userStats.getTotalScore());
		
		JList<UserStats.PlayerStats> totalList = new JList<UserStats.PlayerStats>(totalScore);
		
		JScrollPane totalScroll = new JScrollPane();
		totalScroll.getViewport().add(totalList);
		totalList.setCellRenderer(new StatsCellRender());
		totalList.setVisibleRowCount(1);
		totalList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		rosterBox.add(columnScroll);
		rosterBox.add(rosterScroll);
		rosterBox.add(totalScroll);
	}
	
	public static class StatsCellRender extends JPanel implements ListCellRenderer{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JLabel[] labels = new JLabel[12];
	
		public StatsCellRender() {
			GridLayout layout = new GridLayout(1, 12);
			layout.setHgap(10);
			setLayout(layout);
			for(int i=0; i<12; i++) {
				labels[i] = new JLabel();
				labels[i].setOpaque(true);
				add(labels[i]);
			}
		}
		
		public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus){ 
			String playerName = ((UserStats.PlayerStats)value).getPlayer().getName();
			labels[0].setText(playerName);
			for(int i=1; i<=10; i++) {
				String stat = ((UserStats.PlayerStats)value).getStats()[i-1];
				labels[i].setText(stat);
			}
			String totalScore = ((UserStats.PlayerStats)value).getTotalScoreString();
			labels[11].setText(totalScore);
			for(JLabel label : labels) {
				label.setBackground(list.getBackground());
				label.setForeground(list.getForeground());
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
		JPanel panel = new StatisticsView(game);
		frame.add(panel);
		frame.setVisible(true);
		frame.setContentPane(panel);
	}
}
