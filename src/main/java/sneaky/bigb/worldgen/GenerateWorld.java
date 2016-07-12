package sneaky.bigb.worldgen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import sneaky.bigb.block.ModBlocks;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.main.Util;

public class GenerateWorld implements IWorldGenerator
{
		public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
		{
			Util.world = world;
				switch (world.provider.dimensionId)
				{
				case -1:
					this.generateNether(world, random, chunkX * 16, chunkZ *16);
					break;
				case 0:
					this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
					break;
				case 1:
					this.generateEnd(world, random, chunkX * 16, chunkZ * 16);
					break;
				}
		}

		private void generateEnd(World world, Random random, int x, int z)
		{
			
		}

		private void generateSurface(World world, Random random, int x, int z) 
		{
			this.OverWorldTribanium(world, random, x, z);
		}
		
		private void generateNether(World world, Random random, int x, int z) 
		{
			
		}
		
		/**
		 * Determines if we should generate Tribanium Ore into the world.
		 */
		private void OverWorldTribanium(World world, Random random, int x, int z)
		{
				if (ModConfig.EnableTribaniumOre())
				{
					this.addOreSpawn(ModBlocks.TribaniumOre, world, random, x, z, 16, 16, 1 + random.nextInt(9), 50, 1, 250);
				}
				else
				{
					LogHelper.info("Not generating Tribanium ore into the world due to config settings");
				}
		}
		
		/**
		 * Actually tells the world generator to generate the ore.
		 */
		private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY)
		{
				for (int i = 0; i < chanceToSpawn; i++)
				{
					int posX = blockXPos + random.nextInt(maxX);
					int posY = minY + random.nextInt(maxY - minY);
					int posZ = blockZPos + random.nextInt(maxZ);
					new WorldGenMinable(block, maxVeinSize).generate(world, random, posX, posY, posZ);
				}
		}
}