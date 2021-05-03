import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class HelpPanel extends JPanel
{
	private GridBagLayout bLay = null;
	private GridBagConstraints constraints = null;
	
	private JLabel lblTitle = null;
	private JTextArea lblTitleInfo = null;
	private JLabel lblHowToUse = null;
	private JTextArea lblInfoHowToUse = null;
	private JButton btnBack = null;
	
	private Font largeFont = null;
	private Font smallFont = null;
	
	HelpPanel(MainPanel mainPanel)
	{
		//Set the layout of the help panel
		bLay = new GridBagLayout();
		this.setLayout(bLay);
		this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//Initialize the fonts for the other components to use
		largeFont = new Font("Times New Roman", Font.PLAIN, 48);
		smallFont = new Font("Times New Roman", Font.PLAIN, 32);
				
		//Initialize and design the title label
		lblTitle = new JLabel("Help:");
		lblTitle.setFont(largeFont);
		
		//Initialize the Jtext area and its design
		lblTitleInfo = new JTextArea("Allows entering in numbers to find solutions\n"
				+ "to equations and derivatives.\n");
		lblTitleInfo.setOpaque(false);
		lblTitleInfo.setFont(smallFont);
		
		//Initialize the how to use label title
		lblHowToUse = new JLabel("How to use:");
		lblHowToUse.setFont(largeFont);
		
		//Initialize the how to use instructions
		lblInfoHowToUse = new JTextArea("Input numbers in the equations and formulas\n"
				+ "in the derivatives.\n");
		lblInfoHowToUse.setOpaque(false);
		lblInfoHowToUse.setFont(smallFont);
		
		//Initialize the jbutton and its action listener to show the beginning panel when clicked
		btnBack = new JButton("Back");
		btnBack.setFont(smallFont);
		btnBack.addActionListener((event) -> 
		{
			mainPanel.showInitialPanel();
		});
		
		//Initialize constratins and add components with specific constraints
		constraints = new GridBagConstraints();
		constraints.weightx = 1;
		
		constraints.gridy = 0;
		this.add(lblTitle, constraints);
		
		constraints.gridy = 1;
		this.add(lblTitleInfo, constraints);
		
		constraints.gridy = 2;
		this.add(lblHowToUse, constraints);
		
		constraints.gridy = 3;
		this.add(lblInfoHowToUse, constraints);
		
		constraints.gridy = 4;
		this.add(btnBack, constraints);		
	}
}
