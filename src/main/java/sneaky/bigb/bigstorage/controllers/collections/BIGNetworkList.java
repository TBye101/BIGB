package sneaky.bigb.bigstorage.controllers.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import sneaky.bigb.bigstorage.IBIGStorage;

/**
 * @author SneakyTactician
 * A list used to store a specific type of block. It is indexed, and uses binary searches to find objects as much as possible.
 */
public class BIGNetworkList
{
	
	/**
	 * This list holds all of the blocks in the BIG network. It is sorted automatically when an object is added and removed from it via the public methods.
	 */
	private List<IBIGStorage> NetworkList = new ArrayList<IBIGStorage>();
	
	/**
	 * Used by binary searches, search based on the UUID.
	 */
	private BIGNetworkListComparator Comp1 = new BIGNetworkListComparator();
	
	/**
	 * @param block The block that is being added to the list.
	 * Adds a BIG network block to the list, and sorts the list.
	 */
	public void Add(IBIGStorage block) throws Exception
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
	
	public IBIGStorage Get(int at)
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
	public IBIGStorage RemoveAndGet(IBIGStorage block)
	{
		int index = Collections.binarySearch(this.NetworkList, block, this.Comp1);
		
		IBIGStorage ret = this.NetworkList.get(index);
		this.NetworkList.remove(index);
		
		return ret;
	}	
	public IBIGStorage RemoveAndGet(UUID block)
	{
		int i = 0;
		int siz = this.NetworkList.size();
		
		while (i != siz)
		{
			if (this.NetworkList.get(i).ID == block)
			{
				IBIGStorage ret = this.NetworkList.get(i);
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
	public void Remove(IBIGStorage block)
	{
		this.NetworkList.remove(block);
	}	
	public void Remove(UUID block)
	{
		int i = 0;
		int siz = this.NetworkList.size();
		
		while (i != siz)
		{
			if (this.NetworkList.get(i).ID == block)
			{
				this.NetworkList.remove(i);
			}
			i++;
		}
	}
}