package sneaky.bigb.main;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import sneaky.bigb.block.ModBlocks;
import sneaky.bigb.compat.CompatModuleManager;
import sneaky.bigb.compat.minecraft.MinecraftCompat;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.crafting.Recipes;
import sneaky.bigb.event.EventHandler;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigbproxies.CommonProxy;

/**
 * @author SneakyTactician
 * This is the main mod file for this mod. This is a Minecraft mod, by the way, in case you have not noticed.
 */
@Mod (modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class BIGB
{
		@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
		public static CommonProxy proxy;
		
		@Instance(Reference.MODID)
		public static BIGB instance;
		
		/**
		 * This is the first pass of logic in this mod.
		 */
		@Mod.EventHandler
		public void preInit(FMLPreInitializationEvent event)
		{
			LogHelper.info("BIGB (Because I Got Bored) is starting up!");
			FMLCommonHandler.instance().bus().register(new EventHandler());
			LogHelper.info("BIGB preinit started");
			CompatModuleManager.DetectAll();
			ModConfig.LoadAll(event);
			Reference.IsConfigLoaded = true;
			ModBlocks.RegisterAll();
			CompatModuleManager.PreInitAll();
			LogHelper.info("BIGB preinit finished");
		}

		/**
		 * This is the second pass of logic in this mod.
		 */
		@Mod.EventHandler
		public void init(FMLInitializationEvent event)
		{
			LogHelper.info("BIGB init started");
			CompatModuleManager.InitAll();
			LogHelper.info("BIGB init finished");
		}

		/**
		 * This is the third pass of logic in this mod.
		 */
		@Mod.EventHandler
		public void postInit(FMLPostInitializationEvent event)
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
			Util.MassChangeStackSizesForAllNormalItemsAndBlocks(ModConfig.ChangeAllStackSizesToX());
			LogHelper.info("BIGB post initialization done");
		}
}