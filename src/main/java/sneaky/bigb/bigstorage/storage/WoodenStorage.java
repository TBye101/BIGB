package sneaky.bigb.bigstorage.storage;

import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import sneaky.bigb.bigstorage.BIGStorageNonController;
import sneaky.bigb.bigstorage.IBIGStorage;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

public class WoodenStorage extends BIGStorageNonController implements IBIGStorage
{

	public WoodenStorage()
	{
		super(Material.wood);
		this.DifferentBlocksThisCanStore = 3;
		this.setBlockTextureName(Reference.MODID + ":WoodenStorage");
		this.blockHardness = 5;
		this.blockResistance = 5;
		this.setBlockName("WoodenStorage");
		this.stepSound = Block.soundTypeWood;
		this.setCreativeTab(ModTabs.maintab);
	}

	@Override
	public void NetworkBlockDestroyed(IBIGStorage block)
	{
		
	}

	@Override
	public void NetworkBlockAdded(IBIGStorage block)
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