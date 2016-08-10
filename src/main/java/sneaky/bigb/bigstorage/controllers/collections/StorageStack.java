package sneaky.bigb.bigstorage.controllers.collections;

import java.math.BigInteger;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class StorageStack
{
	/**
	 * The number of items in this storage stack.
	 */
	public BigInteger Siz;
	
	/**
	 * The item the storage stack is based off of.
	 */
	public Item TheItem;
	
	public StorageStack(ItemStack Items)
	{
		if (Items != null)
		{
			TheItem = Items.getItem();
			Siz.equals(Items.stackSize);
		}
		else
		{
			this.Siz = BigInteger.ZERO;
		}
	}
	public StorageStack(Item Items, int NumberOfItems)
	{
		if (Items != null)
		{
			TheItem = Items;
			Siz = BigInteger.valueOf(NumberOfItems);
		}
		else
		{
			this.Siz = BigInteger.ZERO;
		}
	}
	
	/**
	 * Increases how many items are in this storage stack.
	 */
	public void AddItems(ItemStack items) throws Exception
	{
		if (items != null)
		{
			if (items.getItem() != this.TheItem)
			{
				throw new Exception("Adding the wrong type of items to a storage stack");
			}
			else
			{
				Siz.add(BigInteger.valueOf(items.stackSize));
			}
		}
	}
	
	/**
	 * Increases how many items are in this storage stack.
	 */
	public void AddItems(Item items) throws Exception
	{
		if (items != null)
		{
			if (items != this.TheItem)
			{
				throw new Exception("Adding the wrong type of items to a storage stack");
			}
			else
			{
				Siz.add(BigInteger.valueOf(1));
			}
		}
	}
	
	/**
	 * Removes N number of items from this storage stack.
	 */
	public void Remove(int N)
	{
		Siz.subtract(BigInteger.valueOf(N));
	}
}