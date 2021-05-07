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

public class HubbleRecessionalVelocity extends JPanel  implements ActionListener
{
	private JLabel lblTitle = null;
	private JTextArea lblHowToUse = null;
	
	private JTextArea hubblesConstant = null;
	private JTextField userDistance = null;
	
	private JButton btnCalculate = null;
	private JLabel lblAnswer = null;
	
	private Font largeFont = null;
	private Font smallFont = null;
	
	private Astronomy astronomy = null;
	
	HubbleRecessionalVelocity()
	{
		//initialize astronmy for its hubble functions
		astronomy = new Astronomy();
		
		//initialize font for component usage
		largeFont = new Font("Times New Roman", Font.PLAIN, 32);
		smallFont = new Font("Times New Roman", Font.PLAIN, 24);
		
		//initialize componenets and design
		lblTitle = new JLabel("Hubble's Constant for Velocity");
		lblTitle.setFont(largeFont);
		
		lblHowToUse = new JTextArea("Enter in your value for distance and calculate when ready");
		lblHowToUse.setOpaque(false);
		lblHowToUse.setFont(smallFont);
		
		hubblesConstant = new JTextArea("73.4 km/s/Mpc * ");
		hubblesConstant.setOpaque(false);
		hubblesConstant.setFont(smallFont);
		
		//if the user types a letter the font will turn red to signify an incorrect character
		userDistance = new JTextField(20);
		userDistance.setMinimumSize(new Dimension(60, 35));
		userDistance.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent key) 
			{
				if((key.getKeyChar() < '0' || key.getKeyChar() > '9') 
						&& key.getKeyChar() != '-' && key.getKeyCode() != KeyEvent.VK_BACK_SPACE
						&& key.getKeyChar() != '.')
				{
					userDistance.setForeground(Color.red);
				}
				else
				{
					userDistance.setForeground(Color.black);
				}
			}		
		});
		
		//action listener calls actionPeformed when the button is clicked
		btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(smallFont);
		btnCalculate.addActionListener(this);
		
		lblAnswer = new JLabel();
		lblAnswer.setFont(smallFont);
		
		this.add(lblTitle);
		this.add(lblHowToUse);
		this.add(hubblesConstant);
		this.add(userDistance);
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
		//if userDistance contains a letter it will be red
		if(userDistance.getForeground() != Color.red)
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
		Double velocity = astronomy.hubblesConstantRecessionalVelocity(
				Double.parseDouble(userDistance.getText()));
		lblAnswer.setText(velocity.toString() + "km/s");
	}

}
