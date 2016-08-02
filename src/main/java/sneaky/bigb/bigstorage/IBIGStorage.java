package sneaky.bigb.bigstorage;

import java.util.UUID;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author SneakyTactician
 * A class that defines some universal variables, and some methods that need to be implemented by all blocks part of the BIG storage network.
 */
public interface IBIGStorage
{
	/**
	 * A unique identifier for a block.
	 */
	public UUID ID = UUID.randomUUID();
	
	/**
	 * This is called whenever a block in the storage network is destroyed.
	 */
	public void NetworkBlockDestroyed(IBIGStorage block);
	
	
	/**
	 * This is called whenever a block is added to the network.
	 */
	public void NetworkBlockAdded(IBIGStorage block, World world, int x, int y, int z);
	
	/**
	 * Called whenever a itemstack is added to the network storage.
	 */
	public void ItemStackAddedToStorage(ItemStack items);
	
	/**
	 * Called whenever a itemstack is removed from network storage.
	 */
	public void ItemStackRemovedFromStorage(ItemStack items);
	
	
	/**
	 * Called whenever BIGB is loading the BIG storage network from file, and wants to load a specific block. 
	 @param LoadMe is the UUID of the block to load from file.
	 */
	public void LoadFromFile(UUID LoadMe);
	
	/**
	 * Called whenever BIGB is saving the storage network to file, and wants to save a specific block.
	 */
	public void SaveToFile();
}