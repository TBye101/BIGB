package sneaky.bigb.event;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import sneaky.bigb.compat.CompatModuleManager;
import sneaky.bigb.compat.minecraft.MinecraftCompat;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.crafting.Recipes;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.main.Util;
import sneaky.bigbproxies.ClientProxy;

/**
 * @author SneakyTactician
 * A class to handle the FMLPostInitializationEvent.
 */
public class PostInitEvent
{
	public void Go(FMLPostInitializationEvent event)
	{
		LogHelper.info("BIGB post initialization started");
		MinecraftCompat.Go();
		Recipes.RegisterAll();
		LogHelper.info("BIGB has detected " + Util.GetNumberOfBlocks() + " blocks");
		LogHelper.info("BIGB has detected " + Util.GetNumberOfItems() + " items");
		Recipes.ListAllRecipes();
		LogHelper.info("BIGB has detected " + Util.GetNumberOfRecipes() + " recipes");
		CompatModuleManager.PostInitAll();
		Util.LogAllEntities();
		Util.LogAllModsAcive();
		
		ClientProxy a = new ClientProxy();
		//a.CheckForUpdates();
		
		Util.MassChangeStackSizesForAllNormalItemsAndBlocks(ModConfig.ChangeAllStackSizesToX());
		
		LogHelper.info("BIGB post initialization done");
	}
}