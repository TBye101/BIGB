package sneaky.bigb.lib.auto.create;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

/**
 * @author SneakyTactician
 * A class that helps you automatically create a sword.
 */
public class AutoSword extends ItemSword
{

	/**
	 * The constructor for AutoSword.
	 */
	public AutoSword(ToolMaterial toolmaterial, CreativeTabs creativetab, int mininglevel, String texture, String unlocalizedname)
	{
		super(toolmaterial);
		this.bFull3D = true;
		this.setCreativeTab(creativetab);
		this.setHarvestLevel("sword", mininglevel);
		this.setTextureName(texture);
		this.setUnlocalizedName(unlocalizedname);
	}

}
