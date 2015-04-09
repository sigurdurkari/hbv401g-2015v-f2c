package views;

import models.*;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import tests.BasicEntities;
import views.MakeRosterPanel.PlayerCellRender;

public class MarketView extends JPanel implements ActionListener {
	
	private Game game;
	private User currentUser;
	private List<MockPlayer> playersList = new ArrayList<>();
	private DefaultListModel<MockPlayer> inModel = new DefaultListModel<>();
	private JList<MockPlayer> inList = new JList<MockPlayer>(inModel);
	private DefaultListModel<MockPlayer> outModel = new DefaultListModel<>();
	private JList<MockPlayer> outList = new JList<MockPlayer>(outModel);
	private JList<MockPlayer> roster = new JList<MockPlayer>();
	private JList<MockPlayer> players = new JList<MockPlayer>();
	private JLabel currentFinancialStatus = new JLabel();
	private int netCost = 0;
	private JLabel netCostLabel = new JLabel();
	private JLabel errorLabel = new JLabel();
	
	public MarketView(Game game) {
		this.game = game;
		this.currentUser = game.getUsers().get(game.getActiveUser());
		setLayout(null);
		
		JButton buyBtn = new JButton("Set to buy");
		buyBtn.addActionListener(this);
		JButton unBuyBtn = new JButton("Deselect from buying");
		unBuyBtn.addActionListener(this);
		JButton sellBtn = new JButton("Set to sell");
		sellBtn.addActionListener(this);
		JButton unSellBtn = new JButton("Deselect from selling");
		unSellBtn.addActionListener(this);
		JLabel userName = new JLabel(currentUser.getUserName());
		JLabel rstrName = new JLabel(currentUser.getRoster().getName());
		Box nameBox = Box.createVerticalBox();
		nameBox.setBounds(50, 50, 150, 60);
		add(nameBox);
		nameBox.add(userName);
		nameBox.add(rstrName);
		
		Box financeStatusBox = Box.createVerticalBox();
		financeStatusBox.setBounds(350, 50, 250, 60);
		add(financeStatusBox);
		
		JLabel financeLbl = new JLabel("Financial Status: " + currentUser.getFinancialStatus());
		financeStatusBox.add(financeLbl);
		netCostLabel.setText("Net cost of purchase: " + netCost);
		financeStatusBox.add(netCostLabel);
		
		Box rosterBox = Box.createHorizontalBox();
		rosterBox.setBounds(50,120,800,400);
		add(rosterBox);
		
		
		Box rosterBoxL = Box.createVerticalBox();
		Box rosterBoxR = Box.createVerticalBox();
		
		
		rosterBox.add(rosterBoxL);
		rosterBox.add(rosterBoxR);
		
		
		for(MockTeam team : game.getTeams()) {
			playersList.addAll(team.getPlayers());
		}
		Collections.sort(playersList, new Comparator<MockPlayer>() {
			@Override
			public int compare(MockPlayer lhs, MockPlayer rhs) {
				if(lhs.getPosition().compareTo(rhs.getPosition()) == 0 && lhs.getTotalScore().compareTo(rhs.getTotalScore()) == 0) return lhs.getName().compareTo(rhs.getName());
				if(lhs.getPosition().compareTo(rhs.getPosition()) == 0) return lhs.getTotalScore().compareTo(rhs.getTotalScore());
				return lhs.getPosition().compareTo(rhs.getPosition());
			}
		});
		
		roster = new JList<MockPlayer>(currentUser.getRoster().getPlayers().toArray(new MockPlayer[currentUser.getRoster().getPlayers().size()]));
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
		
		JScrollPane outScroll = new JScrollPane();
		JScrollPane inScroll = new JScrollPane();
		
		outScroll.getViewport().add(outList);
		inScroll.getViewport().add(inList);
		
		outList.setCellRenderer(new PlayerCellRender());
		outList.setVisibleRowCount(3);
		inList.setCellRenderer(new PlayerCellRender());
		inList.setVisibleRowCount(3);
		
		outList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		inList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		Box sellBtnBox = Box.createHorizontalBox();
		sellBtnBox.add(sellBtn);
		sellBtnBox.add(unSellBtn);
		Box buyBtnBox = Box.createHorizontalBox();
		buyBtnBox.add(buyBtn);
		buyBtnBox.add(unBuyBtn);
		
		rosterBoxL.add(rosterScroll);
		rosterBoxL.add(sellBtnBox);
		sellBtnBox.setAlignmentX(CENTER_ALIGNMENT);
		rosterBoxL.add(outScroll);
		rosterBoxR.add(playersScroll);
		rosterBoxR.add(buyBtnBox);
		buyBtnBox.setAlignmentX(CENTER_ALIGNMENT);
		rosterBoxR.add(inScroll);
		
		Box purchaseBtnBox = Box.createHorizontalBox();
		purchaseBtnBox.setBounds(700, 540, 150, 50);
		add(purchaseBtnBox);
		
		JButton purchaseBtn = new JButton("Make purchase");
		purchaseBtn.addActionListener(this);
		purchaseBtnBox.add(purchaseBtn);
		
		Box errorLabelBox = Box.createHorizontalBox();
		errorLabelBox.setBounds(500,540,150,50);
		add(errorLabelBox);
		errorLabel.setText("Illegal purchase!");
		errorLabel.setVisible(false);
		errorLabelBox.add(errorLabel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton btn = (JButton)e.getSource();
			if(btn.getText().equals("Set to sell")) {
				if(roster.getSelectedValue() instanceof MockPlayer && !outModel.contains(roster.getSelectedValue())) {
					netCost -= roster.getSelectedValue().getPrice();
					outModel.addElement(roster.getSelectedValue());
					netCostLabel.setText("Net cost of purchase: " + netCost);
				}
			} else if(btn.getText().equals("Set to buy")) {
				if(players.getSelectedValue() instanceof MockPlayer && !inModel.contains(players.getSelectedValue())) {
					netCost += players.getSelectedValue().getPrice();
					inModel.addElement(players.getSelectedValue());
					netCostLabel.setText("Net cost of purchase: " + netCost);
				}
			} else if(btn.getText().equals("Deselect from selling")) {
				if(outList.getSelectedValue() instanceof MockPlayer) {
					netCost += outList.getSelectedValue().getPrice();
					outModel.removeElement(outList.getSelectedValue());
					netCostLabel.setText("Net cost of purchase: " + netCost);
				}
			} else if(btn.getText().equals("Deselect from buying")) {
				if(inList.getSelectedValue() instanceof MockPlayer) {
					netCost -= inList.getSelectedValue().getPrice();
					inModel.removeElement(inList.getSelectedValue());
					netCostLabel.setText("Net cost of purchase: " + netCost);
				}
			} else if(btn.getText().equals("Make purchase")) {
				if(!User.isBuyLegal(currentUser, new ArrayList<MockPlayer>(Collections.list(inModel.elements())), new ArrayList<MockPlayer>(Collections.list(outModel.elements())))) {
					errorLabel.setVisible(true);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Game game = BasicEntities.generateGame();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setSize(900,700);
		JPanel panel = new MarketView(game);
		frame.add(panel);
		frame.setVisible(true);
		frame.setContentPane(panel);
	}

}
