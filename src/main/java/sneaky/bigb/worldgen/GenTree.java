package sneaky.bigb.worldgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import sneaky.bigb.main.Util;

/**
 * @author SneakyTactician
 * This class generates a large oak tree when called upon if conditions are right.
 */
public class GenTree implements IWorldGenerator
{

	public List<Block> Logs;
	
	public List<Block> Leaves;
	
	/* (non-Javadoc)
	 * @see cpw.mods.fml.common.IWorldGenerator#generate(java.util.Random, int, int, net.minecraft.world.World, net.minecraft.world.chunk.IChunkProvider, net.minecraft.world.chunk.IChunkProvider)
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		this.AddAllLeavesAndLogs();
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
	 * 
	 */
	public int FigureOutMaxSizeForTree(int x, int y, int z, int size)
	{
		//TODO:
		return 1;
	}
	
	public boolean IsSquareOccupied(int x, int y, int z)
	{
		Block block = Util.world.getBlock(x, y, z);
		
		if (block.isAir(Util.world, x, y, z))
		{
			return false;
		}
		
		return true;
	}
}