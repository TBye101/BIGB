package sneaky.bigb.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.world.WorldManager;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import sneaky.bigb.event.InitEvent;
import sneaky.bigb.event.PostInitEvent;
import sneaky.bigb.event.PreInitEvent;
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
			PreInitEvent e;
			e = new PreInitEvent();
			e.Go(event);

		}

		/**
		 * This is the second pass of logic in this mod.
		 */
		@Mod.EventHandler
		public void init(FMLInitializationEvent event)
		{
			InitEvent e;
			e = new InitEvent();
			e.Go(event);
		}

		/**
		 * This is the third pass of logic in this mod.
		 */
		@Mod.EventHandler
		public void postInit(FMLPostInitializationEvent event)
		{
			PostInitEvent e;
			e = new PostInitEvent();
			e.Go(event);
		}
}