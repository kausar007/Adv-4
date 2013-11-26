//MySet Class
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MySet<E>
{	// OVERVIEW: Sets are unbounded mutable sets 

	private ArrayList<E> els; // the rep

	// constructors

	public MySet()
	{
		els = new ArrayList<E>();
	}

	//methods

	public void insert(E el)
	// MODIFIES: this
	// EFFECTS: Adds el to the elements of this
	{
		if(getIndex(el)<0) els.add(el);
	}

	public void remove(E el)
	// MODIFIES: this
	// EFFECTS: Removes el from this
	{
		int i = getIndex(el);
		if(i<0) return;
		els.set(i,els.get(els.size()-1));
		els.remove(els.size()-1);
	}

	public boolean isIn(E el)
	// EFFECTS: Returns true if el is in this else returns false
	{
		return getIndex(el)>=0;
	}

	private int getIndex(E el)
	// EFFECTS: If el is in this returns index where el appears 
	//          else returns -1
	{
		for(int i=0; i<els.size(); i++)
			if(el.equals(els.get(i))) return i;
		return -1;
	}

	public int size()
	// EFFECTS: Returns the cardinality of this
	{
		return els.size();
	}

	public String toString()
	// EFFECTS: Return string representation of this
	{
		if(els.size()==0)
			return "{}";
		else
		{
			String str="{"+els.get(0);
			for(int i=1; i<els.size(); i++)
				str+=","+els.get(i);
			return str+"}";
		}
	}

	//iterator generates an object of a class MySetGen
	public Iterator<E> iterator()
	{
		return new MySetGen(this);
	}


	// inner class MySetGen which implements Iterator
	private class MySetGen implements Iterator<E>
	{
		private MySet<E> myset;
		private int num;

		MySetGen(MySet<E> set)
		{	//REQUIRES: it != null
			myset = set;
			num = 0;	
		}

		public boolean hasNext()
		{
			return num < myset.els.size();
		}

		public E next() throws NoSuchElementException
		{			
			if (num < myset.els.size())
			{	
				E element = myset.els.get(num);
				num++;
				return element;
			}
			throw new NoSuchElementException();
		}

		public void remove() 
		{
			throw new UnsupportedOperationException();
		}
	}

}
