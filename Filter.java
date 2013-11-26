//Filter class
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Filter<E> implements Iterator<E>
{
	private Iterator<E> myIterator;
	private Checker<E> myChecker;
	private boolean nextElementExists;
	private E element;
	

	
	public Filter(Iterator<E> itrtr, Checker<E> chkr)
	{
		myIterator = itrtr;
		myChecker = chkr;
		nextElementExists = false;
		
	}

	public boolean hasNext()
	{
		 if(nextElementExists)
			return true;
		else
			return checkNextElement();
		
	}
	
	private boolean checkNextElement()
	{
		E ele = null;
		while(myIterator.hasNext())
		{
			ele = myIterator.next();			
			if(myChecker.check(ele))
			{
				element = ele;
				nextElementExists = true;
				return true;
			}
		}
		return false;
	}
	
	public E next()
	{
		if (nextElementExists || checkNextElement())
		{
			nextElementExists = false;
			return element;
		}	
		throw new NoSuchElementException();
	}

	
	public void remove()
	{
		throw new UnsupportedOperationException();
	}

}
