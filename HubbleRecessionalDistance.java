import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HubbleRecessionalDistance extends JPanel implements ActionListener
{
	private JLabel lblTitle = null;
	private JTextArea lblHowToUse = null;
	
	private JTextArea hubblesConstant = null;
	private JTextField userVelocity = null;
	
	private JButton btnCalculate = null;
	private JLabel lblAnswer = null;
	
	private Font largeFont = null;
	private Font smallFont = null;
	
	private Astronomy astronomy = null;
	
	HubbleRecessionalDistance()
	{
		//Initialize astronomy for its hubble functions
		astronomy = new Astronomy();
		
		//initialize font for component use
		largeFont = new Font("Times New Roman", Font.PLAIN, 32);
		smallFont = new Font("Times New Roman", Font.PLAIN, 24);
		
		//initialize each component and design 
		lblTitle = new JLabel("Hubble's Constant for Distance");
		lblTitle.setFont(largeFont);
		
		lblHowToUse = new JTextArea("Enter in your value for velocity and calculate when ready");
		lblHowToUse.setOpaque(false);
		lblHowToUse.setFont(smallFont);
		
		hubblesConstant = new JTextArea("73.4 km/s/Mpc * ");
		hubblesConstant.setOpaque(false);
		hubblesConstant.setFont(smallFont);
		
		//add a keylistener for bad data (key) inputs
		userVelocity = new JTextField(20);
		userVelocity.setMinimumSize(new Dimension(60, 35));
		userVelocity.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent key) 
			{
				if((key.getKeyChar() < '0' || key.getKeyChar() > '9') 
						&& key.getKeyChar() != '-' && key.getKeyCode() != KeyEvent.VK_BACK_SPACE
						&& key.getKeyChar() != '.')
				{
					userVelocity.setForeground(Color.red);
				}
				else
				{
					userVelocity.setForeground(Color.black);
				}
			}		
		});
		
		//action listener calls actionPerformed method when clicked
		btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(smallFont);
		btnCalculate.addActionListener(this);
		
		lblAnswer = new JLabel();
		lblAnswer.setFont(smallFont);
		
		this.add(lblTitle);
		this.add(lblHowToUse);
		this.add(hubblesConstant);
		this.add(userVelocity);
		this.add(btnCalculate);
		this.add(lblAnswer);
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		//checks for bad input data then solves
		if(check())
		{
			solve();
		}
		
	}
	
	public boolean check()
	{
		//if uservelocity contains a letter it will be red
		if(userVelocity.getForeground() != Color.red)
		{
			return true;
		}
		else
		{
			lblAnswer.setText("Please remove letters from your input");
			return false;
		}
	}
	
	public void solve()
	{
		Double distance = astronomy.hubblesConstantRecessionalDistance(
				Double.parseDouble(userVelocity.getText()));
		lblAnswer.setText(distance.toString() + "Mpc");
	}

}
