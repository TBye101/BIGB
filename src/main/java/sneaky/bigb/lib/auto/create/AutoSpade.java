package sneaky.bigb.lib.auto.create;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

/**
 * @author SneakyTactician
 * Helps you automatically create a shovel.
 */
public class AutoSpade extends ItemSpade
{
	public AutoSpade(ToolMaterial toolmaterial, CreativeTabs creative, int mininglevel, String Texture, String UnlocalizedName)
	{
		super(toolmaterial);
		this.bFull3D = true;
		this.maxStackSize = 1;
		this.setCreativeTab(creative);
		this.setHarvestLevel("spade", mininglevel);
		this.setTextureName(Texture);
		this.setUnlocalizedName(UnlocalizedName);
	}
}