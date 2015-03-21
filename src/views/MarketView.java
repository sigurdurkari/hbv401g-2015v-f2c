package views;

import models.*;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MarketView {
	
	private Game game;
	private MainFrame mainFrame;
	private List<MockPlayer> in = new ArrayList<>();
	private List<MockPlayer> out = new ArrayList<>();
	private JButton purchaseButton = new JButton("Make purchase");
	
	public MarketView(Game game, MainFrame mainFrame) {
		this.game = game;
		this.mainFrame = mainFrame;
	}
	
	public JPanel createMarketView() {
		JPanel marketView = new JPanel();
		marketView.setLayout(new BoxLayout(marketView, BoxLayout.X_AXIS));
		
		Box rosterBox = Box.createVerticalBox();
		marketView.add(rosterBox);
		Box playerBox = Box.createVerticalBox();
		marketView.add(playerBox);
		/*
		mainFrame.add(new JScrollPane(
			playerBox,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
			)
		);
		*/
		for(final MockPlayer p : game.getUsers().get(game.getActiveUser()).getRoster().getPlayers()) {
			Box pBox = Box.createHorizontalBox();
			pBox.add(new JLabel(p.getName()));
			JButton btn = new JButton("Sell");
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(out.contains(p)) {
						out.add(p);
					} else {
						out.remove(p);
					}
					enablePurchaseButton(purchaseButton);
				}
			});
			pBox.add(btn);
			rosterBox.add(pBox);
		}
		
		purchaseButton.setEnabled(false);
		rosterBox.add(purchaseButton);
		
		List<MockPlayer> goalkeepers = new ArrayList<>();
		List<MockPlayer> defenders = new ArrayList<>();
		List<MockPlayer> midfielders = new ArrayList<>();
		List<MockPlayer> forwards = new ArrayList<>();
		for(MockTeam team : game.getTeams()) {
			goalkeepers.addAll(team.getPlayersByPosition(PlayerPosition.GOAL));
			defenders.addAll(team.getPlayersByPosition(PlayerPosition.DEFENCE));
			midfielders.addAll(team.getPlayersByPosition(PlayerPosition.MIDFIELD));
			forwards.addAll(team.getPlayersByPosition(PlayerPosition.FORWARD));
		}
		
		playerBox.add(new JLabel("Goalkeepers"));
		Box keeperBox = Box.createVerticalBox();
		for(final MockPlayer p : goalkeepers) {
			Box pBox = Box.createHorizontalBox();
			pBox.add(new JLabel(p.getName()));
			JButton btn = new JButton("Buy");
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(in.contains(p)) {
						in.add(p);
					} else {
						in.remove(p);
					}
					enablePurchaseButton(purchaseButton);
				}
			});
			pBox.add(btn);
			keeperBox.add(pBox);
		}
		playerBox.add(keeperBox);
		
		playerBox.add(new JLabel("Defenders"));
		Box defenderBox = Box.createVerticalBox();
		for(final MockPlayer p : defenders) {
			Box pBox = Box.createHorizontalBox();
			pBox.add(new JLabel(p.getName()));
			JButton btn = new JButton("Buy");
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(in.contains(p)) {
						in.add(p);
					} else {
						in.remove(p);
					}
					enablePurchaseButton(purchaseButton);
				}
			});
			pBox.add(btn);
			defenderBox.add(pBox);
		}
		playerBox.add(defenderBox);
		
		playerBox.add(new JLabel("Midfielders"));
		Box midfieldBox = Box.createVerticalBox();
		for(final MockPlayer p : midfielders) {
			Box pBox = Box.createHorizontalBox();
			pBox.add(new JLabel(p.getName()));
			JButton btn = new JButton("Buy");
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(in.contains(p)) {
						in.add(p);
					} else {
						in.remove(p);
					}
					enablePurchaseButton(purchaseButton);
				}
			});
			pBox.add(btn);
			midfieldBox.add(pBox);
		}
		playerBox.add(midfieldBox);
		
		playerBox.add(new JLabel("Forwards"));
		Box forwardBox = Box.createVerticalBox();
		for(final MockPlayer p : forwards) {
			Box pBox = Box.createHorizontalBox();
			pBox.add(new JLabel(p.getName()));
			JButton btn = new JButton("Buy");
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(in.contains(p)) {
						in.add(p);
					} else {
						in.remove(p);
					}
					enablePurchaseButton(purchaseButton);
				}
			});
			pBox.add(btn);
			forwardBox.add(pBox);
		}
		playerBox.add(forwardBox);
		
		return marketView;
	}
	
	public void enablePurchaseButton(JButton purchaseButton) {
		if(User.isBuyLegal(game.getUsers().get(game.getActiveUser()),in,out)) {
			purchaseButton.setEnabled(true);
		} else {
			purchaseButton.setEnabled(false);
		}
	}

}
