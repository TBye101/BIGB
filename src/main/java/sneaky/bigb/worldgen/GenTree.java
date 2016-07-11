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
	
	public int ChanceToSpawnTree = 25;
	
	public GenUtil genutil = new GenUtil();
	
	/* (non-Javadoc)
	 * @see cpw.mods.fml.common.IWorldGenerator#generate(java.util.Random, int, int, net.minecraft.world.World, net.minecraft.world.chunk.IChunkProvider, net.minecraft.world.chunk.IChunkProvider)
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World wor, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		world = wor;
		this.AddAllLeavesAndLogs();
		this.GenerateTreeWithChance();
	}
	
	/**
	 * Returns the locations of all possible trees.
	 */
	public List<Point> GetPossibleTrees()
	{
		List<Point> ret = new ArrayList<Point>();
		
		int z = 1;
		int x = 1;
		
		while (z != 17)
		{
			while (x != 17)
			{
				Point next;
				next = new Point();
				
				next.x = x;
				next.y = this.genutil.FindTopOfColumn(x, z);
				next.z = z;
				
				LogHelper.InfoAlways("Y IS: " + next.y);
				
				Block bl = Util.world.getBlock(next.x, next.y - 1, next.z);
				if (bl == Blocks.dirt || bl == Blocks.grass)
				{
					ret.add(next);
				}
				
				x++;
			}
			
			z++;
			x = 1;
		}
		
		int i = 0;
		
		while (i != ret.size())
		{
			Point e = ret.get(i);
			if (this.genutil.FigureOutMaxSizeForTree(e.x, e.y, e.z, this.MinimumSizedTree * 4) < this.MinimumSizedTree)
			{
				ret.remove(i);
			}
		}
		
		return ret;
	}
	
	public void GenerateTreeWithChance()
	{
		int i = 0;
		List<Point> TreeBases = this.GetPossibleTrees();
		int siz = TreeBases.size();
		
		while (i != siz)
		{
			if (Util.rand.nextInt(100) <= this.ChanceToSpawnTree)
			{
				Block leaf = this.Leaves.get(Util.rand.nextInt(Leaves.size()));
				Block log = this.Logs.get(Util.rand.nextInt(this.Logs.size()));
				
				Point Location = TreeBases.get(i);
				
				int maxsize = this.genutil.FigureOutMaxSizeForTree(Location.x, Location.y, Location.z, 50);
				
				this.GenerateRandomTree(Location, leaf, log, maxsize, this.MinimumSizedTree);
			}
			
			i++;
		}
	}
	
	/**
	 * Picks a random tree to generate
	 */
	public void GenerateRandomTree(Point location, Block leaf, Block log, int maxsize, int minsize)
	{
		int TreeType = Util.rand.nextInt(0);
		
		switch (TreeType)
		{
		case 0:
			this.GenerateStyle1(location, leaf, log, maxsize, minsize);
			break;
		default:
			this.GenerateStyle1(location, leaf, log, maxsize, minsize);
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
	
	public void GenerateStyle1(Point location, Block leaf, Block log, int maxsize, int minsize)
	{
		GenerateTree1 a;
		a = new GenerateTree1();
		a.Generate(location, leaf, log, maxsize, minsize);
	}
}