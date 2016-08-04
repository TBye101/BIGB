package sneaky.bigb.bigstorage.accessunits;

import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sneaky.bigb.bigstorage.BIGStorageNonController;
import sneaky.bigb.bigstorage.IBIGStorage;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

/**
 * @author SneakyTactician
 * This block is used to access what is stored in a BIG Storage Network.
 */
public class WoodenAccessUnit extends AccessUnit implements IBIGStorage
{

	/**
	 * The constructor for the WoodenAccessUnit class.
	 */
	public WoodenAccessUnit()
	{
		super(Material.wood);
		this.setBlockName("WoodenAccessUnit");
		this.setCreativeTab(ModTabs.maintab);
		this.stepSound = Block.soundTypeWood;
		this.useNeighborBrightness = false;
		this.setTickRandomly(false);
	}

	@Override
	public void NetworkBlockDestroyed(IBIGStorage block)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void NetworkBlockAdded(IBIGStorage block, World world, int x, int y, int z)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ItemStackAddedToStorage(ItemStack items)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ItemStackRemovedFromStorage(ItemStack items)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void LoadFromFile(UUID LoadMe)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SaveToFile()
	{
		// TODO Auto-generated method stub
		
	}
	
}
