

public class Astronomy 
{
	private double boltzmannConstant =  5.67037419 * Math.pow(10, -8);
	private double hubblesConstant = 73.4; // km/s/Mpc
	private double speedOfLight = 299792.458; // km/s
	
	
	Astronomy(){}
	
	public double boltzmannLuminosity(double R, double T)
	{
		return 4 * Math.PI *boltzmannConstant * Math.pow(R, 2) * Math.pow(T, 4);
	}
	
	public double boltzmannConstantRadius(double L, double T)
	{
		return L / 4 * Math.PI *boltzmannConstant * Math.pow(T, 4);
	}
	
	public double boltzmannConstantTemperature(double L, double R)
	{
		return L / 4 * Math.PI *boltzmannConstant * Math.pow(R, 4);
	}
	
	public double hubblesConstantRecessionalVelocity(double d)
	{
		return hubblesConstant * d;
	}
	
	public double hubblesConstantRecessionalDistance(double v)
	{
		return v / hubblesConstant;
	}
	
	public double fusionEnergy(double m)
	{
		return m * speedOfLight;
	}
	
	public double fusionMass(double E)
	{
		return E / speedOfLight;
	}
	
}

