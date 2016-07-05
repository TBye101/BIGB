package sneaky.bigb.tabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import sneaky.bigb.block.ModBlocks;
import sneaky.bigb.main.Util;

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
			if (Util.rand.nextInt(1) == 0)
			{
				return Item.getItemFromBlock(ModBlocks.TribaniumOre);
			}
			else
			{
				return Item.getItemFromBlock(ModBlocks.speedblock);
			}
		}
}
