package sneaky.bigb.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import sneaky.bigb.compat.CompatModuleManager;
import sneaky.bigb.helpers.LogHelper;

/**
 * @author SneakyTactician
 * This is the configuration logic for my mod.
 */
public class ModConfig
{
	
	/**
	 * This is an instance of a Forge configuration file. 
	 */
	public static Configuration config;
	
	/**
	 * This loads all of the data from the config file.
	 */
	public static void LoadAll(FMLPreInitializationEvent event)
	{
			config = new Configuration(event.getSuggestedConfigurationFile());
			config.getConfigFile();
			config.load();
			config.save();
			config.addCustomCategoryComment("Blocks", "Contains some settings about blocks.");
			config.addCustomCategoryComment("ID", "Some settings to do with ID's");
			config.addCustomCategoryComment("OreGeneration", "Contains some settings that are centered around ore generation");
			config.addCustomCategoryComment("Minecraft", "Contains some settings that affect what this mod does when minecraft is loaded");
			config.addCustomCategoryComment("Other", "Settings that don't fit in any other catagories");
			config.addCustomCategoryComment("ProjectE", "Contains settings which affect ProjectE and this mod.");
			config.addCustomCategoryComment("Extra Utilities", "Adds settings which affect Extra Utilities and this mod.");
			config.addCustomCategoryComment("AutoBlocks", "A section which contains all of the auto blocks for this mod");
			config.addCustomCategoryComment("AutoItem", "A section which contains all of the auto items for this mod");
			config.load();
			config.save();
			Write();
			HandleCompat();
			config.save();
	}
	
	/**
	 * Makes sure that there is at least a default in the config file for each setting.
	 */
	public static void Write()
	{
		DisableAllRecipes();
		TextureLevel();
		EnableClearGlass();
		EnableTestBlock();
		EnableInvisibleBlock();
		EnableShockProofClearGlass();
		EnableReinforcedLimeGreenWall();
		ChangeAllStackSizesToX();
		EnableReinforcedYellowWall();
		EnableReinforcedRedWall();
		EnableReinforcedPurpleWall();
		EnableReinforcedPinkWall();
		EnableReinforcedOrangeWall();
		EnableReinforcedLightBlueWall();
		EnableReinforcedDarkBlueWall();
		EnableReinforcedBlueWall();
		DisableAllLoggingAfterConfigIsLoaded();
		EnableSpeedBlock();
		AutoConfig();
		EnableBIGStorageSystem();
	}
	
	/**
	 * This kicks off all sorts of compatibility checks and config.
	 */
	public static void HandleCompat()
	{
		if (DoModIntegrationsIfPossible())
		{
			if (CompatModuleManager.Minecraft)
			{
				LogHelper.info("Minecraft compat config starting up");
				MinecraftCompatConfig();
				ProjectECompatConfig();
				ExtraUtilitiesCompatConfig();
			}
		}
		else
		{
			LogHelper.info("Not loading up mod compatabilites because the user has disabled it in the config");
		}
	}
	
	/**
	 * This is this mod's config section for compatibility with Minecraft.
	 */
	public static void MinecraftCompatConfig()
	{
		DisableMassRecipeChanges();
		DisableAnvilRecipe();
		DisableLeatherRecipe();
		DisableSandStoneRecipe();
		DisableNoteBlockRecipe();
		DisablePoweredRailRecipe();
		DisableChestRecipe();
	}
	
	/**
	 * This is this mod's config section for compatibility with ProjectE
	 */
	public static void ProjectECompatConfig()
	{
		DisableAllEMC();
	}
	
	public static void AutoConfig()
	{
		EnableTribaniumOre();
		EnableTribaniumIngot();
		EnableFireDiamondCore();
		EnableFireDiamond();
		EnableFireDiamondCoreSurroundedByDiamonds();
		EnableNatureDiamond();
		EnableNatureDiamondCore();
		EnableTribaniumBouncePad();
		EnableTribaniumSpring();
		EnableShockProofIlluminatedGlass();
	}
	
	public static boolean EnableBIGStorageSystem()
	{
		return config.getBoolean("EnableBIGStorageSystem", "Other", true, "If true, BIGB will load the BIG Storage system in to the game");
	}
	
	public static boolean EnableShockProofIlluminatedGlass()
	{
		return config.getBoolean("EnableShockProofIlluminatedGlass", "AutoBlocks", true, "If true, BIGB will register shock proof illuminated glass with Minecraft");
	}
	
	public static boolean EnableTribaniumSpring()
	{
		return config.getBoolean("EnableTribaniumSpring", "AutoItems", true, "If true, BIGB will register the Tribanium Spring with Minecraft");
	}
	
	public static boolean EnableTribaniumBouncePad()
	{
		return config.getBoolean("EnableTribaniumBouncePad", "AutoBlocks", true, "If true, BIGB will register the Tribanium Bounce Pad with Minecraft");
	}
	
	public static boolean EnableNatureDiamondCore()
	{
		return config.getBoolean("EnableNatureDiamondCore", "AutoItems", true, "If true, BIGB will registers the nature diamond core with Minecraft");
	}
	
	public static boolean EnableNatureDiamond()
	{
		return config.getBoolean("EnableNatureDiamond", "AutoItems", true, "If true, BIGB registers the nature diamond item with Minecraft");
	}
	
	public static boolean EnableFireDiamondCoreSurroundedByDiamonds()
	{
		return config.getBoolean("EnableFireDiamondCoreSurroundedByDiamonds", "AutoItems", true, "If true, BIGB will register this item with Minecraft");
	}
	
	public static boolean EnableFireDiamond()
	{
		return config.getBoolean("EnableFireDiamond", "AutoItems", true, "If true, BIGB will register the fire diamond item with Minecraft");
	}
	
	public static boolean EnableFireDiamondCore()
	{
		return config.getBoolean("EnableFireDiamondCore", "AutoItems", true, "If true, BIGB will register the fire diamond core with Minecraft");
	}
	
	public static boolean EnableSpeedBlock()
	{
		return config.getBoolean("EnableSpeedBlock", "Blocks", true, "If true, BIGB will register the speed block with Minecraft");
	}
	
	public static boolean EnableTribaniumOre()
	{
		return config.getBoolean("TribaniumOre", "AutoBlocks", true, "If true, this block will be registered into the game.");
	}
	
	public static boolean EnableTribaniumIngot()
	{
		return config.getBoolean("TribaniumIngot", "AutoItems", true, "If true, this item will be registered into the game");
	}
	
	/**
	 * If true, this mod doesn't log things after the config has been loaded.
	 */
	public static boolean DisableAllLoggingAfterConfigIsLoaded()
	{
		return config.getBoolean("DisableAllLoggingAfterConfigIsLoaded", "Other", true, "If false, this mod gets really chatty, and in larger modpacks can increase the startup time substantially.");
	}
	
	/**
	 * This is this mod's config section for compatibility with Extra Utilities
	 */
	public static void ExtraUtilitiesCompatConfig()
	{
		AddRecipeForActivatedDivisionSigil();
	}
	
	public static boolean AddRecipeForActivatedDivisionSigil()
	{
		return config.getBoolean("AddRecipeForActivatedDivisionSigil", "Extra Utilities", true, "If true, this mod will add a crafting recipe to activate a division sigil. NOTE: This does require a unactivated division sigil to do.");
	}
	
	public static boolean DisableAllEMC()
	{
		return config.getBoolean("DisableAllEMC", "ProjectE", false, "If true, this mod will disable all EMC values");
	}
	
	public static boolean EnableReinforcedBlueWall()
	{
		return config.getBoolean("EnableReinforcedBlueWall", "Blocks", true, "If this setting is false, this mod will not register this block");
	}
	
	public static boolean EnableReinforcedDarkBlueWall()
	{
		return config.getBoolean("EnableReinforcedDarkBlueWall", "Blocks", true, "If this setting is false, this mod will not register this block");
	}
	
	public static boolean EnableReinforcedLightBlueWall()
	{
		return config.getBoolean("EnableReinforcedLightBlueWall", "Blocks", true, "If this setting is false, this mod will not register this block");
	}
	
	public static boolean EnableReinforcedOrangeWall()
	{
		return config.getBoolean("EnableReinforcedOrangeWall", "Blocks", true, "If this setting is false, this mod will not register this block");
	}
	
	public static boolean EnableReinforcedPinkWall()
	{
		return config.getBoolean("EnableReinforcedPinkWall", "Blocks", true, "If this setting is false, this mod will not register this block");
	}
	
	public static boolean EnableReinforcedPurpleWall()
	{
		return config.getBoolean("EnableReinforcedPurpleWall", "Blocks", true, "If this setting is false, this mod will not register this block");
	}
	
	public static boolean EnableReinforcedRedWall()
	{
		return config.getBoolean("EnableReinforcedRedWall", "Blocks", true, "If this setting is false, this mod will not register this block");
	}
	
	public static boolean EnableReinforcedYellowWall()
	{
		return config.getBoolean("EnableReinforcedYellowWall", "Blocks", true, "If this setting is false, this mod will not register this block");
	}
	
	public static int ChangeAllStackSizesToX()
	{
		return config.getInt("ChangeAllStackSizesToX", "Other", 0, 0, 64, "This setting changes whether or not this mod will make massive stack changes to all items. If 0, no changes. Any other value will make the changes.");
	}
	
	public static boolean EnableReinforcedLimeGreenWall()
	{
		return config.getBoolean("EnableReinforcedLimeGreenWall", "Blocks", true, "If this is false, then this mod will not register reinforced lime green wall with minecraft.");
	}
	
	public static boolean EnableShockProofClearGlass()
	{
		return config.getBoolean("EnableShockProofClearGlass", "Blocks", true, "If this is false, this mod will disable shock proof glass.");
	}
	
	public static boolean EnableInvisibleBlock()
	{
		return config.getBoolean("EnableInvisibleBlock", "Blocks", true, "If false, this mod will not register the invisible block with Minecraft.");
	}
	
	public static boolean EnableTestBlock()
	{
		return config.getBoolean("EnableTestBlock", "Blocks", false, "If false, this mod will not register the test block with the game. This block has no real purpose, for dev use only.");
	}
	
	public static boolean EnableClearGlass()
	{
		return config.getBoolean("EnableClearGlass", "Blocks", true, "If false, this mod will not register the clear glass block with the game.");
	}
	//////////////////////////////////////////
	public static int TextureLevel()
	{
		return config.getInt("GraphicsLevel", "Other", 3, 1, 3, "1 means to use 16x textures, 2 is 32x textures, and 3 is 64x textures");
	}
	
	public static boolean DisableAllRecipes()
	{
		return config.getBoolean("DisableAllRecipes", "Other", false, "If this is true, BIGB will remove every recipe it can from the game.");
	}
	
	public static boolean DisableMassRecipeChanges()
	{
		return config.getBoolean("DisableMassRecipeChanges", "Other", false, "If this is true, BIGB will not do mass recipe changes");
	}

	
	public static boolean DisableChestRecipe()
	{
		return config.getBoolean("DisableChestRailRecipe", "Minecraft", true, "If true, this mod will not do it's changes to the chest recipe");
	}
	
	public static boolean DisablePoweredRailRecipe()
	{
		return config.getBoolean("DisablePoweredRailRecipe", "Minecraft", true, "If true, this mod will not do it's changes to the powered rail recipe");
	}
	
	public static boolean DisableNoteBlockRecipe()
	{
		return config.getBoolean("DisableNoteBlockRecipe", "Minecraft", true, "If true, this mod will not do it's changes to the noteblock recipe");
	}
	
	public static boolean DisableSandStoneRecipe()
	{
		return config.getBoolean("DisableSandStoneRecipe", "Minecraft", true, "If true, this mod will not do it's changes to the sandstone recipe");
	}
	
	public static boolean DisableLeatherRecipe()
	{
		return config.getBoolean("DisableLeatherRecipe", "Minecraft", true, "If true, this mod will not do it's changes to the leather recipe");
	}
	
	public static boolean DisableAnvilRecipe()
	{
		return config.getBoolean("DisableAnvilRecipe", "Minecraft", true, "If true, this mod will not do it's changes to the anvil recipe");
	}
	
	public static boolean DoModIntegrationsIfPossible()
	{
		return config.getBoolean("DoModIntegrations", "Other", true, "If true, this mod will try and change recipes so that to get a tier 2 thing of a mod, you might have to do a tier 1 thing of a similar mod. This also enables more difficult recipes of things.");
	}
}