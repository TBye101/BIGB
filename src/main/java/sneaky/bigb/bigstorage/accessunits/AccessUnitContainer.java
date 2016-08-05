package sneaky.bigb.bigstorage.accessunits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * @author SneakyTactician
 * Controls the actual slots and stuff of the access unit.
 */
public class AccessUnitContainer extends Container
{
	
	public final IInventory Storage;
	public int InventorySize;
	public InventoryPlayer PlayerInv;
	
	/**
	 * The constructor for the AccessUnitContainer class.
	 */
	public AccessUnitContainer(InventoryPlayer PlayerInventory, IInventory Inv) //http://jabelarminecraft.blogspot.com/p/minecraft-modding-containers.html
	{
		this.Storage = Inv;
		this.PlayerInv = PlayerInventory;
		//Adds player inventory slots
        int i;
        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                addSlotToContainer(new Slot(this.PlayerInv, j+i*9+9, 8+j*18, 84+i*18));
            }
        }

        // add hotbar slots
        for (i = 0; i < 9; ++i)
        {
            addSlotToContainer(new Slot(this.PlayerInv, i, 8 + i * 18, 142));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}
	
    @Override
    public void addCraftingToCrafters(ICrafting listener)
    {
        super.addCraftingToCrafters(listener);
    }
	
    /**
     * Looks for changes made in the container, sends them to every listener.
     */
/*    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        
        //Might need to implement this. Don't understand it yet.
    }
   */
    
  //Don't understand this yet
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int slotIndex)
    {
        ItemStack itemStack1 = null;
        Slot slot = (Slot)inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack2 = slot.getStack();
            itemStack1 = itemStack2.copy();

            if (itemStack2.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemStack2.stackSize == itemStack1.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemStack2);
        }

        return itemStack1;
    }
}