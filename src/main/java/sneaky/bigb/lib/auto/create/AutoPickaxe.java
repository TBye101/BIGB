package sneaky.bigb.lib.auto.create;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

/**
 * @author SneakyTactician
 * This is a class that helps you to automatically creates a pickaxe.
 */
public class AutoPickaxe extends ItemPickaxe
{

	/**
	 * The constructor for AutoPickaxe.
	 */
	public AutoPickaxe(ToolMaterial material, float EfficiencyOnProperMaterial, int maxStackSize, CreativeTabs creativetab, int mininglevel, String texturename, String UnlocalizedName)
	{
		super(material);
		this.bFull3D = true;
		this.efficiencyOnProperMaterial = EfficiencyOnProperMaterial;
		this.maxStackSize = 1;
		this.setCreativeTab(creativetab);
		this.setHarvestLevel("pickaxe", mininglevel);
		this.setTextureName(texturename);
		this.setUnlocalizedName(UnlocalizedName);
	}
}