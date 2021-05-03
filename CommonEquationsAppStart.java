
import java.awt.EventQueue;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CommonEquationsAppStart extends JFrame
{
	private static CommonEquationsAppStart as = null;
	private MainPanel mainPanel = null;
	
	//Default constructor
	CommonEquationsAppStart()
	{
		initialize();
	}
	
	public void initialize()
	{
		//Set the attributes for the JFrame
		this.setTitle("Common Equations");
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new MainPanel();
		mainPanel.setSize(this.getWidth(), this.getHeight());
		this.add(mainPanel);
	}
	
	//Start the application
	public static void main(String args[])
	{
		EventQueue.invokeLater(() -> 
		{
			as = new CommonEquationsAppStart();
			as.setVisible(true);
		});
	}
}
