public class myarraylist<Body> implements mylist<Body>
{
	private Body[] arraylist;
	private int size = 0;
	
	public myarraylist()
	{
		arraylist = (Body[]) new Object[10];
	}
	
	public Body get (int position) throws Exception
	{
		if (position < 0 || position >= size)
		{
			throw new Exception("Invalid position. Please try again");
		}
		else
		{	
		return arraylist[position];
		}
	}
	
	public void add(Body item)
	{
		if ( size == arraylist.length)
		{
			growarray();
		}
		arraylist[size++] = item;
	}
	
	private void growarray()
	{
		Body[] newarray = (Body[]) new Object[size*2];
		for ( int i =0; i<arraylist.length; i++)
		{
			newarray[i] = arraylist[i];
		}
		arraylist = newarray;
				
	}
	
	public int size()
	{
		return size;
	}
}
