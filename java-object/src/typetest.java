class typetest
{
public static void main(String args[])
{
	String str = new String("Object");
	System.out.println(str.getClass().getName());
	
	// Checking whether str belongs to Object
	if(str instanceof Object)
		System.out.println("Hello");
	else
		System.out.println("Hi");
	
	// Checking whether str belongs to String
	if(str instanceof String)
		System.out.println("Hello");
	else
		System.out.println("Hi");
	
	if(str.getClass() == String.class)
		System.out.println("Hello");
	else
		System.out.println("Hi");
	}
}
