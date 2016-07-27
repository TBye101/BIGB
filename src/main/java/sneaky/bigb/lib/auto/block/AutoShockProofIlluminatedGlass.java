package sneaky.bigb.lib.auto.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * @author SneakyTactician
 * This class helps automatically construct a glass block which emits light, according to various specifications that are passed in as parameters into the constructor.
 */
public class AutoShockProofIlluminatedGlass extends Block
{
	/**
	 * This is the constructor for the AutoShockProofIlluminatedGlass class.
	 */
	public AutoShockProofIlluminatedGlass(float Hardness, float Resistence, int LightOpacity, int HarvestLevel, SoundType StepSound, String BlockName, CreativeTabs CreativeTab, int LightEmitted, String TextureName)
	{
		super(Material.glass);
		this.setHardness(Hardness);
		this.setResistance(Resistence);
		this.setLightOpacity(LightOpacity);
		this.setHarvestLevel("pickaxe", HarvestLevel);
		this.setStepSound(StepSound);
		this.setBlockName(BlockName);
		this.setCreativeTab(CreativeTab);
		this.lightValue = LightEmitted;
		this.setBlockTextureName(TextureName);
	}
	
    public boolean isOpaqueCube()
    {
    	return false;
    }
}