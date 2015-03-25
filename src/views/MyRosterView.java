package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyRosterView extends JPanel {

	/**
	 * Create the panel.
	 */
	public MyRosterView() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblOnTheField = new JLabel("On the Field");
		GridBagConstraints gbc_lblOnTheField = new GridBagConstraints();
		gbc_lblOnTheField.insets = new Insets(0, 0, 5, 5);
		gbc_lblOnTheField.gridx = 1;
		gbc_lblOnTheField.gridy = 1;
		add(lblOnTheField, gbc_lblOnTheField);
		
		JLabel lblPosition = new JLabel("Position");
		GridBagConstraints gbc_lblPosition = new GridBagConstraints();
		gbc_lblPosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosition.gridx = 2;
		gbc_lblPosition.gridy = 1;
		add(lblPosition, gbc_lblPosition);
		
		JLabel lblSubstitutes = new JLabel("The Bench");
		GridBagConstraints gbc_lblSubstitutes_2 = new GridBagConstraints();
		gbc_lblSubstitutes_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubstitutes_2.gridx = 7;
		gbc_lblSubstitutes_2.gridy = 1;
		add(lblSubstitutes, gbc_lblSubstitutes_2);
		
		JLabel lblPosition_1 = new JLabel("Position");
		GridBagConstraints gbc_lblPosition_1 = new GridBagConstraints();
		gbc_lblPosition_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosition_1.gridx = 8;
		gbc_lblPosition_1.gridy = 1;
		add(lblPosition_1, gbc_lblPosition_1);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 10;
		gbc_label.gridy = 1;
		add(label, gbc_label);
		
		JLabel lblPlayer1 = new JLabel("Player1");
		GridBagConstraints gbc_lblPlayer1 = new GridBagConstraints();
		gbc_lblPlayer1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer1.gridx = 1;
		gbc_lblPlayer1.gridy = 2;
		add(lblPlayer1, gbc_lblPlayer1);
		
		JLabel lblPos1 = new JLabel("Pos1");
		GridBagConstraints gbc_lblPos1 = new GridBagConstraints();
		gbc_lblPos1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPos1.gridx = 2;
		gbc_lblPos1.gridy = 2;
		add(lblPos1, gbc_lblPos1);
		
		JButton btnBench1 = new JButton("Put on Bench");
		GridBagConstraints gbc_btnBench1 = new GridBagConstraints();
		gbc_btnBench1.insets = new Insets(0, 0, 5, 5);
		gbc_btnBench1.gridx = 3;
		gbc_btnBench1.gridy = 2;
		add(btnBench1, gbc_btnBench1);
		
		JLabel lblSub1 = new JLabel("Sub1");
		GridBagConstraints gbc_lblSub1 = new GridBagConstraints();
		gbc_lblSub1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSub1.gridx = 7;
		gbc_lblSub1.gridy = 2;
		add(lblSub1, gbc_lblSub1);
		
		JLabel lblSubpos1 = new JLabel("SubPos1");
		GridBagConstraints gbc_lblSubpos1 = new GridBagConstraints();
		gbc_lblSubpos1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubpos1.gridx = 8;
		gbc_lblSubpos1.gridy = 2;
		add(lblSubpos1, gbc_lblSubpos1);
		
		JButton btnField1 = new JButton("Put on Field");
		btnField1.setEnabled(false);
		GridBagConstraints gbc_btnField1 = new GridBagConstraints();
		gbc_btnField1.insets = new Insets(0, 0, 5, 5);
		gbc_btnField1.gridx = 9;
		gbc_btnField1.gridy = 2;
		add(btnField1, gbc_btnField1);
		
		JLabel lblPlayer2 = new JLabel("Player2");
		GridBagConstraints gbc_lblPlayer2 = new GridBagConstraints();
		gbc_lblPlayer2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer2.gridx = 1;
		gbc_lblPlayer2.gridy = 3;
		add(lblPlayer2, gbc_lblPlayer2);
		
		JLabel lblPos2 = new JLabel("Pos2");
		GridBagConstraints gbc_lblPos2 = new GridBagConstraints();
		gbc_lblPos2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPos2.gridx = 2;
		gbc_lblPos2.gridy = 3;
		add(lblPos2, gbc_lblPos2);
		
		JButton btnBench2 = new JButton("Put on Bench");
		GridBagConstraints gbc_btnBench2 = new GridBagConstraints();
		gbc_btnBench2.insets = new Insets(0, 0, 5, 5);
		gbc_btnBench2.gridx = 3;
		gbc_btnBench2.gridy = 3;
		add(btnBench2, gbc_btnBench2);
		
		JLabel lblSub2 = new JLabel("Sub2");
		GridBagConstraints gbc_lblSub2 = new GridBagConstraints();
		gbc_lblSub2.insets = new Insets(0, 0, 5, 5);
		gbc_lblSub2.gridx = 7;
		gbc_lblSub2.gridy = 3;
		add(lblSub2, gbc_lblSub2);
		
		JLabel lblSubpos2 = new JLabel("SubPos2");
		GridBagConstraints gbc_lblSubpos2 = new GridBagConstraints();
		gbc_lblSubpos2.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubpos2.gridx = 8;
		gbc_lblSubpos2.gridy = 3;
		add(lblSubpos2, gbc_lblSubpos2);
		
		JButton btnField2 = new JButton("Put on Field");
		btnField2.setEnabled(false);
		GridBagConstraints gbc_btnField2 = new GridBagConstraints();
		gbc_btnField2.insets = new Insets(0, 0, 5, 5);
		gbc_btnField2.gridx = 9;
		gbc_btnField2.gridy = 3;
		add(btnField2, gbc_btnField2);
		
		JLabel lblPlayer3 = new JLabel("Player3");
		GridBagConstraints gbc_lblPlayer3 = new GridBagConstraints();
		gbc_lblPlayer3.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer3.gridx = 1;
		gbc_lblPlayer3.gridy = 4;
		add(lblPlayer3, gbc_lblPlayer3);
		
		JLabel lblPos3 = new JLabel("Pos3");
		GridBagConstraints gbc_lblPos3 = new GridBagConstraints();
		gbc_lblPos3.insets = new Insets(0, 0, 5, 5);
		gbc_lblPos3.gridx = 2;
		gbc_lblPos3.gridy = 4;
		add(lblPos3, gbc_lblPos3);
		
		JButton btnBench3 = new JButton("Put on Bench");
		btnBench3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnField2.setEnabled(true);
				btnBench1.setEnabled(false);
			}
		});
		GridBagConstraints gbc_btnBench3 = new GridBagConstraints();
		gbc_btnBench3.insets = new Insets(0, 0, 5, 5);
		gbc_btnBench3.gridx = 3;
		gbc_btnBench3.gridy = 4;
		add(btnBench3, gbc_btnBench3);
		
		JLabel lblSub3 = new JLabel("Sub3");
		GridBagConstraints gbc_lblSub3 = new GridBagConstraints();
		gbc_lblSub3.insets = new Insets(0, 0, 5, 5);
		gbc_lblSub3.gridx = 7;
		gbc_lblSub3.gridy = 4;
		add(lblSub3, gbc_lblSub3);
		
		JLabel lblSubpos3 = new JLabel("SubPos3");
		GridBagConstraints gbc_lblSubpos3 = new GridBagConstraints();
		gbc_lblSubpos3.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubpos3.gridx = 8;
		gbc_lblSubpos3.gridy = 4;
		add(lblSubpos3, gbc_lblSubpos3);
		
		JButton btnField3 = new JButton("Put on Field");
		btnField3.setEnabled(false);
		GridBagConstraints gbc_btnField3 = new GridBagConstraints();
		gbc_btnField3.insets = new Insets(0, 0, 5, 5);
		gbc_btnField3.gridx = 9;
		gbc_btnField3.gridy = 4;
		add(btnField3, gbc_btnField3);
		
		JLabel lblPlayer4 = new JLabel("Player4");
		GridBagConstraints gbc_lblPlayer4 = new GridBagConstraints();
		gbc_lblPlayer4.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer4.gridx = 1;
		gbc_lblPlayer4.gridy = 5;
		add(lblPlayer4, gbc_lblPlayer4);
		
		JLabel lblPos4 = new JLabel("Pos4");
		GridBagConstraints gbc_lblPos4 = new GridBagConstraints();
		gbc_lblPos4.insets = new Insets(0, 0, 5, 5);
		gbc_lblPos4.gridx = 2;
		gbc_lblPos4.gridy = 5;
		add(lblPos4, gbc_lblPos4);
		
		JButton btnBench4 = new JButton("Put on Bench");
		GridBagConstraints gbc_btnBench4 = new GridBagConstraints();
		gbc_btnBench4.insets = new Insets(0, 0, 5, 5);
		gbc_btnBench4.gridx = 3;
		gbc_btnBench4.gridy = 5;
		add(btnBench4, gbc_btnBench4);
		
		JLabel lblSub4 = new JLabel("Sub4");
		GridBagConstraints gbc_lblSub4 = new GridBagConstraints();
		gbc_lblSub4.insets = new Insets(0, 0, 5, 5);
		gbc_lblSub4.gridx = 7;
		gbc_lblSub4.gridy = 5;
		add(lblSub4, gbc_lblSub4);
		
		JLabel lblSubpos4 = new JLabel("SubPos4");
		GridBagConstraints gbc_lblSubpos4 = new GridBagConstraints();
		gbc_lblSubpos4.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubpos4.gridx = 8;
		gbc_lblSubpos4.gridy = 5;
		add(lblSubpos4, gbc_lblSubpos4);
		
		JButton btnField4 = new JButton("Put on Field");
		btnField4.setEnabled(false);
		GridBagConstraints gbc_btnField4 = new GridBagConstraints();
		gbc_btnField4.insets = new Insets(0, 0, 5, 5);
		gbc_btnField4.gridx = 9;
		gbc_btnField4.gridy = 5;
		add(btnField4, gbc_btnField4);
		
		JLabel lblPlayer5 = new JLabel("Player5");
		GridBagConstraints gbc_lblPlayer5 = new GridBagConstraints();
		gbc_lblPlayer5.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer5.gridx = 1;
		gbc_lblPlayer5.gridy = 6;
		add(lblPlayer5, gbc_lblPlayer5);
		
		JLabel lblPos5 = new JLabel("Pos5");
		GridBagConstraints gbc_lblPos5 = new GridBagConstraints();
		gbc_lblPos5.insets = new Insets(0, 0, 5, 5);
		gbc_lblPos5.gridx = 2;
		gbc_lblPos5.gridy = 6;
		add(lblPos5, gbc_lblPos5);
		
		JButton btnBench5 = new JButton("Put on Bench");
		GridBagConstraints gbc_btnBench5 = new GridBagConstraints();
		gbc_btnBench5.insets = new Insets(0, 0, 5, 5);
		gbc_btnBench5.gridx = 3;
		gbc_btnBench5.gridy = 6;
		add(btnBench5, gbc_btnBench5);
		
		JLabel lblPlayer6 = new JLabel("Player6");
		GridBagConstraints gbc_lblPlayer6 = new GridBagConstraints();
		gbc_lblPlayer6.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer6.gridx = 1;
		gbc_lblPlayer6.gridy = 7;
		add(lblPlayer6, gbc_lblPlayer6);
		
		JLabel lblPos6 = new JLabel("Pos6");
		GridBagConstraints gbc_lblPos6 = new GridBagConstraints();
		gbc_lblPos6.insets = new Insets(0, 0, 5, 5);
		gbc_lblPos6.gridx = 2;
		gbc_lblPos6.gridy = 7;
		add(lblPos6, gbc_lblPos6);
		
		JButton btnBench6 = new JButton("Put on Bench");
		GridBagConstraints gbc_btnBench6 = new GridBagConstraints();
		gbc_btnBench6.insets = new Insets(0, 0, 5, 5);
		gbc_btnBench6.gridx = 3;
		gbc_btnBench6.gridy = 7;
		add(btnBench6, gbc_btnBench6);
		
		JLabel lblPlayer7 = new JLabel("Player7");
		GridBagConstraints gbc_lblPlayer7 = new GridBagConstraints();
		gbc_lblPlayer7.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer7.gridx = 1;
		gbc_lblPlayer7.gridy = 8;
		add(lblPlayer7, gbc_lblPlayer7);
		
		JLabel lblPos7 = new JLabel("Pos7");
		GridBagConstraints gbc_lblPos7 = new GridBagConstraints();
		gbc_lblPos7.insets = new Insets(0, 0, 5, 5);
		gbc_lblPos7.gridx = 2;
		gbc_lblPos7.gridy = 8;
		add(lblPos7, gbc_lblPos7);
		
		JButton btnBench7 = new JButton("Put on Bench");
		GridBagConstraints gbc_btnBench7 = new GridBagConstraints();
		gbc_btnBench7.insets = new Insets(0, 0, 5, 5);
		gbc_btnBench7.gridx = 3;
		gbc_btnBench7.gridy = 8;
		add(btnBench7, gbc_btnBench7);
		
		JLabel lblPlayer8 = new JLabel("Player8");
		GridBagConstraints gbc_lblPlayer8 = new GridBagConstraints();
		gbc_lblPlayer8.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer8.gridx = 1;
		gbc_lblPlayer8.gridy = 9;
		add(lblPlayer8, gbc_lblPlayer8);
		
		JLabel lblPos8 = new JLabel("Pos8");
		GridBagConstraints gbc_lblPos8 = new GridBagConstraints();
		gbc_lblPos8.insets = new Insets(0, 0, 5, 5);
		gbc_lblPos8.gridx = 2;
		gbc_lblPos8.gridy = 9;
		add(lblPos8, gbc_lblPos8);
		
		JButton btnBench8 = new JButton("Put on Bench");
		GridBagConstraints gbc_btnBench8 = new GridBagConstraints();
		gbc_btnBench8.insets = new Insets(0, 0, 5, 5);
		gbc_btnBench8.gridx = 3;
		gbc_btnBench8.gridy = 9;
		add(btnBench8, gbc_btnBench8);
		
		JLabel lblPlayer9 = new JLabel("Player9");
		GridBagConstraints gbc_lblPlayer9 = new GridBagConstraints();
		gbc_lblPlayer9.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer9.gridx = 1;
		gbc_lblPlayer9.gridy = 10;
		add(lblPlayer9, gbc_lblPlayer9);
		
		JLabel lblPos9 = new JLabel("Pos9");
		GridBagConstraints gbc_lblPos9 = new GridBagConstraints();
		gbc_lblPos9.insets = new Insets(0, 0, 5, 5);
		gbc_lblPos9.gridx = 2;
		gbc_lblPos9.gridy = 10;
		add(lblPos9, gbc_lblPos9);
		
		JButton btnBench9 = new JButton("Put on Bench");
		GridBagConstraints gbc_btnBench9 = new GridBagConstraints();
		gbc_btnBench9.insets = new Insets(0, 0, 5, 5);
		gbc_btnBench9.gridx = 3;
		gbc_btnBench9.gridy = 10;
		add(btnBench9, gbc_btnBench9);
		
		JLabel lblPlayer10 = new JLabel("Player10");
		GridBagConstraints gbc_lblPlayer10 = new GridBagConstraints();
		gbc_lblPlayer10.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer10.gridx = 1;
		gbc_lblPlayer10.gridy = 11;
		add(lblPlayer10, gbc_lblPlayer10);
		
		JLabel lblPos10 = new JLabel("Pos10");
		GridBagConstraints gbc_lblPos10 = new GridBagConstraints();
		gbc_lblPos10.insets = new Insets(0, 0, 5, 5);
		gbc_lblPos10.gridx = 2;
		gbc_lblPos10.gridy = 11;
		add(lblPos10, gbc_lblPos10);
		
		JButton btnBench10 = new JButton("Put on Bench");
		GridBagConstraints gbc_btnBench10 = new GridBagConstraints();
		gbc_btnBench10.insets = new Insets(0, 0, 5, 5);
		gbc_btnBench10.gridx = 3;
		gbc_btnBench10.gridy = 11;
		add(btnBench10, gbc_btnBench10);
		
		JLabel lblPlayer11 = new JLabel("Player11");
		GridBagConstraints gbc_lblPlayer11 = new GridBagConstraints();
		gbc_lblPlayer11.insets = new Insets(0, 0, 0, 5);
		gbc_lblPlayer11.gridx = 1;
		gbc_lblPlayer11.gridy = 12;
		add(lblPlayer11, gbc_lblPlayer11);
		
		JLabel lblPos11 = new JLabel("Pos11");
		GridBagConstraints gbc_lblPos11 = new GridBagConstraints();
		gbc_lblPos11.insets = new Insets(0, 0, 0, 5);
		gbc_lblPos11.gridx = 2;
		gbc_lblPos11.gridy = 12;
		add(lblPos11, gbc_lblPos11);
		
		JButton btnBench11 = new JButton("Put on Bench");
		GridBagConstraints gbc_btnBench11 = new GridBagConstraints();
		gbc_btnBench11.insets = new Insets(0, 0, 0, 5);
		gbc_btnBench11.gridx = 3;
		gbc_btnBench11.gridy = 12;
		add(btnBench11, gbc_btnBench11);
		
		}

}
