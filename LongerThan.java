//LongerThan Class
public class LongerThan implements Checker<String>
{
	private int length;

	public LongerThan(int length)
	{
		this.length = length;
	}


	public boolean check(String str)
	{
		//return true if length is greater than given limit
		return str.length() > this.length;
	}

}
