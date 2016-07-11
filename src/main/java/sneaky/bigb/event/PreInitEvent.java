package sneaky.bigb.event;

import java.util.Random;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import sneaky.bigb.block.ModBlocks;
import sneaky.bigb.compat.CompatModuleManager;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.item.ModItems;
import sneaky.bigb.main.Reference;
import sneaky.bigb.main.Util;

/**
 * @author SneakyTactician
 * A class to handle the FMLPreInitializationEvent.
 */
public class PreInitEvent
{
	public void Go(FMLPreInitializationEvent event)
	{
		LogHelper.info("BIGB (Because I Got Bored) is starting up!");
		Util.rand = new Random();
		FMLCommonHandler.instance().bus().register(new EventHandler());
		LogHelper.info("BIGB preinit started");
		CompatModuleManager.DetectAll();
		ModConfig.LoadAll(event);
		Reference.IsConfigLoaded = true;
		ModBlocks.RegisterAll();
		CompatModuleManager.PreInitAll(event);
		LogHelper.info("BIGB preinit finished");
		ModItems.Reg();
	}
}
