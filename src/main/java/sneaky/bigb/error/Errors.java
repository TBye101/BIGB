package sneaky.bigb.error;

/**
 * @author SneakyTactician
 * A class that holds all of the errors for the mod.
 */
public class Errors
{
	public static String StackSizeInvalidException = "The stack size for a operation is too large (64 max, 1 min)";
	
	public static void ThrowException(String message) throws Exception
	{
		throw new Exception(message);
	}
}
