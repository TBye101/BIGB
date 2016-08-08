package sneaky.bigb.compat.nei;

import codechicken.nei.api.API;
import codechicken.nei.config.Option;
import sneaky.bigb.bigstorage.gui.AccessUnitGUI;
import sneaky.bigb.chat.ChatUtil;
import sneaky.bigb.compat.CompatModuleManager;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.main.Reference;

/**
 * @author SneakyTactician
 * The class that handles all NEI compatibility stuff.
 */
public class NEICompat
{
	/**
	 * The first main sweep of logic for NEI compatibility
	 */
	public static void preInit()
	{
		LogHelper.info("NEI compat preInit started");
		
		LogHelper.info("NEI compat preInit finished");
	}
	
	/**
	 * The second main sweep of logic for NEI compatibility
	 */
	public static void Init()
	{
		LogHelper.info("NEI compat Init started");
		
		LogHelper.info("NEI compat Init finished");
	}
	
	/**
	 * The third main sweep of logic for NEI compatibility
	 */
	public static void postInit()
	{
		LogHelper.info("NEI compat postInit started");
		
			if (CompatModuleManager.NEI)
			{
				//Removes some buttons and stuff that are in the way, that are added by the mod "NEI".
				API.registerNEIGuiHandler(new ModNEIGUIHandler());
			}
		LogHelper.info("NEI compat postInit finished");
	}
}
