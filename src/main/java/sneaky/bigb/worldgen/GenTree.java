package sneaky.bigb.worldgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import sneaky.bigb.main.Util;
import sneaky.bigb.type.Point;

/**
 * @author SneakyTactician
 * This class generates a large oak tree when called upon if conditions are right.
 */
public class GenTree implements IWorldGenerator
{
	World world;
	
	public List<Block> Logs;
	
	public List<Block> Leaves;
	
	/* (non-Javadoc)
	 * @see cpw.mods.fml.common.IWorldGenerator#generate(java.util.Random, int, int, net.minecraft.world.World, net.minecraft.world.chunk.IChunkProvider, net.minecraft.world.chunk.IChunkProvider)
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World wor, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		world = wor;
		this.AddAllLeavesAndLogs();
	}
	
	/**
	 * Returns the locations of all possible trees.
	 */
	public List<Point> GetPossibleTrees()
	{
		List<Point> ret = new ArrayList<Point>();
	}
	
	public void GenerateRandomTree(Random random, int chunkX, int chunkZ)
	{
		
	}
	
	/**
	 * Puts into 2 list all of the different options for leaves and logs to generate a tree from.
	 */
	public void AddAllLeavesAndLogs()
	{
		Logs = new ArrayList<Block>();
		Leaves = new ArrayList<Block>();
		
		Logs.add(Blocks.log);
		Leaves.add(Blocks.leaves);
	}
	
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
		return world.getBiomeGenForCoords(x, z);
	}
	
	/**
	 * This method tells us how big we can make the tree in all directions except down.
	 */
	public int FigureOutMaxSizeForTree(int x, int y, int z, int size)
	{
		int i = 0;
		boolean MaxSizeReached = false;
		
		while (i != size | MaxSizeReached)
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
		return world.isAirBlock(x, y, z);
	}
}