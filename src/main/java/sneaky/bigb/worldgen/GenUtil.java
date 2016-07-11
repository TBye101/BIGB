package sneaky.bigb.worldgen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.main.Util;

public class GenUtil
{
	/**
	 * Returns the y value of the top of the column.
	 */
	public int FindTopOfColumn(int x, int z)
	{
		int i = 1;
		int last = 1;
		
		while (i != 256)
		{
			if (!this.IsSquareOccupied(x, i, z))
			{
				last = i;
			}
			i++;
		}
		return last;
	}
	
	/**
	 * Tells you what biome you are generating for by coordinates.
	 */
	public BiomeGenBase GetBiomeFromCoordinates(int x, int z)
	{
		return Util.world.getBiomeGenForCoords(x, z);
	}
	
	/**
	 * This method tells us how big we can make the tree in all directions except down.
	 */
	public int FigureOutMaxSizeForTree(int x, int y, int z, int MaxCheckDistance)
	{
		int i = 0;
		boolean MaxSizeReached = false;
		
		while (i != MaxCheckDistance | MaxSizeReached)
		{
			i++;
			
			if (this.IsSquareOccupied(x + i, y, z))
			{
				MaxSizeReached = true;
				break;
			}
			
			if (this.IsSquareOccupied(x - i, y, z))
			{
				MaxSizeReached = true;
				break;
			}
			
			if (this.IsSquareOccupied(x, y + i, z))
			{
				MaxSizeReached = true;
				break;
			}
			
			if (this.IsSquareOccupied(x, y, z + i))
			{
				MaxSizeReached = true;
				break;
			}
			
			if (this.IsSquareOccupied(x, y, z - i))
			{
				MaxSizeReached = true;
				break;
			}
			
			if (this.IsSquareOccupied(x + i, y, z + i))
			{
				MaxSizeReached = true;
				break;
			}
			
			if (this.IsSquareOccupied(x - i, y, z + i))
			{
				MaxSizeReached = true;
				break;
			}
			
			if (this.IsSquareOccupied(x - i, y, z - i))
			{
				MaxSizeReached = true;
				break;
			}
			
			if (this.IsSquareOccupied(x + i, y, z - i))
			{
				MaxSizeReached = true;
				break;
			}
			
		}
		
		if (MaxSizeReached)
		{
			return i - 1;
		}
		else
		{
			return i;
		}
	}
	
	/**
	 * Tells the caller if there is a block there, or just air.
	 */
	public boolean IsSquareOccupied(int x, int y, int z)
	{
		try
		{
			if (y < 1)
			{
				return false;
			}
			
			Block BlockInQuestion = Util.world.getBlock(x, y, z);
			
			if (BlockInQuestion == null)
			{
				return true;
			}
			
			if (BlockInQuestion != Blocks.air)
			{
				return false;
			}
			
			return true;
		}
		catch (Exception e)
		{
			LogHelper.ErrorAlways("Whoops, we had a little problem finding out if a block was occupied");
			e.printStackTrace();
			return false;
		}
	}
}
