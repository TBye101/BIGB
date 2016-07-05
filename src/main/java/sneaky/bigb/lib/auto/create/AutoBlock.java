package sneaky.bigb.lib.auto.create;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.helpers.RegisterHelper;
import sneaky.bigb.main.Reference;

/**
 * @author SneakyTactician
 * This class automatically creates a block from parameters passed in.
 */
public class AutoBlock extends Block
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
	
	String Top;
	String Bottom;
	String Front;
	String Back;
	String Left;
	String Right;
	String Tex;
	
	boolean MultiSide = false;
	
	boolean isOpaque;
	
	/**
	 * This is the constructor for the AutoBlock class.
	 */
	public AutoBlock(Material material, boolean isOpaqueCube, float Hardness, float Resistence, int LightOpacity, String HarvestTool, int HarvestLevel, SoundType StepSound, String BlockName, CreativeTabs CreativeTab, int LightValue, boolean NeedsRandomTick, boolean UseNeighborBrightness, String TextureName)
	{
		super(material);
		isOpaque = isOpaqueCube;
		this.setHardness(Hardness);
		this.setResistance(Resistence);
		this.setLightOpacity(LightOpacity);
		this.setHarvestLevel(HarvestTool, HarvestLevel);
		this.setStepSound(StepSound);
		this.setBlockName(BlockName);
		this.setCreativeTab(CreativeTab);
		this.lightValue = LightValue;
		this.needsRandomTick = NeedsRandomTick;
		this.useNeighborBrightness = UseNeighborBrightness;
		this.setBlockTextureName(TextureName);
		Tex = TextureName;
	}
	
	public AutoBlock(Material material, boolean isOpaqueCube, float Hardness, float Resistence, int LightOpacity, String HarvestTool, int HarvestLevel, SoundType StepSound, String BlockName, CreativeTabs CreativeTab, int LightValue, boolean NeedsRandomTick, boolean UseNeighborBrightness, String TopTexture, String BottomTexture, String FrontTexture, String BackTexture, String LeftTexture, String RightTexture)
	{
		super(material);
		isOpaque = isOpaqueCube;
		this.setHardness(Hardness);
		this.setResistance(Resistence);
		this.setLightOpacity(LightOpacity);
		this.setHarvestLevel(HarvestTool, HarvestLevel);
		this.setStepSound(StepSound);
		this.setBlockName(BlockName);
		this.setCreativeTab(CreativeTab);
		this.lightValue = LightValue;
		this.needsRandomTick = NeedsRandomTick;
		this.useNeighborBrightness = UseNeighborBrightness;
		Top = TopTexture;
		Bottom = BottomTexture;
		Front = FrontTexture;
		Back = BackTexture;
		Left = LeftTexture;
		Right = RightTexture;
		this.MultiSide = true;
	}
	
    public boolean isOpaqueCube()
    {
    	return isOpaque;
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		if (MultiSide)
		{
			TopIcon = icon.registerIcon(Reference.MODID + ":" + Top);
			BottomIcon = icon.registerIcon(Reference.MODID + ":" + Bottom);
			FrontIcon = icon.registerIcon(Reference.MODID + ":" + Front);
			BackIcon = icon.registerIcon(Reference.MODID + ":" + Back);
			LeftIcon = icon.registerIcon(Reference.MODID + ":" + Left);
			RightIcon = icon.registerIcon(Reference.MODID + ":" + Right);
		}
		else
		{
			TopIcon = icon.registerIcon(Reference.MODID + ":" + Tex);
			BottomIcon = icon.registerIcon(Reference.MODID + ":" + Tex);
			FrontIcon = icon.registerIcon(Reference.MODID + ":" + Tex);
			BackIcon = icon.registerIcon(Reference.MODID + ":" + Tex);
			LeftIcon = icon.registerIcon(Reference.MODID + ":" + Tex);
			RightIcon = icon.registerIcon(Reference.MODID + ":" + Tex);
		}
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
