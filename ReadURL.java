import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ReadURL implements Runnable
{
	private URL derivativeURL = null;
	private ArrayList<String> functionFromURL = null;
	private ArrayList<String> derivativeFromURL = null;
	
	//Default constructor
	ReadURL(URL url)
	{
		//initialize the class attributes
		derivativeURL = url;
		functionFromURL = new ArrayList<String>();
		derivativeFromURL = new ArrayList<String>();	
	}
	
	//get the function list from this class
	public ArrayList<String> getFunctionFromURLList()
	{
		return functionFromURL;
	}
	
	//get the derivative list from this class
	public ArrayList<String> getDerivativeFromURLList()
	{
		return derivativeFromURL;
	}
	
	//parse the parameter url (which is a json file) for derivatives and functions
	public void parse()
	{
		try 
		{
			BufferedReader bReader = new BufferedReader(new InputStreamReader(derivativeURL.openStream()));
			String reader = "";
			while((reader = bReader.readLine()) != null)
			{
				//Split the line into parts and read the 1st part for function or derivative
				String[] sub = reader.split("\"");
				if(sub.length > 3)
				{
					//if function add to function list
					if(sub[1].equalsIgnoreCase("function"))
					{
						functionFromURL.add(sub[3]);
					}
					//if derivative add to derivative list
					if(sub[1].equalsIgnoreCase("derivative"))
					{
						derivativeFromURL.add(sub[3]);
					}
				}
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void run() 
	{
		//called when started and calls parse
		parse();
	}
}
