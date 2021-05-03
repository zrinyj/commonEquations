import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class QuadraticFormulaPanel extends JPanel
{		
	private JLabel lblTitle = null;
	
	private JTextArea lblHowToUse = null;
	
	private JTextField xSquaredTextField = null;
	private JTextField xTextField = null;
	private JTextField cTextField = null;
	
	private JTextArea xSquaredLabel = null;
	private JTextArea xLabel = null;
	
	private JButton btnCalculate = null;
	
	private ArrayList<Double> answersList = null;
	private JLabel lblAdditionAnswer = null;
	private JLabel lblSubtractionAnswer = null;
	
	private PreAlgebra preAlg = null;
	
	private Font largeFont = null;
	private Font smallFont = null;
	
	QuadraticFormulaPanel()
	{
		//Initialize prealgebra for usage
		preAlg = new PreAlgebra();
		
		//initialize fonts for other components to use
		largeFont = new Font("Times New Roman", Font.PLAIN, 32);
		smallFont = new Font("Times New Roman", Font.PLAIN, 20);
		
		//initialize title and design
		lblTitle = new JLabel("Quadratic Formula");
		lblTitle.setFont(largeFont);
		
		//initialize how to use and design
		lblHowToUse = new JTextArea("Enter in the values for X^2 into the first field x into the 2nd field\n"
				+ "and the integer into the 3rd field");
		lblHowToUse.setOpaque(false);
		lblHowToUse.setFont(smallFont);
		
		//text field for the users x squared coefficient
		xSquaredTextField = new JTextField(10);
		xSquaredTextField.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent key) 
			{
				//if it is not a number, a negative sign
				if((key.getKeyChar() <= '0' || key.getKeyChar() >= '9') 
						&& key.getKeyChar() != '-' && key.getKeyCode() != KeyEvent.VK_BACK_SPACE)
				{
					xSquaredTextField.setForeground(Color.red);
				}
				else
				{
					xSquaredTextField.setForeground(Color.black);
				}
			}		
		});
		
		//for user to understand design of the equation
		xSquaredLabel = new JTextArea("x^2 + ");
		xSquaredLabel.setOpaque(false);
		
		//text field to get x coefficient
		xTextField = new JTextField(10);
		xTextField.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent key) 
			{
				if((key.getKeyChar() <= '0' || key.getKeyChar() >= '9') 
						&& key.getKeyChar() != '-' && key.getKeyCode() != KeyEvent.VK_BACK_SPACE)
				{
					xTextField.setForeground(Color.red);
				}
				else
				{
					xTextField.setForeground(Color.black);
				}
			}		
		});
		
		xLabel = new JTextArea("x + ");
		xLabel.setOpaque(false);
		
		cTextField = new JTextField(10);
		cTextField.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent key) 
			{
				if((key.getKeyChar() <= '0' || key.getKeyChar() >= '9') 
						&& key.getKeyChar() != '-' && key.getKeyCode() != KeyEvent.VK_BACK_SPACE)
				{
					cTextField.setForeground(Color.red);
				}
				else
				{
					cTextField.setForeground(Color.black);
				}
			}		
		});
		
		answersList = new ArrayList<Double>();
		
		//calculate the answer and if any text field is red tell the user what the problem is
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener((event) -> {
			if(xSquaredTextField.getForeground() != Color.red)
			{
				if(xTextField.getForeground() != Color.red)
				{
					if(cTextField.getForeground() != Color.red)
					{
						
						answersList = new ArrayList<Double>(solve(xSquaredTextField.getText(), xTextField.getText(), cTextField.getText()));
					}
					else
					{
						lblAdditionAnswer.setText("The c value cannot contain letters");
					}
				}
				else
				{
					lblAdditionAnswer.setText("The x value cannot contain letters");
				}
			}
			else
			{
				lblAdditionAnswer.setText("The x^2 value cannot contain letters");
			}
			showAnswers();
			
		});
		
		//answer labels
		lblAdditionAnswer = new JLabel();
		lblAdditionAnswer.setFont(smallFont);
		
		lblSubtractionAnswer = new JLabel();
		lblSubtractionAnswer.setFont(smallFont);

		//add components to panel
		this.add(lblTitle);
		this.add(lblHowToUse);		
		this.add(xSquaredTextField);
		this.add(xSquaredLabel);
		this.add(xTextField);
		this.add(xLabel);
		this.add(cTextField);
		this.add(btnCalculate);
		this.add(lblAdditionAnswer);
		this.add(lblSubtractionAnswer);
	}
	
	//get user inputs and put answers in to prealgebra quadratic formula equation
	public ArrayList<Double> solve(String xSquared, String xValue, String cValue)
	{
		double x2 = 0.0;
		double x = 0.0;
		double c = 0.0;
		
		
		if(xSquared.isBlank())
		{
			x2 = 0.0;
		}
		else
		{
			x2 = Double.parseDouble(xSquared);
		}
		
		if(xValue.isBlank())
		{
			x = 0.0;
		}
		else
		{
			x = Double.parseDouble(xValue);
		}
		
		if(cValue.isBlank())
		{
			c = 0.0;
		}
		else
		{
			c = Double.parseDouble(cValue);
		}
		
		return preAlg.quadraticFormula(x2, x, c);	
	}	
	
	//set the text of the labels
	public void showAnswers()
	{
		if(answersList.size() == 2)
		{
			lblAdditionAnswer.setText(answersList.get(0).toString());
			lblSubtractionAnswer.setText(answersList.get(1).toString());
		}
		else if(answersList.size() == 1)
		{
			if(answersList.get(0).equals(-1234.5678))
			{
				//Imaginary otherwise
				lblAdditionAnswer.setText("There are no solutions");
			}
			else
			{
				//Hits x intercept once
				lblAdditionAnswer.setText(answersList.get(0).toString());
			}
		}
	}
}
