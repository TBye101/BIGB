package sneaky.bigb.worldgen.trees;

import net.minecraft.block.Block;
import net.minecraft.world.chunk.Chunk;
import sneaky.bigb.main.Util;
import sneaky.bigb.type.Point;
import sneaky.bigb.worldgen.GenUtil;

/**
 * @author SneakyTactician
 * This class generates a small tree
 */
public class GenerateTree1
{
	
	private GenUtil genutil = new GenUtil();
	
	/**
	 * Generates a tree.
	 */
	public void Generate(Point location, Block leaf, Block log, int maxsize, int minsize, Chunk current)
	{
		this.PlaceLogs(location, leaf, log, maxsize, minsize);
		this.PlaceLeaves(location, leaf, log, maxsize, minsize, current);
	}
	
	/**
	 * Places all of the logs for this tree
	 */
	private void PlaceLogs(Point location, Block leaf, Block log, int maxsize, int minsize)
	{
		int LogPlaceHeight;
		
		if (maxsize > 9)
		{
			LogPlaceHeight = maxsize / 4;
			LogPlaceHeight *= 3;
		}
		else
		{
			LogPlaceHeight = 4;
		}
		
		int i = 1;
		
		while (i != LogPlaceHeight)
		{
			Util.world.setBlock(location.x, location.y + i, location.z, log);
			i++;
		}
	}
	
	/**
	 * This method places all of the leaves for this tree.
	 */
	private void PlaceLeaves(Point location, Block leaf, Block log, int maxsize, int minsize, Chunk current)
	{
		int y = this.genutil.FindTopOfColumn(location.x, location.z, current) + 1;
		
		Util.world.setBlock(location.x, y, location.z, leaf);
		Util.world.setBlock(location.x + 1, y, location.z, leaf);
		Util.world.setBlock(location.x - 1, y, location.z, leaf);
		Util.world.setBlock(location.x, y, location.z + 1, leaf);
		Util.world.setBlock(location.x, y, location.z - 1, leaf);
		Util.world.setBlock(location.x + 1, y, location.z + 1, leaf);
		Util.world.setBlock(location.x + 1, y, location.z - 1, leaf);
		Util.world.setBlock(location.x - 1, y, location.z + 1, leaf);
		Util.world.setBlock(location.x - 1, y, location.z - 1, leaf);
		Util.world.setBlock(location.x, y + 1, location.z, leaf);
	}
}