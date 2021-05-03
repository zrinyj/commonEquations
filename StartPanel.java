import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartPanel extends JPanel
{
	private BorderLayout bLay = null;
	
	private JMenuBar menuBar = null;

	private JMenu homeMenu = null;
	private JMenuItem homeItem = null;
	private JMenuItem helpItem = null;
	private JMenuItem exitItem = null;

	private JMenu topicMenu = null;
	
	private JMenu preAlgMenu = null;
	private JMenuItem quadraticFormulaItem = null;
	private JMenuItem distanceFormulaItem = null;
	
	private JMenu derivativeMenu = null;
	private JMenuItem derivativeMenuItem = null;
	
	private JMenu astronomyMenu = null;
	private JMenuItem hubbleConstantItem = null;
	
	private TopicPanelHolder topicPanelHolder = null;
	
	StartPanel(MainPanel mainPanel)
	{
		//Initialize and set the layout
		bLay = new BorderLayout();
		this.setLayout(bLay);
		
		//This is the main area where the other panels (ex. quadratic formula, derivative) are held
		topicPanelHolder = new TopicPanelHolder();
		
		//menu bar for home, topics, 
		//I want to add a section to add, edit, and delete user made functions
		menuBar = new JMenuBar();
		
		//Home menu contains options to return back to beginning screen, help screen and exit
		homeMenu = new JMenu("Home", false);
		
		//Shows the blank screen
		homeItem = new JMenuItem("Home");
		homeItem.addActionListener((event) -> 
		{
			topicPanelHolder.showTopicStart();
		});
		
		//Returns to help panel
		helpItem = new JMenuItem("Help");
		helpItem.addActionListener((event) -> 
		{
			mainPanel.showHelpPanel();
		});
		
		//exits application
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener((event) ->
		{
			System.exit(0);
		});
		
		//add each item to home menu
		homeMenu.add(homeItem);
		homeMenu.add(helpItem);
		homeMenu.add(exitItem);
	
		//Menu for topics
		topicMenu = new JMenu("Topics", false);
		
		//Menu within topics to hold pre-algebra functions
		preAlgMenu = new JMenu("Pre-algebra");
		
		//when clicked goes to quadratic formula panel
		quadraticFormulaItem = new JMenuItem("Quadratic Formula");
		quadraticFormulaItem.addActionListener((event) -> 
		{
			topicPanelHolder.showQuadraticFormula();
		});

		//when clicked goes to distance formula panel
		distanceFormulaItem = new JMenuItem("Distance Formula");
		distanceFormulaItem.addActionListener((event) -> 
		{
			topicPanelHolder.showDistanceFormula();
		});
		
		//add both pre-algebra items to the pre-algebra menu
		preAlgMenu.add(quadraticFormulaItem);
		preAlgMenu.add(distanceFormulaItem);
		
		//similar to prealgebra but for derivatives
		derivativeMenu = new JMenu("Derivatives");

		derivativeMenuItem = new JMenuItem("Derivative Solver");
		derivativeMenuItem.addActionListener((event) -> 
		{
			topicPanelHolder.showDerivativePanel();
		});
		
		derivativeMenu.add(derivativeMenuItem);
		
		//similar to pre-algebra but for astronomy equation panels
		astronomyMenu = new JMenu("Astronomy");
		
		hubbleConstantItem = new JMenuItem("Hubble's Constant");
		hubbleConstantItem.addActionListener((event) -> 
		{
			topicPanelHolder.showHubbleConstantPanel();
		});

		astronomyMenu.add(hubbleConstantItem);
		
		//add the menus to the main topic menu
		topicMenu.add(preAlgMenu);
		topicMenu.add(derivativeMenu);
		topicMenu.add(astronomyMenu);
		
		//add the homemenu and topicmenu to the main menubar
		menuBar.add(homeMenu);
		menuBar.add(topicMenu);
		
		//add menuBar and topicPanelHolder into correct parts of panel.
		this.add(topicPanelHolder, BorderLayout.CENTER);
		this.add(menuBar, BorderLayout.PAGE_START);
	}
}
