package sneaky.bigb.lib.auto.create;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

/**
 * @author SneakyTactician
 * A class that helps automatically create a hoe.
 */
public class AutoHoe extends ItemHoe
{

	/**
	 * The constructor for the AutoHoe class.
	 */
	public AutoHoe(ToolMaterial toolmaterial, CreativeTabs creativetab, int mininglevel, String texture, String unlocalizedname)
	{
		super(toolmaterial);
		this.bFull3D = true;
		this.maxStackSize = 1;
		this.setCreativeTab(creativetab);
		this.setHarvestLevel("hoe", mininglevel);
		this.setTextureName(texture);
		this.setUnlocalizedName(unlocalizedname);
	}

}
