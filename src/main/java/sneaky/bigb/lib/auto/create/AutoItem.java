package sneaky.bigb.lib.auto.create;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.helpers.RegisterHelper;
import sneaky.bigb.main.Reference;

/**
 * @author SneakyTactician
 * Helps you autocreate an item. (A basic item)
 */
public class AutoItem extends Item
{
	/**
	 *  The constructor for the AutoItem class.
	 */
	public AutoItem(boolean Render3D, CreativeTabs creative, int MaxStackSize, String texture, String UnlocalizedName)
	{
		super();
		this.bFull3D = Render3D;
		this.setCreativeTab(creative);
		this.setMaxStackSize(MaxStackSize);
		this.setTextureName(Reference.MODID + ":" + texture);
		this.setUnlocalizedName(UnlocalizedName);
	}
}