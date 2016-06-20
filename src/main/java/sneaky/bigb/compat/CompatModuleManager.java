package sneaky.bigb.compat;

import cpw.mods.fml.common.Loader;
import sneaky.bigb.compat.extrautilities.ExtraUtilitiesCompat;
import sneaky.bigb.compat.projecte.ProjectECompat;
import sneaky.bigb.helpers.LogHelper;

public class CompatModuleManager
{
	
	public static boolean Minecraft = false;
	public static boolean ProjectE = false;
	public static boolean ExtraUtilities = false;
	
	public static void PreInitAll()
	{
		if (ProjectE)
		{
			ProjectECompat.preInit();	
		}
		
		if (ExtraUtilities)
		{
			ExtraUtilitiesCompat.preInit();
		}
	}
	
	public static void InitAll()
	{
		if (ProjectE)
		{
			ProjectECompat.Init();	
		}
		
		if (ExtraUtilities)
		{
			ExtraUtilitiesCompat.Init();
		}
	}
	
	public static void PostInitAll()
	{
		if (ProjectE)
		{
			ProjectECompat.PostInit();	
		}
		
		if (ExtraUtilities)
		{
			ExtraUtilitiesCompat.postInit();
		}
	}
	
	/**
	 * This method just kicks off a bunch of detection methods.
	 */
	public static void DetectAll()
	{
		DetectMinecraft();
		DetectProjectE();
		DetectExtraUtilities();
	}
	
	public static void DetectExtraUtilities()
	{
		Loader.instance();
		if (Loader.isModLoaded("ExtraUtilities"))
		{
			LogHelper.info("Detected Extra Utilities for mod compatibility");
			ExtraUtilities = true;
		}
		else
		{
			LogHelper.info("Extra Utilities was not detected");
			LogHelper.info("Compat features not enabled for Extra Utilities will not be enabled");
		}
	}
	
	/**
	 * This method detects whether or not the mod "ProjectE" is running
	 */
	public static void DetectProjectE()
	{
		Loader.instance();
		if (Loader.isModLoaded("ProjectE"))
		{
			LogHelper.info("Detected ProjectE for mod compatibility");
			ProjectE = true;
		}
		else
		{
			LogHelper.info("ProjectE was not detected");
			LogHelper.info("Compat features not enabled for ProjectE will not be enabled");
		}	
	}
	
	public static void DetectMinecraft()
	{
		Minecraft = true;
		LogHelper.info("Detected Minecraft for compatability");
	}
	
	
}