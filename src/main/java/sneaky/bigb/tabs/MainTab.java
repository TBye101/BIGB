package sneaky.bigb.tabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import sneaky.bigb.block.ModBlocks;

public class MainTab extends CreativeTabs
{
		String name;
		public MainTab(int par1, String par2Str)
		{
			super(par1, par2Str);
			this.name = par2Str;
		}
		
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
				return Item.getItemFromBlock(ModBlocks.clearglass);
		}
}
