package sneaky.bigb.bigstorage.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sneaky.bigb.bigstorage.BIGStorageNonController;
import sneaky.bigb.bigstorage.IBIGStorage;
import sneaky.bigb.bigstorage.controllers.collections.BIGNetworkList;
import sneaky.bigb.bigstorage.controllers.collections.BIGNetworkStorageStackList;

/**
 * @author SneakyTactician
 * This class is an base class for all BIGStorageControllers to inherit from.
 */
public class BIGStorageController extends Block implements IBIGStorage
{
	public int BIGBlockType = NetworkTypes.BigStorageController;
	
	/**
	 * A custom list that stores all of the blocks in the BIG network
	 */
	public BIGNetworkList BlocksInNetwork = new BIGNetworkList();
	
	/**
	 * Contains a storage stack for every item that is being stored by the BIG network.
	 */
	public BIGNetworkStorageStackList ItemsInStorage = new BIGNetworkStorageStackList();
	
	public BigInteger TotalStorageCapacityInTypes;

	/**
	 * The constructor for the BIGStorageController class.
	 */
	public BIGStorageController(Material material)
	{
		super(material);
	}


	@Override
	public void NetworkBlockDestroyed(IBIGStorage block)
	{
		
	}
	
	public void MassSendNetworkBlockDestroyedEvent(IBIGStorage block)
	{
		this.NetworkBlockDestroyed(block);
		
		int i = 0;
		int siz = this.BlocksInNetwork.GetSize();
		
		while (i != siz)
		{
			this.BlocksInNetwork.Get(i).NetworkBlockDestroyed(block);
			i++;
		}
	}

	@Override
	public void NetworkBlockAdded(IBIGStorage block)
	{
		
	}
	
	public void MassSendNetworkBlockAddedEvent(IBIGStorage block)
	{
		this.NetworkBlockAdded(block);
		
		int i = 0;
		int siz = this.BlocksInNetwork.GetSize();
		
		while (i != siz)
		{
			this.BlocksInNetwork.Get(i).NetworkBlockAdded(block);
			i++;
		}
	}

	@Override
	public void ItemStackAddedToStorage(ItemStack items)
	{
		
	}
	
	public void MassSendItemStackAddedToStorageEvent(ItemStack items)
	{
		this.ItemStackAddedToStorage(items);
		
		int i = 0;
		int siz = this.BlocksInNetwork.GetSize();
		
		while (i != siz)
		{
			this.BlocksInNetwork.Get(i).ItemStackAddedToStorage(items);
			i++;
		}
	}

	@Override
	public void ItemStackRemovedFromStorage(ItemStack items)
	{
		
	}
	
	public void MassSendItemStackRemovedFromStorageEvent(ItemStack items)
	{
		this.ItemStackRemovedFromStorage(items);
		
		int i = 0;
		int siz = this.BlocksInNetwork.GetSize();
		
		while (i != siz)
		{
			this.BlocksInNetwork.Get(i).ItemStackRemovedFromStorage(items);
			i++;
		}
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