import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class OnlineDerivatives 
{
	private URL indexURL = null;
	private ArrayList<ReadURL> urlList = null;
	private ArrayList<String> functionList = null;
	private ArrayList<String> derivativeList = null;
	
	//Default constructor
	OnlineDerivatives()
	{
		try 
		{
			//initialize the class attributes
			indexURL = new URL("https://derivatives.azurewebsites.net/indexJSON.json");
			urlList = new ArrayList<ReadURL>();
			functionList = new ArrayList<String>();
			derivativeList = new ArrayList<String>();
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		
		getDerivativeURLs();
		getDerivatives();
		
		for(ReadURL list : urlList)
		{
			//add the thread list functions and derivatives 
			//into 1 master function list and 1 master derivative list
			functionList.addAll(list.getFunctionFromURLList());
			derivativeList.addAll(list.getDerivativeFromURLList());
		}
	}
	
	public ArrayList<String> getFunctionList()
	{
		return functionList;
	}
	
	public ArrayList<String> getDerivativeList()
	{
		return derivativeList;
	}
	
	public void getDerivativeURLs()
	{
		try 
		{
			//read the index url for more urls and add them to a list
			BufferedReader urlIn = new BufferedReader(new InputStreamReader(indexURL.openStream()));
			String readerInput = "";
			while((readerInput = urlIn.readLine()) != null)
			{
				if(readerInput.contains("http"))
				{
					String sub = readerInput.substring(readerInput.indexOf("http")
							, readerInput.lastIndexOf(".json") + 5);
					urlList.add(new ReadURL(new URL(sub)));
				}
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void getDerivatives()
	{
		//Get the online derivatives using a threaded  of reading urls 
		ArrayList<Thread> threadList = new ArrayList<Thread>();
		for(ReadURL readURL : urlList)
		{
			threadList.add(new Thread(readURL));
		}
		
		for(Thread thread : threadList)
		{
			thread.start();
		}
		
		try
		{
			for(Thread thread : threadList)
			{
				thread.join();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
