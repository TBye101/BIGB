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
	private static Configuration config;
	
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
		DisableClearGlass();
		DisableTestBlock();
		DisableInvisibleBlock();
		DisableShockProofClearGlass();
		DisableReinforcedLimeGreenWall();
		ChangeAllStackSizesToX();
		DisableReinforcedYellowWall();
		DisableReinforcedRedWall();
		DisableReinforcedPurpleWall();
		DisableReinforcedPinkWall();
		DisableReinforcedOrangeWall();
		DisableReinforcedLightBlueWall();
		DisableReinforcedDarkBlueWall();
		DisableReinforcedBlueWall();
		DisableAllLoggingAfterConfigIsLoaded();
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
	
	public static boolean DisableReinforcedBlueWall()
	{
		return config.getBoolean("DisableReinforcedBlueWall", "Blocks", false, "If this setting is true, this mod will not register this block");
	}
	
	public static boolean DisableReinforcedDarkBlueWall()
	{
		return config.getBoolean("DisableReinforcedDarkBlueWall", "Blocks", false, "If this setting is true, this mod will not register this block");
	}
	
	public static boolean DisableReinforcedLightBlueWall()
	{
		return config.getBoolean("DisableReinforcedLightBlueWall", "Blocks", false, "If this setting is true, this mod will not register this block");
	}
	
	public static boolean DisableReinforcedOrangeWall()
	{
		return config.getBoolean("DisableReinforcedOrangeWall", "Blocks", false, "If this setting is true, this mod will not register this block");
	}
	
	public static boolean DisableReinforcedPinkWall()
	{
		return config.getBoolean("DisableReinforcedPinkWall", "Blocks", false, "If this setting is true, this mod will not register this block");
	}
	
	public static boolean DisableReinforcedPurpleWall()
	{
		return config.getBoolean("DisableReinforcedPurpleWall", "Blocks", false, "If this setting is true, this mod will not register this block");
	}
	
	public static boolean DisableReinforcedRedWall()
	{
		return config.getBoolean("DisableReinforcedRedWall", "Blocks", false, "If this setting is true, this mod will not register this block");
	}
	
	public static boolean DisableReinforcedYellowWall()
	{
		return config.getBoolean("DisableReinforcedYellowWall", "Blocks", false, "If this setting is true, this mod will not register this block");
	}
	
	public static int ChangeAllStackSizesToX()
	{
		return config.getInt("ChangeAllStackSizesToX", "Other", 0, 0, 64, "This setting changes whether or not this mod will make massive stack changes to all items. If 0, no changes. Any other value will make the changes.");
	}
	
	public static boolean DisableReinforcedLimeGreenWall()
	{
		return config.getBoolean("DisableReinforcedLimeGreenWall", "Blocks", false, "If this is true, then this mod will not register reinforced lime green wall with minecraft.");
	}
	
	public static boolean DisableShockProofClearGlass()
	{
		return config.getBoolean("DisableShockProofClearGlass", "Blocks", false, "If this is true, this mod will disable shock proof glass.");
	}
	
	public static boolean DisableInvisibleBlock()
	{
		return config.getBoolean("DisableInvisibleBlock", "Blocks", false, "If true, this mod will not register the invisible block with Minecraft.");
	}
	
	public static boolean DisableTestBlock()
	{
		return config.getBoolean("DisableTestBlock", "Blocks", true, "If true, this mod will not register the test block with the game. This block has no real purpose, for dev use only.");
	}
	
	public static boolean DisableClearGlass()
	{
		return config.getBoolean("DisableClearGlass", "Blocks", false, "If true, this mod will not register the clear glass block with the game.");
	}
	
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
		return config.getBoolean("DisableChestRailRecipe", "Minecraft", false, "If true, this mod will not do it's changes to the chest recipe");
	}
	
	public static boolean DisablePoweredRailRecipe()
	{
		return config.getBoolean("DisablePoweredRailRecipe", "Minecraft", false, "If true, this mod will not do it's changes to the powered rail recipe");
	}
	
	public static boolean DisableNoteBlockRecipe()
	{
		return config.getBoolean("DisableNoteBlockRecipe", "Minecraft", false, "If true, this mod will not do it's changes to the noteblock recipe");
	}
	
	public static boolean DisableSandStoneRecipe()
	{
		return config.getBoolean("DisableSandStoneRecipe", "Minecraft", false, "If true, this mod will not do it's changes to the sandstone recipe");
	}
	
	public static boolean DisableLeatherRecipe()
	{
		return config.getBoolean("DisableLeatherRecipe", "Minecraft", false, "If true, this mod will not do it's changes to the leather recipe");
	}
	
	public static boolean DisableAnvilRecipe()
	{
		return config.getBoolean("DisableAnvilRecipe", "Minecraft", false, "If true, this mod will not do it's changes to the anvil recipe");
	}
	
	public static boolean DoModIntegrationsIfPossible()
	{
		return config.getBoolean("DoModIntegrations", "Other", true, "If true, this mod will try and change recipes so that to get a tier 2 thing of a mod, you might have to do a tier 1 thing of a similar mod. This also enables more difficult recipes of things.");
	}
}