package sneaky.bigbproxies;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.minecraft.entity.player.EntityPlayer;
import sneaky.bigb.update.CheckForUpdates;

/**
 * @author SneakyTactician
 * Holds a bunch of client side only code.
 */
public class ClientProxy extends CommonProxy
{
	
	/**
	 * Kicks off all client side only code.
	 */
	public void RunClientSideCode()
	{
		
	}
	
	/**
	 * Runs the update checker, to check for updates.
	 */
	public void CheckForUpdates(EntityPlayer player)
	{
		CheckForUpdates a;
		a = new CheckForUpdates();
		a.player = player;
		Thread versionCheckThread = new Thread(a, "Version Check");
		versionCheckThread.start();
	}
}
