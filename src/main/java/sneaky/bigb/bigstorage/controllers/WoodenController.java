package sneaky.bigb.bigstorage.controllers;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

/**
 * @author SneakyTactician
 * A class that uses the BIGStorageController class, and is mostly asthetic, BIGStorageController has most of the logic.
 */
public class WoodenController extends BIGStorageController
{

	public WoodenController()
	{
		super(Material.wood);
		this.textureName = Reference.MODID + ":WoodenBIGController";
		this.blockHardness = 5;
		this.blockResistance = 5;
		this.stepSound = Block.soundTypeWood;
		this.setCreativeTab(ModTabs.maintab);
		this.setBlockName("WoodenController");
		this.BIGBlockType = NetworkTypes.BIGStorageStorage;
	}
}