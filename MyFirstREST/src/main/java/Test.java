import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Test2 
{
	public Test2()
	{
		System.out.println("in test2");
	}
	
	public Test2(int id)
	{
		System.out.println("test2 parameterised");
	}
}
public class Test extends Test2
{
	public Test()
	{
		//super(2);
		//this(2);
		System.out.println("in test no arg");
	}
	
	public Test(int id)
	{
		System.out.println("in test one arg constructor");
	}
	
	public static void main(String[] args) 
	{
		Test ab =new Test();
		List l = new LinkedList();
		l.add(12);
		l.add(null);
		l.add(10);
		l.add(null);
		Iterator itr = l.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
}
