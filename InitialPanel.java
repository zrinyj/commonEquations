import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InitialPanel extends JPanel
{
	private BoxLayout bLay = null;
	
	private JLabel lblTitle = null;
	private JButton btnStart = null;
	private JButton btnHelp = null;
	private JButton btnExit = null;
	
	private Font largeFont = null;
	private Font smallFont = null;
	
	InitialPanel(MainPanel mainPanel)
	{
		//Set up the layout and the layout design
		bLay = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(bLay);
		
		//Set the fonts for each component to use
		largeFont = new Font("Times New Roman", Font.PLAIN, 48);
		smallFont = new Font("Times New Roman", Font.PLAIN, 32);
		
		//Initialize the title label and its design
		lblTitle = new JLabel("Common Equations");
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		lblTitle.setAlignmentY(CENTER_ALIGNMENT);
		lblTitle.setFont(largeFont);
		
		//Initialize the jbutton to start and its actionlistener
		btnStart = new JButton("Start");
		btnStart.setAlignmentX(CENTER_ALIGNMENT);
		btnStart.setAlignmentY(CENTER_ALIGNMENT);
		btnStart.setFont(smallFont);
		btnStart.addActionListener((event) ->
		{
			mainPanel.showStartPanel();
		});
		
		//Initialize the jbuttton to go to help panel when clicked
		btnHelp = new JButton("Help");
		btnHelp.setAlignmentX(CENTER_ALIGNMENT);
		btnHelp.setAlignmentY(CENTER_ALIGNMENT);
		btnHelp.setFont(smallFont);
		btnHelp.addActionListener((event) -> 
		{
			mainPanel.showHelpPanel();
		});
		
		//Initialize the button and to leave the application when pressed
		btnExit = new JButton("Exit");
		btnExit.setAlignmentX(CENTER_ALIGNMENT);
		btnExit.setAlignmentY(CENTER_ALIGNMENT);
		btnExit.setFont(smallFont);
		btnExit.addActionListener((event) -> 
		{
			System.exit(0);
		});
		
		//Add the components and rigid areas to make the design nice
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(lblTitle);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(btnStart);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(btnHelp);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(btnExit);
	}
}
