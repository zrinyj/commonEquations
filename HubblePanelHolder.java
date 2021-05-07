import java.awt.CardLayout;

import javax.swing.JPanel;

public class HubblePanelHolder extends JPanel
{
private CardLayout cLay = null;
	
	private JPanel recessionalDistancePanel = null;
	private JPanel recessionalVelocityPanel = null;
	
	HubblePanelHolder()
	{
		//Holds both the distance and velocity hubble panel and has methods to 
		//switch in between the two
		cLay = new CardLayout();
		this.setLayout(cLay);
		
		recessionalDistancePanel = new HubbleRecessionalDistance();
		recessionalVelocityPanel = new HubbleRecessionalVelocity();
		
		this.add(recessionalDistancePanel, "distance");
		this.add(recessionalVelocityPanel, "velocity");
	}
	
	public void showVelocityPanel()
	{
		cLay.show(this, "velocity");
	}
	
	public void showDistancePanel()
	{
		cLay.show(this, "distance");
	}
}
