package sneaky.bigb.lib.auto.create;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

/**
 * @author SneakyTactician
 * A class that helps you automatically create an axe.
 */
public class AutoAxe extends ItemAxe
{

	/**
	 * The constructor for AutoAxe.
	 */
	public AutoAxe(ToolMaterial toolmaterial, float EfficiencyOnProperMaterial, CreativeTabs creativetab, int mininglevel, String texture, String unlocalizedname)
	{
		super(toolmaterial);
		this.bFull3D = true;
		this.efficiencyOnProperMaterial = EfficiencyOnProperMaterial;
		this.maxStackSize = 1;
		this.setCreativeTab(creativetab);
		this.setHarvestLevel("axe", mininglevel);
		this.setTextureName(texture);
		this.setUnlocalizedName(unlocalizedname);
	}
}