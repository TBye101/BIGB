package sneaky.bigb.compat.UBC;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import exterminatorJeff.undergroundBiomes.api.UBAPIHook;
import sneaky.bigb.block.ModBlocks;
import sneaky.bigb.main.Reference;

/**
 * @author SneakyTactician
 * A class that is launched whenever the UBC (Underground Biomes Constructs) mod is present
 */
public class UBCCompat
{
	public static void PreInit(FMLPreInitializationEvent event)
	{
		 try
		 {
			 UBAPIHook.ubAPIHook.ubOreTexturizer.setupUBOre(ModBlocks.TribaniumOre, 0, Reference.MODID + ":Tribanium", "Tribanium Ore", event);
		 }
		 catch (Exception e)
		 {
			 // do nothing; Underground Biomes not installed
		 }
		 
		 try 
		 {
			 UBAPIHook.ubAPIHook.ubOreTexturizer.requestUBOreSetup(ModBlocks.TribaniumOre, 0, Reference.MODID + ":Tribanium", "Tribanium Ore");
		 } 
		 catch (Exception e)
		 {
			 // log e.toString() somehow so you will know if you called this at the wrong time.
			 // UB will throw UBOreTexturizer.BlocksAreAlreadySet (a runtime exception) if you do
		 }
	}
	
	public static void Init()
	{
		
	}
	
	public static void PostInit()
	{
		
	}
}