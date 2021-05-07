import java.awt.CardLayout;

import javax.swing.JPanel;

public class TopicPanelHolder extends JPanel
{
	private CardLayout cLay = null;
	
	private JPanel startPanel = null;
	private JPanel quadraticFormulaPanel = null;
	private JPanel distanceFormulaPanel = null;
	private JPanel derivativePanel = null;
	private JPanel hubbleConstantPanel = null;
	
	TopicPanelHolder()
	{
		cLay = new CardLayout();
		this.setLayout(cLay);
		
		//add each topic to this panel to then be switched from and to
		startPanel = new TopicStartPanel();
		
		quadraticFormulaPanel = new QuadraticFormulaPanel();
		
		distanceFormulaPanel = new DistanceFormulaPanel();
		
		derivativePanel = new DerivativePanel();
		
		hubbleConstantPanel = new HubblePanel();
		
		//add to this panel with specific short names
		this.add(startPanel, "blank");
		this.add(quadraticFormulaPanel, "quadraticFormula");
		this.add(distanceFormulaPanel, "distanceFormula");
		this.add(derivativePanel, "derivative");
		this.add(hubbleConstantPanel, "hubbleConstant");
		
	}
	
	//get the layout of this panel
	public CardLayout getCardLayout()
	{
		return cLay;
	}
	
	//show methods to get to a specific panel when needed to be seen
	public void showTopicStart()
	{
		cLay.show(this, "blank");
	}
	
	public void showQuadraticFormula()
	{
		cLay.show(this, "quadraticFormula");
	}
	
	public void showDistanceFormula()
	{
		cLay.show(this, "distanceFormula");
	}
	
	public void showDerivativePanel()
	{
		cLay.show(this, "derivative");
	}
	
	public void showHubbleConstantPanel() 
	{
		cLay.show(this, "hubbleConstant");
	}
}
