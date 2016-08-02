package sneaky.bigb.event;

import java.util.Random;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.MinecraftForge;
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
		LogHelper.info("BIGB preinit started");
		FMLCommonHandler.instance().bus().register(new EventHandler());
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		CompatModuleManager.DetectAll();
		ModConfig.LoadAll(event);
		Reference.IsConfigLoaded = true;
		ModBlocks.RegisterAll();
		CompatModuleManager.PreInitAll(event);
		ModItems.Reg();
		this.DistinguishBetweenServerAndClient();
		LogHelper.info("BIGB preinit finished");
	}
	
	public void DistinguishBetweenServerAndClient()
	{
		try
		{
			this.IsClient();	
		}
		catch (NoSuchMethodError e)
		{
			
		}
		
		try
		{
			this.IsServer();
		}
		catch (NoSuchMethodError e)
		{
			
		}
		LogHelper.InfoAlways("IsServer = " + Reference.IsServer);
	}
	
	@SideOnly(Side.CLIENT)
	public void IsClient()
	{
		Reference.IsServer = false;
	}
	
	@SideOnly(Side.SERVER)
	public void IsServer()
	{
		Reference.IsServer = true;
	}
}