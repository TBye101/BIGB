package sneaky.bigb.type;

/**
 * @author SneakyTactician
 * A class to hold a point of some sort in a 3D collection.
 */
public class Point
{
	/**
	 * The x location of something.
	 */
	public int x;
	
	
	/**
	 * The y location of something.
	 */
	public int y;
	
	/**
	 * The z location of something.
	 */
	public int z;
	
	/**
	 * The constructor for the Point class.
	 */
	public Point()
	{
		
	}
	public Point (int X, int Y, int Z)
	{
		this.x = X;
		this.y = Y;
		this.z = Z;
	}
}
