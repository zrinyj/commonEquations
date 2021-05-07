import java.util.ArrayList;

public class PreAlgebra 
{
	PreAlgebra()
	{
		
	}
	
	//Find the average of the list of numbers
	public double mean(ArrayList<Double> doubleList)
	{
		double sum = 0;
		
		for(int i = 0; i < doubleList.size(); i++)
		{
			sum += doubleList.get(i);
		}
		
		return sum / doubleList.size();
	}
	
	//Find the x-intercepts of an equation
	public ArrayList<Double> quadraticFormula(double a, double b, double c)
	{
		ArrayList<Double> answers = new ArrayList<Double>();
		Double addOutcome = 0.0;
		Double subtractOutcome = 0.0;
		
		//Real Numbers
		if((Math.pow(b, 2) - 4 * a * c) >= 0.0)
		{
			addOutcome = (-b + Math.sqrt((b*b) - (4 * a * c))) / (2 * a);
			subtractOutcome = (-b - Math.sqrt((b*b) - (4 * a * c))) / (2 * a);
			
			answers.add(addOutcome);
			answers.add(subtractOutcome);
		}
		//Imaginary Numbers
		else
		{
			answers.add(-1234.5678);
		}
		
		return answers;
	}
	
	//Find the distance between two points. I should add a GraphPoint function as well
	public double distanceFormula(double x1, double y1, double x2, double y2)
	{
		System.out.println(Math.pow(x2 - x1, 2) + " - " + Math.pow(y2 - y1, 2) + " = " + Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	
	//Find the midpoint between two points. I should add an input four numbers version
	/*public GraphPoint midpointFormula(double x1, double y1, double x2, double y2)
	{
		return new GraphPoint((x1 - x2) / 2, (y1 - y2) / 2);
	}*/
}
