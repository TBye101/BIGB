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
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.main.Util;
import sneaky.bigb.type.Point;
import sneaky.bigb.worldgen.trees.GenerateTree1;

/**
 * @author SneakyTactician
 * This class generates a large oak tree when called upon if conditions are right.
 */
public class GenTree implements IWorldGenerator
{
	World world;
	
	public List<Block> Logs;
	
	public List<Block> Leaves;
	
	public int MinimumSizedTree = 5;
	
	public int ChanceToSpawnTree = 90;
	
	public GenUtil genutil = new GenUtil();
	
	/* (non-Javadoc)
	 * @see cpw.mods.fml.common.IWorldGenerator#generate(java.util.Random, int, int, net.minecraft.world.World, net.minecraft.world.chunk.IChunkProvider, net.minecraft.world.chunk.IChunkProvider)
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World wor, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		LogHelper.InfoAlways("CHUNKX AND Z: " + chunkX + ", " + chunkZ);
		world = wor;
		Util.world = wor;
		this.AddAllLeavesAndLogs();
		this.GenerateTreeWithChance(chunkX * 16, chunkZ * 16, world.getChunkFromBlockCoords(chunkX * 16, chunkZ * 16));
		LogHelper.InfoAlways("Done generating the chunk");
	}
	
	/**
	 * Returns the locations of all possible trees.
	 */
	public List<Point> GetPossibleTrees(int chunkX, int chunkZ, Chunk current)
	{
		List<Point> ret = new ArrayList<Point>();
		
		int z = 9;
		int x = 9;
		
		if (Util.world == null)
		{
			LogHelper.InfoAlways("World is NULL");
		}
		
		while (z != 10)
		{
			while (x != 10)
			{
				Point next;
				next = new Point();
				
				next.x = x + chunkX;
				next.y = this.genutil.FindTopOfColumn(chunkX + x,chunkZ + z, current);
				next.z = z + chunkZ;
				
				Block bl = Util.world.getBlock(next.x, next.y, next.z);
				
				//LogHelper.InfoAlways("Block at top of column is: " + bl.getLocalizedName());
				
				if (bl == Blocks.dirt || bl == Blocks.grass)
				{
					//LogHelper.InfoAlways("Found a tree that WAS possible: " + next.x + ", " + next.y + ", " + next.z);
					ret.add(next);
				}
				else
				{
					//LogHelper.InfoAlways("Found a tree that was NOT possible: " + next.x + ", " + next.y + ", " + next.z);
				}
				
				x++;
			}
			
			z++;
			x = 9;
		}
		
		int i = 0;
		
		while (i != ret.size())
		{
			Point e = ret.get(i);
			if (this.genutil.FigureOutMaxSizeForTree(e.x, e.y, e.z, this.MinimumSizedTree * 4, current) < this.MinimumSizedTree)
			{
				//LogHelper.InfoAlways("Removing a tree due to size requirments: " + ret.get(i).x + ", " + ret.get(i).y + ", " + ret.get(i).z);
				ret.remove(i);
			}
			i++;
		}
		
		return ret;
	}
	
	public void GenerateTreeWithChance(int chunkX, int chunkZ, Chunk current)
	{
		int i = 0;
		List<Point> TreeBases = this.GetPossibleTrees(chunkX, chunkZ, current);
		int siz = TreeBases.size();
		
		while (i != siz)
		{
			//LogHelper.InfoAlways("Possible tree count = " + TreeBases.size());
			if (Util.rand.nextInt(100) <= this.ChanceToSpawnTree)
			{
				Block leaf = this.Leaves.get(Util.rand.nextInt(Leaves.size()));
				Block log = this.Logs.get(Util.rand.nextInt(this.Logs.size()));
				
				Point Location = TreeBases.get(i);
				
				//LogHelper.InfoAlways("We made it here");
				
				int maxsize = this.genutil.FigureOutMaxSizeForTree(Location.x, Location.y, Location.z, 50, current);
				//LogHelper.InfoAlways("We Made it throught");
				this.GenerateRandomTree(Location, leaf, log, maxsize, this.MinimumSizedTree, current);
				LogHelper.InfoAlways("Done generating tree");
			}
			
			i++;
		}
	}
	
	/**
	 * Picks a random tree to generate
	 */
	public void GenerateRandomTree(Point location, Block leaf, Block log, int maxsize, int minsize, Chunk current)
	{
		int TreeType = Util.rand.nextInt(2);
		
		LogHelper.InfoAlways("Generating tree at: " + location.x + "," + " " + location.y + ", " + location.z);
		
		switch (TreeType)
		{
		case 0:
			this.GenerateStyle1(location, leaf, log, maxsize, minsize, current);
			break;
		default:
			this.GenerateStyle1(location, leaf, log, maxsize, minsize, current);
			break;
		}
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
	
	public void GenerateStyle1(Point location, Block leaf, Block log, int maxsize, int minsize, Chunk current)
	{
		GenerateTree1 a;
		a = new GenerateTree1();
		a.Generate(location, leaf, log, maxsize, minsize, current);
	}
}