package sneaky.bigb.bigstorage;

import net.minecraft.block.Block;
import sneaky.bigb.block.ModBlocks;
import sneaky.bigb.chat.ChatUtil;

/**
 * @author SneakyTactician
 * A utility class used by some BIGStorage blocks.
 */
public class BIGStorageUtil
{	
	public static boolean IsBIGStorage(Block block)
	{
		boolean Ret = false;
		
		if (block.getUnlocalizedName().substring(5) == "WoodenController")
		{
			Ret = true;
			ChatUtil.SendChatMessageToAllPlayers("It is a Wooden Controller!");
		}
		else
		{
			ChatUtil.SendChatMessageToAllPlayers("It is not a Wooden Controller!");
		}
		
		if (block.getUnlocalizedName().substring(5) == "WoodenStorage")
		{
			Ret = true;
			ChatUtil.SendChatMessageToAllPlayers("It is a Wooden Storage Unit!");
		}
		else
		{
			ChatUtil.SendChatMessageToAllPlayers("It is not a Wooden Storage Unit!");
		}
		
		return Ret;
	}
	
	public static boolean IsController(Block block)
	{
		boolean Ret = false;
		
		if (block.getUnlocalizedName().substring(5) == "WoodenController")
		{
			Ret = true;
		}
		else
		{
			ChatUtil.SendChatMessageToAllPlayers("It is not a Wooden Controller!");
		}
		
		return Ret;
	}
}