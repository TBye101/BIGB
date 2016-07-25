package sneaky.bigbproxies;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.minecraft.entity.player.EntityPlayer;
import sneaky.bigb.update.CheckForUpdates;

public class ClientProxy extends CommonProxy
{
	public void CheckForUpdates(EntityPlayer player)
	{
		CheckForUpdates a;
		a = new CheckForUpdates();
		a.player = player;
		Thread versionCheckThread = new Thread(a, "Version Check");
		versionCheckThread.start();
	}
}
