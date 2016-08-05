package sneaky.bigbproxies;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import sneaky.bigb.gui.GUIHandler;
import sneaky.bigb.main.BIGB;
import sneaky.bigb.update.CheckForUpdates;

public class CommonProxy
{
	public void init()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(BIGB.instance, new GUIHandler());
	}
}