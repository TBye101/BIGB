package sneaky.bigb.main;

import java.util.Random;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;

/**
 * @author SneakyTactician
 * This is a utility class that has various assorted functions.
 */
public class Util
{
	
	public static Random rand = new Random();
	
	public static World world;
	
	/**
	 * @param x
	 * @param y
	 * @param z
	 * Returns a block object from coordinates.
	 */
	public static Block GetBlockFromCoord(int x, int y, int z)
	{
		return world.getBlock(x, y, z);
	}
	
	/**
	 * This method logs all entities registered with minecraft.
	 * WIP
	 */
	public static void LogAllEntities()
	{
		//int i = 0;
		//while (i != EntityList.IDtoClassMapping.values().size())
		//{
			//LogHelper.info("Discovered entity: " + EntityList.IDtoClassMapping.values().iterator().next().toString());
		//}
	}
	
	/**
	 * This method returns the number of items registered with Minecraft while logging each discovered item along the way.
	 */
	public static int GetNumberOfItems()
	{
		if (!ModConfig.DisableAllLoggingAfterConfigIsLoaded())
		{
			int a = 0;
			int b = 0;
			
			while (b != 9999999)
			{
				Item c = Item.getItemById(b);
				if (c != null)
				{
					if (c.getUnlocalizedName() != null)
					{
						LogHelper.info("Item discovered: " + c.getUnlocalizedName());
						LogHelper.info("Detected " + a + " items so far");
						a++;
					}
				}
				b++;
			}
			
			return a;
		}
		return 0;
	}
	
	/**
	 * This method returns the number of blocks registered with Minecraft while logging each discovered block along the way.
	 */
	public static int GetNumberOfBlocks()
	{
		if (ModConfig.DisableAllLoggingAfterConfigIsLoaded())
		{
			int a = 0;
			int b = 0;
			int d = 0;
			
			while (b != 9999999)
			{
				Block c = Block.getBlockById(b);
				if (Block.getIdFromBlock(c) == 0)
				{
					d++;
					if (d == 100)
					{
						return a;
					}
				}
				else
				{
					LogHelper.info("Block discovered: " + c.getUnlocalizedName());
					LogHelper.info("Detected " + a + " blocks so far");
					a++;
				}
				b++;
			}
			return a;
		}
		
		return 0;
	}
	
	/**
	 * This method returns the number of recipes discovered in Minecraft.
	 */
	public static int GetNumberOfRecipes()
	{
		int a = CraftingManager.getInstance().getRecipeList().size();
		return a;
	}
	
	/**
	 * This method removes all crafting and smelting recipes registered with Minecraft.
	 */
	@SuppressWarnings("unchecked")
	public static void RemoveAllRecipes()
	{
		CraftingManager.getInstance().getRecipeList().removeAll(CraftingManager.getInstance().getRecipeList());
		FurnaceRecipes.smelting().getSmeltingList().values().removeAll(FurnaceRecipes.smelting().getSmeltingList().values());
	}
	
	/**
	 * This method outputs to the log all mods that are active.
	 */
	public static void LogAllModsAcive()
	{
		if (!ModConfig.DisableAllLoggingAfterConfigIsLoaded())
		{
			int i = 0;
			for (ModContainer Mod : Loader.instance().getModList())
			{
				LogHelper.info("Mod discovered: " + Mod.getName());
				i++;
			}
			LogHelper.info("Mods discovered: " + i);
		}
	}
	
	/**
	 * @param Stacksize this is the amount of items that should be stackable in a minecraft inventory.
	 * Massively changes all normal items to selected stack size. Tools, and other things should be excluded.
	 * WIP
	 */
	public static void MassChangeStackSizesForAllNormalItemsAndBlocks(int Stacksize)
	{
		if (ModConfig.ChangeAllStackSizesToX() <= 0)
		{
			LogHelper.info("Not changin stack sizes");
		}
		else
		{
			int a = 0;
			int b = 0;
			
			while (b != 9999999)
			{
				Item c = Item.getItemById(b);
				if (c != null)
				{
					if (c.getUnlocalizedName() != null)
					{
						LogHelper.info("Item discovered: " + c.getUnlocalizedName());
						
						if (ShouldChangeItemStackSize(c))
						{
							LogHelper.info("Changing stack size of item: " + c.getUnlocalizedName());
							c.setMaxStackSize(ModConfig.ChangeAllStackSizesToX());
						}
						else
						{
							LogHelper.info("Not changing stack size of item: " + c.getUnlocalizedName());
						}
						
						LogHelper.info("Detected " + a + " items so far");
						a++;
					}
				}
				b++;
			}
			
			int c = 0;
			int f = 0;
			int d = 0;
			
			while (f != 9999999)
			{
				Block e = Block.getBlockById(f);
				if (Block.getIdFromBlock(e) == 0)
				{
					d++;
					if (d == 100)
					{
						return;
					}
				}
				else
				{
					LogHelper.info("Block discovered: " + e.getUnlocalizedName());
					LogHelper.info("Changing stacksize of block " + e.getLocalizedName());
					if (Item.getItemFromBlock(e) != null)
					{
						Item.getItemFromBlock(e).setMaxStackSize(ModConfig.ChangeAllStackSizesToX());
						LogHelper.info("Changed " + c + " blocks so far");
					}
				}
				f++;
			}
		}
	}
	
	/**
	 * @param a the item to consider for item stack changes
	 * @return returns a boolean value
	 */
	public static boolean ShouldChangeItemStackSize(Item a)
	{
		ItemStack b = new ItemStack(a);

		if (a.isItemTool(b))
		{
			return false;
		}
		
		return true;
	}
	
	/**
	 * If this equals null, then there is no block to find.
	 */
	public static Block FindBlockFromString(String SearchTerm)
	{
		Block Found = null;
		
		int f = 0;
		int d = 0;
		
		while (f != 9999999)
		{
			Block e = Block.getBlockById(f);
			if (Block.getIdFromBlock(e) == 0)
			{
				d++;
				if (d == 100)
				{
					return Found;
				}
			}
			else
			{
				if (e.getLocalizedName().toLowerCase().contains(SearchTerm) || e.getUnlocalizedName().toLowerCase().contains(SearchTerm))
				{
					Found = e;
				}
			}
			f++;
		}
		
		return Found;
	}
		
	/**
	 * If this returns null, then there is no item to find.
	 */
	public static Item FindItemFromString(String SearchTerm)
	{
		int b = 0;
		
		Item c = null;
		
		while (b != 9999999)
		{
			c = Item.getItemById(b);
			if (c != null)
			{
				if (c.getUnlocalizedName() != null)
				{
					if (c.getUnlocalizedName().toLowerCase().contains(SearchTerm))
					{
						return c;
					}
				}
			}
			b++;
		}
		
		return c;
	}
	
	/**
	 * If this returns null, then there is no item to find.
	 */
	public static ItemStack FindItemStackFromObjectInputed(ItemStack ToFind)
	{
		return FurnaceRecipes.smelting().getSmeltingResult(ToFind);
	}
	
	public static boolean DoesSmeltingRecipeExist(ItemStack Input)
	{
		if (FurnaceRecipes.smelting().getSmeltingResult(Input) == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static int GetRandomHarvestLevel()
	{
		return rand.nextInt(3);
	}
}