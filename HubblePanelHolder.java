import java.awt.CardLayout;

import javax.swing.JPanel;

public class HubblePanelHolder extends JPanel
{
private CardLayout cLay = null;
	
	private JPanel recessionalDistancePanel = null;
	private JPanel recessionalVelocityPanel = null;
	
	HubblePanelHolder()
	{
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
