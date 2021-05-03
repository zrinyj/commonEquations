import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JPanel;

//contains the other panels
@SuppressWarnings("serial")
public class MainPanel extends JPanel
{
	private JPanel initialPanel = null;
	private JPanel startPanel = null;
	private JPanel helpPanel = null;
	private CardLayout cLay = null;
	
	MainPanel()
	{
		//Initialize a cardlayout to hold many panels neatly
		cLay = new CardLayout();
		this.setLayout(cLay);
		
		//Initialize each panel and its alignment
		initialPanel = new InitialPanel(this);
		initialPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		startPanel = new StartPanel(this);
		startPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		helpPanel = new HelpPanel(this);
		helpPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//add to the mainpanel and its short name
		this.add(initialPanel, "init");
		this.add(startPanel, "start");
		this.add(helpPanel, "help");
	}
	
	
	//functions to call when an action occurs and these panels need to be seen
	public void showInitialPanel()
	{
		cLay.show(this, "init");
	}
	
	public void showStartPanel()
	{
		cLay.show(this, "start");
	}
	
	public void showHelpPanel()
	{
		cLay.show(this, "help");
	}
	
}
