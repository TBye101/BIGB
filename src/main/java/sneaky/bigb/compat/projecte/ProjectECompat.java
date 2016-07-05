package sneaky.bigb.compat.projecte;

import java.util.List;

import moze_intel.projecte.PECore;
import moze_intel.projecte.api.ProjectEAPI;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;

public class ProjectECompat
{
	/**
	 * The first sweep of logic in this mod's ProjectE integration.
	 */
	public static void preInit()
	{
		LogHelper.info("ProjectE compat preInit started");
		
		LogHelper.info("ProjectE compat preInit finished");
	}
	
	/**
	 * The second sweep of logic in this mod's ProjectE integration.
	 */
	public static void Init()
	{
		LogHelper.info("ProjectE compat init started");
		
		LogHelper.info("ProjectE compat init finished");
	}
	
	/**
	 * The third sweep of logic in this mod's ProjectE integration.
	 */
	public static void PostInit()
	{
		LogHelper.info("ProjectE compat postInit started");
		//CheckToDisableAllEMC();
		LogHelper.info("ProjectE compat postInit finished");
	}
	
	/**
	 * @param item the item that will have it's EMC changed.
	 * @param value the value to change the item's EMC value to.
	 */
	public static void SetEMC(ItemStack item, int value)
	{
		ProjectEAPI.getEMCProxy().registerCustomEMC(item, value);
	}
	
	/**
	 * This method checks the config to see if it should disable all EMC. If true, it disables all EMC values on items.
	 * WIP
	 */
	public static void CheckToDisableAllEMC()
	{
		if (ModConfig.DisableAllEMC())
		{
			LogHelper.info("Disabling all EMC values");
			
			int b = 0;
			
			while (b != 9999999)
			{
				Item c = Item.getItemById(b);
				if (c != null)
				{
					if (c.getUnlocalizedName() != null)
					{
						LogHelper.info("Changing EMC for item: " + c.getUnlocalizedName());
						SetEMC(new ItemStack(c), 0);
					}
				}
				b++;
			}
			
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
					LogHelper.info("Changing block EMC for: " + e.getUnlocalizedName());
					if (Item.getItemFromBlock(e) != null)
					{
						
						//List<Block> Sub = null;
						//e.getSubBlocks(Item.getItemFromBlock(e), e.getCreativeTabToDisplayOn(), Sub);
						//
						//for (Block Block : Sub)
						//{
						//	SetEMC(new ItemStack(Item.getItemFromBlock(Block)), 0);
						//}
						
						SetEMC(new ItemStack(Item.getItemFromBlock(e)), 0);
					}
				}
				f++;
			}	
			LogHelper.info("Disabling done");
		}
		else
		{
			LogHelper.info("Not disabling all EMC values");
		}
	}
}