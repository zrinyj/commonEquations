import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DerivativePanel extends JPanel 
{
	private GridBagLayout gBLay = null;
	private GridBagConstraints constraint = null;
	
	//Concept from the Thunderbird application
	private OnlineDerivatives onlineDerivatives = null;
	private ArrayList<String> functionCheck = null;
	private ArrayList<String> derivativeAnswer = null;
	
	private JLabel lblTitle = null;	
	private JTextArea lblHowToUse = null;
	private JTextField userEquationTF = null;	
	private JButton btnCalc = null;
	private JLabel lblAnswer = null;
	
	private Font largeFont = null;
	private Font smallFont = null;
	
	DerivativePanel()
	{
		//Initialize the concepts from thunderbird
		onlineDerivatives = new OnlineDerivatives();
		functionCheck = new ArrayList<String>(onlineDerivatives.getFunctionList());
		derivativeAnswer = new ArrayList<String>(onlineDerivatives.getDerivativeList());
		
		//Initialize and set the layout
		gBLay = new GridBagLayout();
		this.setLayout(gBLay);
		constraint = new GridBagConstraints();
		
		//Initialize the fonts for other components to use
		largeFont = new Font("Times New Roman", Font.PLAIN, 32);
		smallFont = new Font("Times New Roman", Font.PLAIN, 24);
		
		//Initialize and design the title label
		lblTitle = new JLabel("Derivatives");
		lblTitle.setFont(largeFont);
		
		//Initialize and design the how to use label
		lblHowToUse = new JTextArea("Enter in your equation into the first text field\n"
				+ "using only numbers, letter x, and mathematical symbols");
		lblHowToUse.setFont(smallFont);
		lblHowToUse.setOpaque(false);
		
		//A text field for users to input their equations
		userEquationTF = new JTextField(20);
		
		//A blank label that will be set when the user clicks the calculate jbutton
		lblAnswer = new JLabel();
		lblAnswer.setFont(smallFont);
		
		//jbutton to call the solve function
		btnCalc = new JButton("Calculate");
		btnCalc.addActionListener((event) -> 
		{
			if(!userEquationTF.getForeground().equals(Color.red))
			{
				solve();
			}
			
		});
		
		//Add components with specific grid constraints
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.gridwidth = 3;
		this.add(lblTitle, constraint);
		
		constraint.gridx = 0;
		constraint.gridy = 1;
		constraint.gridwidth = 3;
		this.add(lblHowToUse, constraint);
		
		constraint.gridx = 0;
		constraint.gridy = 2;
		constraint.gridwidth = 3;
		constraint.fill = GridBagConstraints.HORIZONTAL;
		this.add(userEquationTF, constraint);
		
		constraint.gridx = 2;
		constraint.gridy = 3;
		constraint.gridwidth = 1;
		constraint.anchor = GridBagConstraints.LINE_END;
		this.add(btnCalc, constraint);
		
		constraint.gridx = 2;
		constraint.gridy = 4;
		constraint.gridwidth = 1;
		this.add(lblAnswer, constraint);
	}
	
	public void solve()
	{
		//Gets the text from the user through the text field
		String function = userEquationTF.getText();
		
		//Break down the function into subsections
		String[] subFunction = function.split("[-+*/=]");
		
		//Initialize a soluction string
		String solution = "";
		
		//Initialize an arraylist for -+*/= and their order in the equation
		ArrayList<String> mathSymbol = new ArrayList<String>();
		for(int i = 0; i < function.length(); i++)
		{
			if(function.charAt(i) == '+' || function.charAt(i) == '-'
					|| function.charAt(i) == '*' || function.charAt(i) == '/')
			{
				mathSymbol.add(Character.toString(function.charAt(i)));
			}
		}
		
		//initialize a count for the math symbols
		int count = 0;
		
		//Go through each section of the equation
		for(String section : subFunction)
		{
			section.trim();
		
			//if the x is to a power
			if(section.contains("x^"))
			{
				String coefficient = "";
				String exponent = "";
				
				//get the coefficient
				if(section.charAt(0) == 'x')
				{
					coefficient = "1";
				}
				else
				{
					coefficient = section.substring(0, section.indexOf("x^"));
				}
				
				//get the exponent
				if(section.contains("[-+*/]"))
				{
					exponent = section.substring(section.indexOf("^"), section.indexOf("[-+*/=]"));
				}
				else
				{
					exponent = section.substring(section.indexOf("^") + 1);
				}
				
				//solve for the derivative of the specific ?x^?
				Integer newCoefficient = Integer.parseInt(coefficient) * Integer.parseInt(exponent);
				Integer newExponent = Integer.parseInt(exponent) - 1;
				
				//add this sections derivative to the solution
				solution = solution + newCoefficient.toString() + "x^" + newExponent.toString();
			}
			else
			{
				//Checks through a list of equation examples (ex. sinx, lnx, tanx) for a match
				for(String check : functionCheck)
				{
					//If their is a match, get the index of the match
					//and add the derivative index to the soution string
					if(section.equalsIgnoreCase(check))
					{
						solution = solution + derivativeAnswer.get(functionCheck.lastIndexOf(check));

						//If the user equation has a math symbol add it in
						if(mathSymbol.size() >= 1 && count < mathSymbol.size())
						{
							solution = solution + mathSymbol.get(count);
							count++;
						}
					}
				}
			}
		}
		//set the label to the found solution
		lblAnswer.setText(solution);
	}
}
