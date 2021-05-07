import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DistanceFormulaPanel extends JPanel
{	
	private JLabel lblTitle = null;
	
	private JTextArea lblHowToUse = null;
	
	private JTextField x1 = null;
	private JTextField y1 = null;
	private JTextField x2 = null;
	private JTextField y2 = null;
	
	private JTextArea leftParenthesis = null;
	private JTextArea comma = null;
	private JTextArea rightParenthesis = null;
	
	private JTextArea leftParenthesis1 = null;
	private JTextArea comma1 = null;
	private JTextArea rightParenthesis1 = null;
	
	private JButton btnCalculate = null;
	
	private JLabel lblAnswer = null;
	
	private Font largeFont = null;
	private Font smallFont = null;
	
	private PreAlgebra preAlgebra = null;
	
	DistanceFormulaPanel()
	{		
		//Prealgebra class to find the answers
		preAlgebra = new PreAlgebra();
		
		//set fonts for other components to use
		largeFont = new Font("Times New Roman", Font.PLAIN, 32);
		smallFont = new Font("Times New Roman", Font.PLAIN, 24);
		
		//title label
		lblTitle = new JLabel("Distance Formula");
		lblTitle.setFont(largeFont);
		
		lblHowToUse = new JTextArea("Enter your values for (x1, y1) then (x2, y2) into the text fields\n"
				+ "and press calculate when ready");
		lblHowToUse.setFont(smallFont);
		lblHowToUse.setOpaque(false);
		
		//x1 position
		x1 = new JTextField(20);
		x1.setMinimumSize(new Dimension(80,25));
		x1.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent key) 
			{
				if((key.getKeyChar() < '0' || key.getKeyChar() > '9') 
						&& key.getKeyChar() != '-' && key.getKeyCode() != KeyEvent.VK_BACK_SPACE
						&& key.getKeyChar() != '.')
				{
					x1.setForeground(Color.red);
				}
				else
				{
					x1.setForeground(Color.black);
				}
			}		
		});
		
		//y1 position
		y1 = new JTextField(20);
		y1.setMinimumSize(new Dimension(80,25));
		y1.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent key) 
			{
				if((key.getKeyChar() < '0' || key.getKeyChar() > '9') 
						&& key.getKeyChar() != '-' && key.getKeyCode() != KeyEvent.VK_BACK_SPACE
						&& key.getKeyChar() != '.')
				{
					y1.setForeground(Color.red);
				}
				else
				{
					y1.setForeground(Color.black);
				}
			}		
		});
		
		//x2 position
		x2 = new JTextField(20);
		x2.setMinimumSize(new Dimension(80,25));
		x2.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent key) 
			{
				if((key.getKeyChar() < '0' || key.getKeyChar() > '9') 
						&& key.getKeyChar() != '-' && key.getKeyCode() != KeyEvent.VK_BACK_SPACE
						&& key.getKeyChar() != '.')
				{
					x2.setForeground(Color.red);
				}
				else
				{
					x2.setForeground(Color.black);
				}
			}		
		});
		
		//y2 position
		y2 = new JTextField(20);
		y2.setMinimumSize(new Dimension(80,25));
		y2.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent key) 
			{
				if((key.getKeyChar() < '0' || key.getKeyChar() > '9') 
						&& key.getKeyChar() != '-' && key.getKeyCode() != KeyEvent.VK_BACK_SPACE
						&& key.getKeyChar() != '.')
				{
					y2.setForeground(Color.red);
				}
				else
				{
					y2.setForeground(Color.black);
				}
			}		
		});
		
		//To better the look and design
		leftParenthesis = new JTextArea("       (");
		leftParenthesis.setOpaque(false);
		leftParenthesis.setFont(smallFont);
		
		comma = new JTextArea(", ");
		comma.setOpaque(false);
		comma.setFont(smallFont);
		
		rightParenthesis = new JTextArea(")       ");
		rightParenthesis.setOpaque(false);
		rightParenthesis.setFont(smallFont);
		
		leftParenthesis1 = new JTextArea("       (");
		leftParenthesis1.setOpaque(false);
		leftParenthesis1.setFont(smallFont);
		
		comma1 = new JTextArea(", ");
		comma1.setOpaque(false);
		comma1.setFont(smallFont);
		
		rightParenthesis1 = new JTextArea(")       ");
		rightParenthesis1.setOpaque(false);
		rightParenthesis1.setFont(smallFont);
		
		//label for the answer
		lblAnswer = new JLabel();
		lblAnswer.setFont(smallFont);
		
		//btnCalculate calls a function to make sure each text field is good then calls a function
		//to solve
		btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(smallFont);
		btnCalculate.addActionListener((event) -> 
		{
			if(check())
			{
				Double answer = solve(x1.getText(), y1.getText(), x2.getText(), y2.getText());
				lblAnswer.setText(answer.toString());
			}
		});
		
		this.add(lblTitle);
		this.add(lblHowToUse);
		this.add(leftParenthesis);
		this.add(x1);
		this.add(comma);
		this.add(y1);
		this.add(rightParenthesis);
		this.add(leftParenthesis1);
		this.add(x2);
		this.add(comma1);
		this.add(y2);
		this.add(rightParenthesis1);
		this.add(lblAnswer);
		this.add(btnCalculate);
	}
	
	//check for blank textfields then solve
	public double solve(String x1Value, String y1Value, String x2Value, String y2Value)
	{
		double x1Double, y1Double, x2Double, y2Double;
		
		if(x1Value.isBlank())
		{
			x1Double = 0.0;
		}
		else
		{
			x1Double = Double.parseDouble(x1Value);
		}
		
		if(y1Value.isBlank())
		{
			y1Double = 0.0;
		}
		else
		{
			y1Double = Double.parseDouble(y1Value);
		}
		
		if(x2Value.isBlank())
		{
			x2Double = 0.0;
		}
		else
		{
			x2Double = Double.parseDouble(x2Value);
		}
		
		if(y2Value.isBlank())
		{
			y2Double = 0.0;
		}
		else
		{
			y2Double = Double.parseDouble(y2Value);
		}
		
		return preAlgebra.distanceFormula(x1Double, y1Double, x2Double, y2Double);
	}
	
	//check that none of the textfields contain bad data
	public boolean check()
	{
		if(x1.getForeground() != Color.red)
		{
			if(y1.getForeground() != Color.red)
			{
				if(x2.getForeground() != Color.red)
				{
					if(y2.getForeground() != Color.red)
					{
						return true;
					}
					else
					{
						lblAnswer.setText("y2 cannot contain letters");
						return false;
					}
				}
				else
				{
					lblAnswer.setText("x2 cannot contain letters");
					return false;
				}
			}
			else
			{
				lblAnswer.setText("y1 cannot contain letters");
				return false;
			}
		}
		else
		{
			lblAnswer.setText("x1 cannot contain letters");
			return false;
		}
	}
}
