package sneaky.bigb.block.invisible;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

/**
 * @author SneakyTactician
 * This class is all of the logic for the InvisibleBlock
 */
public class InvisibleBlock extends Block
{
	/**
	 * This is the constructor for the InvisibleBlock class.
	 */
	public InvisibleBlock()
	{
		super(Material.glass);
		this.setLightOpacity(0);
		this.setLightOpacity(100);
		this.opaque = false;
		this.textureName = Reference.MODID + ":Transparent";
		this.blockHardness = .1F;
		this.blockResistance = .1F;
		this.stepSound = Block.soundTypeGlass;
		this.setBlockName("InvisibleBlock");
		this.setCreativeTab(ModTabs.maintab);
	}
	
    /* (non-Javadoc)
     * @see net.minecraft.block.Block#isOpaqueCube()
     */
    public boolean isOpaqueCube()
    {
    	return false;
    }
}