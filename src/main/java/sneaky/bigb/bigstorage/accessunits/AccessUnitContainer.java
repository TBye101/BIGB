package sneaky.bigb.bigstorage.accessunits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;

/**
 * @author SneakyTactician
 * Controls the actual slots and stuff of the access unit.
 */
public class AccessUnitContainer extends Container
{
	
	/**
	 * The constructor for the AccessUnitContainer class.
	 */
	public AccessUnitContainer(InventoryPlayer PlayerInventory, IInventory Inv) //http://jabelarminecraft.blogspot.com/p/minecraft-modding-containers.html
	{
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}
	
}