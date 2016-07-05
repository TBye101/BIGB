package sneaky.bigb.block.testblock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import sneaky.bigb.lib.auto.GenTextureOre;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

public class TestBlock extends Block
{
	@SideOnly(Side.CLIENT)
	IIcon TopIcon;
	
	@SideOnly(Side.CLIENT)
	IIcon BottomIcon;
	
	@SideOnly(Side.CLIENT)
	IIcon FrontIcon;
	
	@SideOnly(Side.CLIENT)
	IIcon BackIcon;
	
	@SideOnly(Side.CLIENT)
	IIcon LeftIcon;
	
	@SideOnly(Side.CLIENT)
	IIcon RightIcon;
	
	public TestBlock()
	{
		super(Material.glass);
		this.SetStats();
	}
	
	private void SetStats() 
	{
		this.setBlockName("Test Block");
		this.setCreativeTab(ModTabs.maintab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
			TopIcon = icon.registerIcon(Reference.MODID + ":Top");
			BottomIcon = icon.registerIcon(Reference.MODID + ":Bottom");
			FrontIcon = icon.registerIcon(Reference.MODID + ":Front");
			BackIcon = icon.registerIcon(Reference.MODID + ":Back");
			LeftIcon = icon.registerIcon(Reference.MODID + ":Left");
			RightIcon = icon.registerIcon(Reference.MODID + ":Right");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
			switch (side)
			{
			case 0:
				//Bottom
				return BottomIcon;
			case 1:
				//Top
				return TopIcon;
			case 2:
				//front
				return FrontIcon;
			case 3:
				//back
				return BackIcon;
			case 4:
				//left
				return LeftIcon;
			case 5:
				//right
				return RightIcon;
			}
			return BackIcon;
	}
}
