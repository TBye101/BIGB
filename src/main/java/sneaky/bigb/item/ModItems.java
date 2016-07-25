package sneaky.bigb.item;

import net.minecraft.item.Item;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.helpers.RegisterHelper;
import sneaky.bigb.lib.auto.create.AutoItem;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

/**
 * @author SneakyTactician
 * A class that holds items, and registers items.
 */
public class ModItems
{
	public static Item TribaniumIngot = new AutoItem(false, ModTabs.maintab, 64, "TribaniumIngot", "TribaniumIngot");
	public static Item FireDiamondCore = new AutoItem(false, ModTabs.maintab, 64, "Fire Diamond Core", "FireDiamondCore");
	public static Item FireDiamond = new AutoItem(false, ModTabs.maintab, 64, "FireDiamond", "FireDiamond");
	public static Item FireDiamondCoreSurroundedByDiamonds = new AutoItem(false, ModTabs.maintab, 64, "FireDiamondCoreSurroundedByDiamonds", "FireDiamondCoreSurroundedByDiamonds");
	public static Item NatureDiamond = new AutoItem(false, ModTabs.maintab, 64, "NatureDiamond", "NatureDiamond");
	
	//AutoItems
	public static Item NatureDiamondCore = new AutoItem(false, ModTabs.maintab, 64, "NatureDiamondCore", "NatureDiamondCore");
	public static Item TribaniumSpring = new AutoItem(true, ModTabs.maintab, 64, "TribaniumSpring64", "TribaniumSpring");
	
	/**
	 * Attempts to register all of the items in this class.
	 */
	public static void Reg()
	{
		RegisterTribaniumIngot();
		RegisterFireDiamondCore();
		RegisterFireDiamond();
		RegisterFireDiamondCoreSurroundedByDiamonds();
		RegisterNatureDiamond();
		RegisterNatureDiamondCore();
		RegisterTribaniumSpring();
	}
	
	public static void RegisterTribaniumSpring()
	{
		if (ModConfig.EnableTribaniumSpring())
		{
			RegisterHelper.registerItem(TribaniumSpring);
		}
		else
		{
			LogHelper.info("Not registering the tribanium spring with Minecraft due to config settings");
		}
	}
	
	public static void RegisterNatureDiamondCore()
	{
		if (ModConfig.EnableNatureDiamondCore())
		{
			RegisterHelper.registerItem(NatureDiamondCore);
		}
		else
		{
			LogHelper.info("Not registering nature diamond core with Minecraft because of config settings");
		}
	}
	
	public static void RegisterNatureDiamond()
	{
		if (ModConfig.EnableNatureDiamond())
		{
			RegisterHelper.registerItem(NatureDiamond);
		}
		else
		{
			LogHelper.info("Not registering nature diamond with Minecraft because of config settings");
		}
	}
	
	public static void RegisterFireDiamondCoreSurroundedByDiamonds()
	{
		if (ModConfig.EnableFireDiamondCoreSurroundedByDiamonds())
		{
			RegisterHelper.registerItem(FireDiamondCoreSurroundedByDiamonds);
		}
		else
		{
			LogHelper.info("Not registering fire diamond core surrounded by diamonds with Minecraft because of config settings");
		}
	}
	
	public static void RegisterFireDiamond()
	{
		if (ModConfig.EnableFireDiamond())
		{
			RegisterHelper.registerItem(FireDiamond);
		}
		else
		{
			LogHelper.info("Not registering fire diamond with Minecraft because of config settings");
		}
	}
	
	public static void RegisterFireDiamondCore()
	{
		if (ModConfig.EnableFireDiamondCore())
		{
			RegisterHelper.registerItem(FireDiamondCore);
		}
		else
		{
			LogHelper.info("Not registering the fire diamond core with Minecraft due to config settings");
		}
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
