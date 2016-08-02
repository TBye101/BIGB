package sneaky.bigb.bigstorage;

import net.minecraft.block.Block;
import sneaky.bigb.block.ModBlocks;
import sneaky.bigb.chat.ChatUtil;
import sneaky.bigb.helpers.LogHelper;

/**
 * @author SneakyTactician
 * A utility class used by some BIGStorage blocks.
 */
public class BIGStorageUtil
{	
	/**
	 * Figures out if the block passed in is part of the BIGStorage network.
	 */
	public static boolean IsBIGStorage(Block block)
	{
		if (block == ModBlocks.WoodController || block == ModBlocks.WoodStorage)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Figures out if the block passed in is a controller of any kind.
	 */
	public static boolean IsController(Block block)
	{
		if (block == ModBlocks.WoodController)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}