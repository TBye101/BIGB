package sneaky.bigb.tile.entities;

import cpw.mods.fml.common.registry.GameRegistry;
import sneaky.bigb.bigstorage.accessunits.TileEntityAccessUnit;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;

/**
 * @author SneakyTactician
 * Contains and registers all tile entities.
 */
public class ModTileEntities
{
	public static String AccessUnitTileEntityID = "AccessUnitTileEntity";
	
	
	/**
	 * Kicks off methods that register the tile entities.
	 */
	public static void RegisterAll()
	{
		RegisterAccessUnitTileEntity();
	}
	
	/**
	 * Possibly registers the AccessUnitTileEntity
	 */
	public static void RegisterAccessUnitTileEntity()
	{
		if (ModConfig.EnableBIGStorageSystem())
		{
			GameRegistry.registerTileEntity(TileEntityAccessUnit.class, AccessUnitTileEntityID);
		}
		else
		{
			LogHelper.info("Not registering the access unit tile entity due to config settings"); //Registered the tile entity, next we need to "Create a class that extends container" http://jabelarminecraft.blogspot.com/p/minecraft-modding-containers.html
		}
	}
}