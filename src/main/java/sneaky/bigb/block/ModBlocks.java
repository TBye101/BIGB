package sneaky.bigb.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import sneaky.bigb.block.assorted.SpeedBlock;
import sneaky.bigb.block.glass.clearglass.ClearGlass;
import sneaky.bigb.block.glass.shockproofclearglass.ShockProofClearGlass;
import sneaky.bigb.block.invisible.InvisibleBlock;
import sneaky.bigb.block.reinforcedwalls.ReinforcedBlueWall;
import sneaky.bigb.block.reinforcedwalls.ReinforcedDarkBlueWall;
import sneaky.bigb.block.reinforcedwalls.ReinforcedLightBlueWall;
import sneaky.bigb.block.reinforcedwalls.ReinforcedLimeGreenWall;
import sneaky.bigb.block.reinforcedwalls.ReinforcedOrangeWall;
import sneaky.bigb.block.reinforcedwalls.ReinforcedPinkWall;
import sneaky.bigb.block.reinforcedwalls.ReinforcedPurpleWall;
import sneaky.bigb.block.reinforcedwalls.ReinforcedRedWall;
import sneaky.bigb.block.reinforcedwalls.ReinforcedYellowWall;
import sneaky.bigb.block.testblock.TestBlock;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.helpers.RegisterHelper;
import sneaky.bigb.lib.auto.AutoItemAndBlock;
import sneaky.bigb.lib.auto.block.AutoBouncePad;
import sneaky.bigb.lib.auto.create.AutoBlock;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

/**
 * @author SneakyTactician
 * A class that holds and registers blocks.
 */
public class ModBlocks
{
	
	public static Block clearglass = new ClearGlass();
	public static Block testblock = new TestBlock();
	public static Block invisibleblock = new InvisibleBlock();
	public static Block shockproofclearglass = new ShockProofClearGlass();
	public static Block speedblock = new SpeedBlock();
	
	public static Block reinforcedlimegreenwall = new ReinforcedLimeGreenWall();
	public static Block reinforcedbluewall = new ReinforcedBlueWall();
	public static Block reinforceddarkbluewall = new ReinforcedDarkBlueWall();
	public static Block reinforcedlightbluewall = new ReinforcedLightBlueWall();
	public static Block reinforcedorangewall = new ReinforcedOrangeWall();
	public static Block reinforcedpinkwall = new ReinforcedPinkWall();
	public static Block reinforcedpurplewall = new ReinforcedPurpleWall();
	public static Block reinforcedredwall = new ReinforcedRedWall();
	public static Block reinforcedyellowwall = new ReinforcedYellowWall();
	
	//AutoBlocks
	public static Block TribaniumOre = new AutoBlock(Material.ground, false, 15, 15, 5, "pickaxe", 2, Block.soundTypeStone, "Tribanium", ModTabs.maintab, 5, false, true, "Tribanium");
	public static Block TribaniumBouncePad = new AutoBouncePad(10F, 5F, 2, "TribaniumBouncePad", ModTabs.maintab, Reference.MODID + ":BouncePad64", 1.9F, 15F);
	
	public static void RegisterAll()
	{
		RegisterClearGlass();
		RegisterTestBlock();
		RegisterInvisibleBlock();
		RegisterShockProofClearGlass();
		RegisterLimeGreenWall();
		RegisterBlueWall();
		RegisterDarkBlueWall();
		RegisterLightBlueWall();
		RegisterOrangeWall();
		RegisterPinkWall();
		RegisterPurpleWall();
		RegisterRedWall();
		RegisterYellowWall();
		RegisterTribaniumOre();
		RegisterSpeedBlock();
		RegisterTribaniumBoundPad();
	}
	
	public static void RegisterTribaniumBoundPad()
	{
		if (ModConfig.EnableTribaniumBouncePad())
		{
			RegisterHelper.registerBlock(TribaniumBouncePad);
		}
		else
		{
			LogHelper.info("Not registering the Tribanium bounce pad due to config settings");
		}
	}
	
	public static void RegisterSpeedBlock()
	{
		if (ModConfig.EnableSpeedBlock())
		{
			RegisterHelper.registerBlock(speedblock);
		}
		else
		{
			LogHelper.info("Not registering the speed block due to configuration settings");
		}
	}
	
	public static void RegisterTribaniumOre()
	{
		if (ModConfig.EnableTribaniumOre())
		{
			RegisterHelper.registerBlock(TribaniumOre);
		}
		else
		{
			LogHelper.info("Not registering Tribanium Ore because of config settings");
		}
	}
	
	public static void RegisterYellowWall()
	{
		if (ModConfig.DisableReinforcedYellowWall())
		{
			LogHelper.info("Not registering reinforced yellow wall because of config settings.");
		}
		else
		{
			RegisterHelper.registerBlock(reinforcedyellowwall);
		}
	}
	
	public static void RegisterRedWall()
	{
		if (ModConfig.DisableReinforcedRedWall())
		{
			LogHelper.info("Not registering reinforced red wall because of config settings.");
		}
		else
		{
			RegisterHelper.registerBlock(reinforcedredwall);
		}
	}
	
	public static void RegisterPurpleWall()
	{
		if (ModConfig.DisableReinforcedPurpleWall())
		{
			LogHelper.info("Not registering reinforced purple wall because of config settings.");
		}
		else
		{
			RegisterHelper.registerBlock(reinforcedpurplewall);
		}
	}
	
	public static void RegisterPinkWall()
	{
		if (ModConfig.DisableReinforcedPinkWall())
		{
			LogHelper.info("Not registering reinforced pink wall because of config settings.");
		}
		else
		{
			RegisterHelper.registerBlock(reinforcedpinkwall);
		}
	}
	
	public static void RegisterOrangeWall()
	{
		if (ModConfig.DisableReinforcedOrangeWall())
		{
			LogHelper.info("Not registering reinforced orange wall because of config settings.");
		}
		else
		{
			RegisterHelper.registerBlock(reinforcedorangewall);
		}
	}
	
	public static void RegisterLightBlueWall()
	{
		if (ModConfig.DisableReinforcedLightBlueWall())
		{
			LogHelper.info("Not registering reinforced light blue wall because of config settings.");
		}
		else
		{
			RegisterHelper.registerBlock(reinforcedlightbluewall);
		}
	}
	
	public static void RegisterDarkBlueWall()
	{
		if (ModConfig.DisableReinforcedLimeGreenWall())
		{
			LogHelper.info("Not registering reinforced dark blue wall because of config settings.");
		}
		else
		{
			RegisterHelper.registerBlock(reinforceddarkbluewall);
		}
	}
	
	public static void RegisterBlueWall()
	{
		if (ModConfig.DisableReinforcedBlueWall())
		{
			LogHelper.info("Not registering reinforced blue wall because of config settings.");
		}
		else
		{
			RegisterHelper.registerBlock(reinforcedbluewall);
		}
	}
	
	public static void RegisterLimeGreenWall()
	{
		if (ModConfig.DisableReinforcedLimeGreenWall())
		{
			LogHelper.info("Not registering reinforced lime green wall because of config settings.");
		}
		else
		{
			RegisterHelper.registerBlock(reinforcedlimegreenwall);
		}
	}
	
	public static void RegisterShockProofClearGlass()
	{
		if (ModConfig.DisableShockProofClearGlass())
		{
			LogHelper.info("Not registering shock proof clear glass because of config settings.");
		}
		else
		{
			RegisterHelper.registerBlock(shockproofclearglass);
		}
	}
	
	public static void RegisterInvisibleBlock()
	{
		if (ModConfig.DisableClearGlass())
		{
			LogHelper.info("Not registering invisible block because of config settings.");
		}
		else
		{
			RegisterHelper.registerBlock(invisibleblock);
		}
	}
	
	public static void RegisterClearGlass()
	{
		if (ModConfig.DisableClearGlass())
		{
			LogHelper.info("Not registering clear glass because of config settings.");
		}
		else
		{
			RegisterHelper.registerBlock(clearglass);
		}
	}
	
	public static void RegisterTestBlock()
	{
		if (ModConfig.DisableTestBlock())
		{
			LogHelper.info("Not registering test block because of config settings");
		}
		else
		{
			RegisterHelper.registerBlock(testblock);
		}
	}
}