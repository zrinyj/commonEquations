import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TopicStartPanel extends JPanel 
{
	private JTextArea lblHowToUse = null;
	private Font largeFont = null;
	
	TopicStartPanel()
	{
		largeFont = new Font("Times New Roman", Font.PLAIN, 32);
		lblHowToUse = new JTextArea("Choose a page from the navigation\n "
				+ "above to get started");
		lblHowToUse.setOpaque(false);
		lblHowToUse.setFont(largeFont);
		
		this.add(lblHowToUse);
	}
}
