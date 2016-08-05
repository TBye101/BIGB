package sneaky.bigb.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sneaky.bigb.bigstorage.accessunits.AccessUnitContainer;
import sneaky.bigb.bigstorage.gui.AccessUnitGUI;

/**
 * @author SneakyTactician
 * Handles all of the GUI's and containers this mod has. Basically just gives the right GUI and container for the right caller.
 */
@SideOnly(Side.CLIENT)
public class GUIHandler implements IGuiHandler
{
	
	//Returns the proper Container based on what is passed in.
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity Entity = world.getTileEntity(x, y, z);
		
		if (Entity != null)
		{
			switch	(ID)
			{
			case 0: 
				return new AccessUnitContainer(player.inventory, (IInventory)Entity);
			}
		}
		else
		{
			return null;
		}
		
		return null;
	}
	
	//Returns the proper GUI based on what is passed in.
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity Entity = world.getTileEntity(x, y, z);
		
		if (Entity != null)
		{
			switch (ID)
			{
			case 0:
				return new AccessUnitGUI(player.inventory, (IInventory)Entity);
			}
		}
		else
		{
			return null;
		}
		
		return null;
	}
	
	public static enum GUIIDS
	{
		AccessUnit(0);
		
		public final int Value;
		GUIIDS(int value)
		{
			this.Value = value;
		}
	}
}
