package sneaky.bigb.bigstorage.controllers.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.item.Item;

public class BIGNetworkStorageStackList
{
	
	/**
	 * This list holds all of the blocks in the BIG network. It is sorted automatically when an object is added and removed from it via the public methods.
	 */
	private List<StorageStack> NetworkList = new ArrayList<StorageStack>();
	
	/**
	 * Used by binary searches, search based on the UUID.
	 */
	private StorageStackComparator Comp1 = new StorageStackComparator();
	
	/**
	 * @param block The block that is being added to the list.
	 * Adds a BIG network block to the list, and sorts the list.
	 */
	public void Add(StorageStack block) throws Exception
	{
		if (this.NetworkList.size() < 1)
		{
			this.NetworkList.add(block);
			return;
		}
		else
		{
			int insert = Collections.binarySearch(this.NetworkList, block, this.Comp1);
			NetworkList.add(insert, block);
		}
	}
	
	public StorageStack Get(int at)
	{
		return this.NetworkList.get(at);
	}
	
	/**
	 * @return Returns the size of this list.
	 */
	public int GetSize()
	{
		return this.NetworkList.size();
	}
	
	/**
	 * @param block The block that is being removed from the list.
	 * Removes a BIG network block from the list, and sorts the list.
	 * The method with the IBIGStorage parameter is WAY faster, use this if possible.
	 * Returns null if object is not found.
	 */
	public StorageStack RemoveAndGet(StorageStack block)
	{
		int index = Collections.binarySearch(this.NetworkList, block, this.Comp1);
		
		StorageStack ret = this.NetworkList.get(index);
		this.NetworkList.remove(index);
		
		return ret;
	}	
	public StorageStack RemoveAndGet(Item block)
	{
		int i = 0;
		int siz = this.NetworkList.size();
		
		while (i != siz)
		{
			if (this.NetworkList.get(i).TheItem == block)
			{
				StorageStack ret = this.NetworkList.get(i);
				this.NetworkList.remove(i);
				return ret;
			}
			i++;
		}
		return null;
	}
	
	/**
	 * @param block The block to remove.
	 * Removes an object from the network list.
	 * Method with IBIGStorage as a parameter is faster.
	 */
	public void Remove(StorageStack block)
	{
		this.NetworkList.remove(block);
	}	
	public void Remove(Item items)
	{
		int i = 0;
		int siz = this.NetworkList.size();
		
		while (i != siz)
		{
			if (this.NetworkList.get(i).TheItem == items)
			{
				this.NetworkList.remove(i);
			}
			i++;
		}
	}
}
