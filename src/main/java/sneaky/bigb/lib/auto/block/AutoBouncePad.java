package sneaky.bigb.lib.auto.block;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;


/**
 * @author SneakyTactician
 * This class helps automatically create a bouncepad block, with a few parameters required.
 */
public class AutoBouncePad extends Block
{

	public double BMultiplyer;
	public double MaxVelocity;
	
	/**
	 * This is the constructor for the AutoBouncePad block
	 */
	public AutoBouncePad(float Hardness, float Resistence, int HarvestLevel, String BlockName, CreativeTabs CreativeTab, String TextureName, double BounceMultiplier, double MaxYVelocity)
	{
		super(Material.sponge);
		this.setHardness(Hardness);
		this.setResistance(Resistence);
		this.setLightOpacity(15);
		this.setHarvestLevel("shovel", HarvestLevel);
		this.setStepSound(Blocks.sponge.stepSound);
		this.setBlockName(BlockName);
		this.setCreativeTab(CreativeTab);
		this.lightValue = 0;
		this.useNeighborBrightness = true;
		this.setBlockTextureName(TextureName);
		this.BMultiplyer = BounceMultiplier;
		this.MaxVelocity = MaxYVelocity;
	}
	
	
	/* (non-Javadoc)
	 * @see net.minecraft.block.Block#onFallenUpon(net.minecraft.world.World, int, int, int, net.minecraft.entity.Entity, float)
	 */
	@Override
	public void onFallenUpon(World world, int x, int y, int z, Entity entity, float fl)
	{
		if (entity.motionY < this.MaxVelocity)
		{
			entity.setVelocity(entity.motionX, entity.motionY * this.BMultiplyer, entity.motionZ);
		}
		else
		{
			entity.setVelocity(entity.motionX, MaxVelocity, entity.motionZ);
		}
	}
}