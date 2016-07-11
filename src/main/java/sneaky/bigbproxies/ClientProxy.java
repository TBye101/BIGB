package sneaky.bigbproxies;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import sneaky.bigb.update.CheckForUpdates;

public class ClientProxy extends CommonProxy
{
	public void CheckForUpdates()
	{
		Thread versionCheckThread = new Thread(new CheckForUpdates(), "Version Check");
		versionCheckThread.start();
	}
}
