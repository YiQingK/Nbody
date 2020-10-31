public class mylinkedlist<Body> implements mylist<Body>
{
	private class Node<Body>
	{
		Body data;
		Node<Body> next;
		
		public Node(Body value)
		{
			data = value;
			next = null;
		}
	}
	
	private Node<Body> head;
	private int size;
	
	public mylinkedlist()
	{
		head = null;
		size = 0;
	}
	
	public Body get(int position) throws Exception
	{
		// position check 		
		if (position < 0 || position > size)
		{
			throw new Exception("Invalid position. Please try again");
		}
		else
		{
		Node<Body> current = head;
		for ( int i = 0; i < position; i++)
		{
			current = current.next;
		}
		return current.data;
		}
	}
	
	public void add (Body item)
	{
		if (head == null)
		{
			head = new Node(item);
			size++;
		}
		else
		{
			Node prev = head;
			for (int i = 0; i < size-1; i++)
			{
				prev = prev.next;
			}
			Node newitem = new Node(item);
			prev.next = newitem;
			size++;
		}
	}
	
	public int size()
	{
		return size;
	}
}
