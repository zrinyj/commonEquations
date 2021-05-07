import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class HubblePanel extends JPanel implements ActionListener
{
	private BorderLayout bLay = null;
	
	private String[] hubbleList = null;
	
	private JComboBox<String> hubbleComboBox = null;
	
	private HubblePanelHolder hubbleHolder = null;
	
	HubblePanel()
	{
		//JPanel to switch between different hubble variables
		bLay = new BorderLayout();
		this.setLayout(bLay);
		
		hubbleList = new String[2];
		hubbleList[0] = "Recessional Distance";
		hubbleList[1] = "Recessional Velocity";
		
		//combo box to switch between the two
		hubbleComboBox = new JComboBox<String>(hubbleList);
		hubbleComboBox.setEditable(false);
		hubbleComboBox.addActionListener(this);
		
		hubbleHolder = new HubblePanelHolder();
		
		this.add(hubbleComboBox, bLay.PAGE_START);
		this.add(hubbleHolder, bLay.CENTER);
	}
	
	//When combo box is clicked this switches between the panels
	public void actionPerformed(ActionEvent e)
	{
		if(hubbleComboBox.getSelectedItem().equals(hubbleList[0]))
		{
			hubbleHolder.showDistancePanel();
		}
		else
		{
			hubbleHolder.showVelocityPanel();
		}
	}
}