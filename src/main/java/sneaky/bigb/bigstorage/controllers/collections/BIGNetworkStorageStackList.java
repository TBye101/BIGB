package sneaky.bigb.bigstorage.controllers.collections;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
	 * The constructor for the BIGNetworkStorageStackList class.
	 */
	public BIGNetworkStorageStackList()
	{
		
	}
	
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
			
			if (this.NetworkList.get(insert).TheItem == block.TheItem)
			{
				this.NetworkList.get(insert).Siz.add(block.Siz);
			}
			else
			{
				NetworkList.add(insert, block);	
			}
		}
	}
	public void Add(ItemStack items)
	{
		if (items != null)
		{
			StorageStack Items = new StorageStack(items);
			
			if (this.NetworkList.size() < 1)
			{
				this.NetworkList.add(Items);
				return;
			}
			else
			{
				int insert = Collections.binarySearch(this.NetworkList, Items, this.Comp1);
				
				if (this.NetworkList.get(insert).TheItem == items.getItem())
				{
					this.NetworkList.get(insert).Siz.add(Items.Siz);
				}
				else
				{
					NetworkList.add(insert, Items);	
				}
			}
		}
	}
	public void Add(Item item, int NumberToAdd)
	{
		if (item != null)
		{
			StorageStack Items = new StorageStack(item, NumberToAdd);
			
			if (this.NetworkList.size() < 1)
			{
				this.NetworkList.add(Items);
				return;
			}
			else
			{
				int insert = Collections.binarySearch(this.NetworkList, Items, this.Comp1);
				
				if (this.NetworkList.get(insert).TheItem == item)
				{
					this.NetworkList.get(insert).Siz.add(Items.Siz);
				}
				else
				{
					NetworkList.add(insert, Items);	
				}
			}
		}
	}
	
	/**
	 * Returns the storage stack at the specified index. Returns null if the index is not part of the list.
	 */
	public StorageStack Get(int at)
	{
		if (at > this.NetworkList.size())
		{
			return null;
		}
		else
		{
		return this.NetworkList.get(at);
		}
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
	 * Removes a BIG network StorageStack from the list, and sorts the list.
	 * Removes the ENTIRE thing.
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
		if (block != null)
		{
			int index = Collections.binarySearch(this.NetworkList, new StorageStack(new ItemStack(block)), this.Comp1);
			if (this.NetworkList.get(index).TheItem == block)
			{
				StorageStack ret = this.NetworkList.get(index);
				this.NetworkList.remove(index);
				
				return ret;
			}
		}
		return null;
	}
	
	/**
	 * Removes some of the Items specified, and returns that many items.
	 * Returns null if specified item type is not in the list.
	 */
	public StorageStack RemoveSomeAndGet(StorageStack items)
	{
		if (items.TheItem != null)
		{
			int index = Collections.binarySearch(this.NetworkList, items, this.Comp1);
			
			if (this.NetworkList.get(index).TheItem == items.TheItem)
			{
				StorageStack ret = new StorageStack(items.TheItem, items.Siz.intValue());
				this.NetworkList.get(index).Siz.subtract(items.Siz);
				
				if (this.NetworkList.get(index).Siz.intValue() <= 0)
				{
					this.NetworkList.remove(index);
				}
				
				return ret;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
	public StorageStack RemoveSomeAndGet(Item item, int Number)
	{
		if (item != null)
		{
			StorageStack items = new StorageStack(item, Number);
			int index = Collections.binarySearch(this.NetworkList, items, this.Comp1);
			
			if (this.NetworkList.get(index).TheItem == items.TheItem)
			{
				StorageStack ret = new StorageStack(items.TheItem, items.Siz.intValue());
				this.NetworkList.get(index).Siz.subtract(items.Siz);
				
				if (this.NetworkList.get(index).Siz.intValue() <= 0)
				{
					this.NetworkList.remove(index);
				}
				
				return ret;
			}
			else
			{
				return null;
			}
		}
		return null;
	}
	
	/**
	 * @param block The block to remove.
	 * Removes some of the object passed in from the list.
	 */
	public void Remove(Item items, int Number)
	{
		if (items != null)
		{
			StorageStack Items = new StorageStack(items, Number);
			int index = Collections.binarySearch(this.NetworkList, Items, this.Comp1);
			
			if (this.NetworkList.get(index).TheItem == Items.TheItem)
			{
				this.NetworkList.get(index).Siz.subtract(Items.Siz);
				
				if (this.NetworkList.get(index).Siz.intValue() <= 1)
				{
					this.NetworkList.remove(index);
				}
			}
		}
	}
	public void RemoveAll(Item items)
	{
		if (items != null)
		{
			StorageStack Items = new StorageStack(new ItemStack(items));
			
			int index = Collections.binarySearch(this.NetworkList, Items, this.Comp1);
			
			if (this.NetworkList.get(index).TheItem == Items.TheItem)
			{
				this.NetworkList.remove(index);
			}
		}
	}
	
	/**
	 * Returns true if the item type already exists in the list, returns false if it doesn't exist in the list already.
	 */
	public boolean DoesItemTypeExist(Item type)
	{
		if (type != null)
		{
			StorageStack Items = new StorageStack(new ItemStack(type));
			
			int index = Collections.binarySearch(this.NetworkList, Items, this.Comp1);
			
			if (this.NetworkList.get(index).TheItem == type)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Finds the index of the item type in the list. You should call DoesItemTypeExist() first, to make sure it still exists in this list.
	 */
	public int FindStorageStack(Item type)
	{
		StorageStack Items = new StorageStack(new ItemStack(type));
		
		int index = Collections.binarySearch(this.NetworkList, Items, this.Comp1);
		
		return index;
	}
}