package sneaky.bigb.bigstorage.accessunits;

import java.util.UUID;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sneaky.bigb.bigstorage.BIGStorageNonController;
import sneaky.bigb.bigstorage.IBIGStorage;

/**
 * @author SneakyTactician
 * This block is used to access what is stored in a BIG Storage Network.
 */
public class WoodenAccessUnit extends BIGStorageNonController implements IBIGStorage
{

	public WoodenAccessUnit()
	{
		super(Material.wood);
	}

	@Override
	public void NetworkBlockDestroyed(IBIGStorage block)
	{
		
	}

	@Override
	public void NetworkBlockAdded(IBIGStorage block, World world, int x, int y, int z)
	{
		
	}

	@Override
	public void ItemStackAddedToStorage(ItemStack items)
	{
		
	}

	@Override
	public void ItemStackRemovedFromStorage(ItemStack items)
	{
		
	}

	@Override
	public void LoadFromFile(UUID LoadMe)
	{
		
	}

	@Override
	public void SaveToFile()
	{
		
	}
	
}
