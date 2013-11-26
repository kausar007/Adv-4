//Odd Class
public class Odd implements Checker<Integer>
{

	public boolean check(Integer value)
	{
		// returns true if value is odd
		return value % 2 != 0;
	}
}
