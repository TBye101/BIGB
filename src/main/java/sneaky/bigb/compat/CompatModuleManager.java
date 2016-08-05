package sneaky.bigb.compat;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import sneaky.bigb.compat.UBC.UBCCompat;
import sneaky.bigb.compat.extrautilities.ExtraUtilitiesCompat;
import sneaky.bigb.compat.nei.NEICompat;
import sneaky.bigb.compat.projecte.ProjectECompat;
import sneaky.bigb.compat.thermal.ThermalExpansionCompat;
import sneaky.bigb.helpers.LogHelper;

/**
 * @author SneakyTactician
 * A class that figures out what compat modules to run, depending on what other mods are present.
 */
public class CompatModuleManager
{
	
	public static boolean Minecraft = false;
	public static boolean ProjectE = false;
	public static boolean ExtraUtilities = false;
	public static boolean UBC = false;
	public static boolean ThermalExpansion = false;
	public static boolean NEI = false;
	
	public static void PreInitAll(FMLPreInitializationEvent event)
	{
		if (ProjectE)
		{
			ProjectECompat.preInit();	
		}
		
		if (ExtraUtilities)
		{
			ExtraUtilitiesCompat.preInit();
		}
		
		if (UBC)
		{
			UBCCompat.PreInit(event);
		}
		
		if (ThermalExpansion)
		{
			ThermalExpansionCompat.preInit(event);
		}
		
		if (NEI)
		{
			NEICompat.preInit();
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
		
		if (UBC)
		{
			UBCCompat.Init();
		}
		
		if (ThermalExpansion)
		{
			ThermalExpansionCompat.Init();
		}
		
		if (NEI)
		{
			NEICompat.Init();
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
		
		if (UBC)
		{
			UBCCompat.PostInit();
		}
		
		if (ThermalExpansion)
		{
			ThermalExpansionCompat.postInit();
		}
		
		if (NEI)
		{
			NEICompat.postInit();
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
		DetectUBC();
		DetectThermalExpansion();
		DetectNEI();
	}
	
	public static void DetectNEI()
	{
		Loader.instance();
		if (Loader.isModLoaded("NotEnoughItems"))
		{
			LogHelper.info("Detected NEI for compatability");
			NEI = true;
		}
		else
		{
			LogHelper.info("NEI was not detected for mod compatibility");
		}
	}
	
	public static void DetectThermalExpansion()
	{
		Loader.instance();
		if (Loader.isModLoaded("ThermalExpansion"))
		{
			LogHelper.info("Detected Thermal Expansion for mod compatibility");
			ThermalExpansion = true;
		}
		else
		{
			LogHelper.info("Thermal Expansion was not detected for mod compatibility");
		}
	}
	
	public static void DetectUBC()
	{
		Loader.instance();
		if (Loader.isModLoaded("Underground Biomes"))
		{
			LogHelper.info("Detected Underground Biomes for mod compatibility");
			UBC = true;
		}
		else
		{
			LogHelper.info("Underground Biomes mod was not detected for mod compatibility");
		}
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