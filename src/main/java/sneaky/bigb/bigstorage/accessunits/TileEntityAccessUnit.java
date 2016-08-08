package sneaky.bigb.bigstorage.accessunits;

import codechicken.nei.LayoutManager;
import codechicken.nei.VisiblityData;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sneaky.bigb.bigstorage.controllers.BIGStorageController;
import sneaky.bigb.bigstorage.controllers.collections.StorageStack;
import sneaky.bigb.compat.CompatModuleManager;
import sneaky.bigb.compat.nei.ModNEIGUIHandler;
import sneaky.bigb.error.Errors;
import sneaky.bigb.main.Reference;

/**
 * @author SneakyTactician
 * The tile entity for all access units
 */
public class TileEntityAccessUnit extends TileEntity implements IUpdatePlayerListBox, ISidedInventory
{
	
	/**
	 * Represents the controller object that this block is a part of.
	 */
	public BIGStorageController controller;
	
	/**
	 * The constructor for the TileEntityAccessUnit class.
	 */
	public TileEntityAccessUnit(BIGStorageController TheController)
	{
		this.controller = TheController;
	}
	
	@Override
	public boolean shouldRefresh(Block old, Block Blocknew, int oldMeta, int newMeta, World world, int x, int y, int z)
	{
		return false;
	}

	@Override
	public int getSizeInventory()
	{
		return this.controller.ItemsInStorage.GetSize();
	}

	@Override
	public ItemStack getStackInSlot(int index)
	{
		//Returns a ItemStack of the items in the specified slot.
		
		StorageStack stack;
		ItemStack ret;
		Item TheItem;
		
		TheItem = this.controller.ItemsInStorage.Get(index).TheItem;
		stack = this.controller.ItemsInStorage.RemoveSomeAndGet(TheItem, 64);
		ret = new ItemStack(stack.TheItem, stack.Siz.intValue());
		
		return ret;
	}

	@Override
	public ItemStack decrStackSize(int index, int count)
	{
		//Returns a ItemStack of the items in the specified slot of a specific size.
		
		if (count > 64 || count < 1)
		{
			try
			{
				Errors.ThrowException(Errors.StackSizeInvalidException);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		StorageStack stack;
		ItemStack ret;
		Item TheItem;
		
		TheItem = this.controller.ItemsInStorage.Get(index).TheItem;
		stack = this.controller.ItemsInStorage.RemoveSomeAndGet(TheItem, count);
		ret = new ItemStack(stack.TheItem, stack.Siz.intValue());
		
		return ret;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int Slot)
	{
		//I don't want to ever drop a stack
		return null;
	}

	@Override
	public void setInventorySlotContents(int Slot, ItemStack items)
	{
		//You don't get to override my stacks, only add and remove from them.
		this.controller.ItemsInStorage.Add(items);
	}

	@Override
	public String getInventoryName()
	{
		return "BIG Storage";
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return true;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return true;
	}

	@Override
	public void openInventory()
	{
		
	}

	@Override
	public void closeInventory()
	{
		if (!Reference.IsServer);
		{
			if (CompatModuleManager.NEI)
			{
				//Puts some buttons back
				
			}
		}
	}

	@Override
	public boolean isItemValidForSlot(int Slot, ItemStack Items)
	{
		if (this.controller.ItemsInStorage.DoesItemTypeExist(Items.getItem()) || this.controller.TotalStorageCapacityInTypes.intValue() > this.controller.ItemsInStorage.GetSize())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_)
	{
		int a[] = new int[this.controller.ItemsInStorage.GetSize()];
		
		int i = 0;
		int siz = a.length;
		
		while (i != siz)
		{
			a[i] = i;
			i++;
		}
		
		return a;
	}

	@Override
	public boolean canInsertItem(int Slot, ItemStack Items, int a)
	{
		return this.isItemValidForSlot(Slot, Items);
	}

	@Override
	public boolean canExtractItem(int Slot, ItemStack Items, int a)
	{
		//This assumes that you are extracting only 1 item. This assumption may not be correct, and may need to change.
		if (this.controller.ItemsInStorage.DoesItemTypeExist(Items.getItem()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void update()
	{
		markDirty();
	}
}