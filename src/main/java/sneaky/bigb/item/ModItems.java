package sneaky.bigb.item;

import net.minecraft.item.Item;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.helpers.RegisterHelper;
import sneaky.bigb.lib.auto.create.AutoItem;
import sneaky.bigb.tabs.ModTabs;

/**
 * @author SneakyTactician
 * A class that holds items, and registers items.
 */
public class ModItems
{
	public static Item TribaniumIngot = new AutoItem(false, ModTabs.maintab, 64, "TribaniumIngot", "TribaniumIngot");
	
	/**
	 * Attempts to register all of the items in this class.
	 */
	public static void Reg()
	{
		RegisterTribaniumIngot();
	}
	
	public static void RegisterTribaniumIngot()
	{
		if (ModConfig.EnableTribaniumIngot())
		{
			RegisterHelper.registerItem(TribaniumIngot);
		}
		else
		{
			LogHelper.info("Not registering Tribanium Ingot due to config settings");
		}
	}
}
