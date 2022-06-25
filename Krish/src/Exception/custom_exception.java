package src.Exception;

@SuppressWarnings("serial")
class k_exception extends Exception
{
	public k_exception(String s)
	{
		super(s);
	}
}
public class custom_exception {
	public static void main(String[] args) {
		try
		{
			throw new k_exception("Krish");
		}
		catch(k_exception ex)
		{
			System.out.println("Caught");
			System.out.println(ex.getMessage());
		}
	}
}