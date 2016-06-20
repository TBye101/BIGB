package sneaky.bigb.block.glass.shockproofclearglass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

/**
 * @author SneakyTactician
 * This class is the logic for shock proof glass.
 */
public class ShockProofClearGlass extends Block
{
	/**
	 * This block's constructor.
	 */
	public ShockProofClearGlass()
	{
		super(Material.glass);
		this.SetStats();
	}
	
	/**
	 * Sets all sorts of information about this block.
	 */
	private void SetStats() 
	{
		this.setHardness(5);
		this.setResistance(50);
		this.setHardness(15);
		this.setLightOpacity(0);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(Block.soundTypeGlass);
		this.setBlockName("ShockProofClearGlass");
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
    
    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
    	return true;
    }
}
