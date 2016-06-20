package sneaky.bigb.block.glass.clearglass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

public class ClearGlass extends Block
{
	
	public ClearGlass()
	{
		super(Material.glass);
		this.SetStats();
	}
	
	private void SetStats() 
	{
		this.setHardness(5);
		this.setResistance(1);
		this.setLightOpacity(0);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(Block.soundTypeGlass);
		this.setBlockName("ClearGlass");
		this.opaque = true;
		this.setCreativeTab(ModTabs.maintab);
		
		switch (ModConfig.TextureLevel())
		{
		case 1:
			this.textureName = Reference.MODID + ":ClearGlassAllEdges16";
			break;
		case 2:
			this.textureName = Reference.MODID + ":ClearGlassAllEdges32";
			break;
		case 3:
			this.textureName = Reference.MODID + ":ClearGlassAllEdges64";
			break;
		}
	}
	
    public boolean isOpaqueCube()
    {
    	return false;
    }
}