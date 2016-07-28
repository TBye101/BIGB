package sneaky.bigb.compat.extrautilities;

import sneaky.bigb.helpers.LogHelper;

public class ExtraUtilitiesCompat
{
	/**
	 * The first main sweep of logic for Extra Utilities compatibility
	 */
	public static void preInit()
	{
		LogHelper.info("Extra Utilities compat preInit started");
		
		LogHelper.info("Extra Utilities compat preInit finished");
	}
	
	/**
	 * The second main sweep of logic for Extra Utilities compatibility
	 */
	public static void Init()
	{
		LogHelper.info("Extra Utilities compat Init started");
		
		LogHelper.info("Extra Utilities compat Init finished");
	}
	
	/**
	 * The third main sweep of logic for Extra Utilities compatibility
	 */
	public static void postInit()
	{
		LogHelper.info("Extra Utilities compat postInit started");
		ExtraUtilitiesCrafting.RegisterAll();
		LogHelper.info("Extra Utilities compat postInit finished");
	}
}
